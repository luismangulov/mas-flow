/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.MejorUbicacion;

import Algoritmos.Mapa.Mapa;
import Algoritmos.Mapa.Nodo;
import BusinessEntity.FamiliaBE;
import BusinessEntity.PalletBE;
import BusinessEntity.ProductoBE;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.FamiliaBL;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.ZonaBL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

/**
 *
 * @author carlitos
 */
public class AlgoritmoBestFirst {

    private static Mapa mapa;

    //Recibe como entrada un pallet y devuelve la mejor ubicacion
    //maxima cantidad esta en producto
    public static UbicacionBE ejecutar(Mapa mapa, PalletBE pallet)
    {
        setMapa(mapa);

        ProductoBL productoBL = new ProductoBL();
        ProductoBE producto = productoBL.getByIdProducto(pallet.getIdProducto());

        //producto.getIdFamilia()
        FamiliaBL familiaBL = new FamiliaBL();
        FamiliaBE familia = familiaBL.queryByIdFamilia(producto.getIdFamilia());

        //recorre todas las posibles ubicaciones y halla los candidatos
        ArrayList<UbicacionBE> listaPosiblesUbicaciones = new ArrayList<UbicacionBE>();

        for (Nodo nodo : mapa.getListaNodos())
        {
            if (nodo.getItem() != null)
            {
                UbicacionBE ubicacion = (UbicacionBE)nodo.getItem();

                if (ubicacion.getIndActivo().equals("1"))
                {
                    if (ubicacionPerteneceAZona(familia, ubicacion))
                    {
                        listaPosiblesUbicaciones.add(ubicacion);
                    }
                }
                
            }
        }

        if (listaPosiblesUbicaciones.isEmpty()) return null;
        if (listaPosiblesUbicaciones.size()==1) return listaPosiblesUbicaciones.get(0);

          Collections.sort(listaPosiblesUbicaciones,new Comparator<UbicacionBE>() {
             public int compare(UbicacionBE u1, UbicacionBE u2) {
                double distancia1 = distanciaALaPuerta(u1);
                double distancia2 = distanciaALaPuerta(u2);
                return (distancia1<distancia2 ? -1 : (distancia1>distancia2?1 : 0));
             }
          });

//        UbicacionBE mejorUbicacion;
//        mejorUbicacion = listaPosiblesUbicaciones.get(0);
//        for (int i=1; i<listaPosiblesUbicaciones.size(); i++)
//        {
//        }

        return listaPosiblesUbicaciones.get(0);  
    }


    public static PalletBE ejecutar(Mapa mapa, ProductoBE producto)
    {
        setMapa(mapa);

        ArrayList<PalletBE> listaPosiblesPallets = new ArrayList<PalletBE>();

        for (Nodo nodo : mapa.getListaNodos())
        {
            if (nodo.getItem() != null)
            {
                UbicacionBE ubicacion = (UbicacionBE)nodo.getItem();

                PalletBL palletBL = new PalletBL();
                PalletBE pallet = palletBL.getPalletByIdUbicacion(ubicacion.getIdUbicacion());

                if (pallet!=null)
                {
                    if (pallet.getIdProducto().equals(producto.getIdProducto()))
                    {
                      listaPosiblesPallets.add(pallet);
                    }
                }

            }
        }

        if (listaPosiblesPallets.isEmpty()) return null;
        if (listaPosiblesPallets.size()==1) return listaPosiblesPallets.get(0);

          Collections.sort(listaPosiblesPallets,new Comparator<PalletBE>() {
             public int compare(PalletBE p1, PalletBE p2) {
                Date f1 = p1.getFechaVencimiento();
                Date f2 = p2.getFechaVencimiento();
                return (f1.after(f2) ? -1 : (f1.before(f2)?1 : 0));
             }
          });

        return listaPosiblesPallets.get(0);
    }

    private static double distanciaALaPuerta(UbicacionBE u)
    {
//        RackBL rackBL = new RackBL();
//        RackBE rack = rackBL.getByIdRack(u.getIdRack());

        RackBE rack=null;

        for (RackBE r : mapa.getListaRacks())
        {
            if (r.getIdRack().equals(u.getIdRack()))
            {
                rack=r;
                break;
            }
        }

        if (rack==null) return Double.POSITIVE_INFINITY;

        double dx;
        double dy;

        if (rack.getOrientacion().equals("V"))
        {
            dx= mapa.getPosPuertaX() - rack.getPosX();
            dy= mapa.getPosPuertaY() - (rack.getPosY()+u.getColumna()-1);
        }
        else
        {
            dx= mapa.getPosPuertaX() - (rack.getPosX()+u.getColumna()-1);
            dy= mapa.getPosPuertaY() - rack.getPosY();
        }

        double distanciaALaPuerta=Math.sqrt(dx * dx + dy * dy);
        return distanciaALaPuerta;
    }


    public static Mapa getMapa() {
        return mapa;
    }


    public static void setMapa(Mapa aMapa) {
        mapa = aMapa;
    }



    private static boolean ubicacionPerteneceAZona(FamiliaBE familia, UbicacionBE ubicacion)
    {
        //UbicacionBL ubicacionBL = new UbicacionBL();
//        RackBL rackBL = new RackBL();
//        ZonaBL zonaBL = new ZonaBL();
        
        RackBE rack=null;
        for (RackBE r : mapa.getListaRacks())
        {
            if (r.getIdRack().equals(ubicacion.getIdRack()))
            {
                rack=r;
                break;
            }
        }
        if (rack==null) return false;

//        ZonaBE zona = zonaBL.getZona(rackBL.getByIdRack(ubicacion.getIdRack()).getIdZona());

        ZonaBE zona=null;
        for (ZonaBE z : mapa.getListaZonas())
        {
            if (z.getIdZona().equals(rack.getIdZona()))
            {
                zona=z;
                break;
            }
        }
        if (zona==null) return false;

        for (FamiliaBE f : zona.getFamilias())
        {
            if (f.getIdFamilia().equals(familia.getIdFamilia())) return true;
        }

        return false;
    }

}
