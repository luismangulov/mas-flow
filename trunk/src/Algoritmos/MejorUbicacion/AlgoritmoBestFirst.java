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
import BusinessLogic.ProductoBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.ZonaBL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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


    private static double distanciaALaPuerta(UbicacionBE u)
    {
        RackBL rackBL = new RackBL();
        RackBE rack = rackBL.getByIdRack(u.getIdRack());

        double dx= mapa.getPosPuertaX()- rack.getPosX();
        double dy= mapa.getPosPuertaY() - (rack.getPosY()+u.getColumna()-1);
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
        RackBL rackBL = new RackBL();
        ZonaBL zonaBL = new ZonaBL();

        ZonaBE zona = zonaBL.getZona(rackBL.getByIdRack(ubicacion.getIdRack()).getIdZona());

        for (FamiliaBE f : zona.getFamilias())
        {
            if (f.getIdFamilia().equals(familia.getIdFamilia())) return true;
        }

        return false;
    }

}
