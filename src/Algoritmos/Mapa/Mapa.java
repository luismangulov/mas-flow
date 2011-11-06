/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Algoritmos.Mapa;

import Algoritmos.RecorridoOptimo.Cromosoma;
import BusinessEntity.AlmacenBE;
import BusinessEntity.FamiliaBE;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.FamiliaBL;
import BusinessLogic.RackBL;
import BusinessLogic.UbicacionBL;
import BusinessLogic.ZonaBL;
import DataAccess.ZonaDA;
import Util.Configuracion;
import java.util.ArrayList;

/**
 *
 * @author carlitos
 */
public class Mapa {
    
    private ArrayList<Nodo> listaNodos;
    private AlmacenBE almacen;
    private int numX;
    private int numY;
    private int posPuertaX; 
    private int posPuertaY; 
    private int id;

    private ArrayList<ZonaBE> listaZonas;
    private ArrayList<RackBE> listaRacks; 

    public Mapa(AlmacenBE almacen)
    {
        this.almacen = almacen;
        listaRacks = new ArrayList<RackBE>();

        ZonaBL zonaBL = new ZonaBL();
        listaZonas = zonaBL.getZonasByAlmacen(almacen.getIdAlmacen());

        for (ZonaBE z : listaZonas)
        {
            ZonaDA zonaDA = new ZonaDA();
            ArrayList<FamiliaBE> listaFamilias = zonaDA.querryAllFamilias(z.getIdZona());
            z.setFamilias(listaFamilias);
        }

        RackBL rackBL = new RackBL();
        for (ZonaBE zona : listaZonas)
        {
            ArrayList<RackBE> tempRack = rackBL.getRacksByZona(zona.getIdZona());
            for (RackBE rack : tempRack)
            {
                listaRacks.add(rack);
            }
        }

//        numX = (int)(almacen.getLargo()/Configuracion.getLargoPallet());
//        numY = (int)(almacen.getAncho()/Configuracion.getAnchoPallet());

        numX = (int)(almacen.getAncho()/Configuracion.getAnchoPallet());
        numY = (int)(almacen.getLargo()/Configuracion.getLargoPallet());

        listaNodos = new ArrayList<Nodo>();

        id = 1;
        for (RackBE rack : listaRacks)
        {
            llenarUbicacionesRack(rack);
        }        

        posPuertaX=almacen.getPuertaX();
        posPuertaY=almacen.getPuertaY();

        llenarUbicaciones();

    }


    private void llenarUbicaciones()
    {
        for (int i=0;i<numX;i++)
        {
            for (int j=0;j<numY;j++)
            {
                //Nodo nodo = new Nodo(id,x,y,item);
                if ((i == posPuertaX) && (j == posPuertaY))
                {
                    Nodo nodo = new Nodo(id,i,j,null);
                    nodo.setNodoInicial(true);
                    listaNodos.add(nodo);
                    id++;
                }
                else
                {
                    Nodo nodo = new Nodo(id,i,j,null);
                    listaNodos.add(nodo);
                    id++;
                }
            }
        }
    }


    private void llenarUbicacionesRack(RackBE rack)
    {
        UbicacionBL ubicacionBL = new UbicacionBL();
        ArrayList<UbicacionBE> listaUbicacion = ubicacionBL.getUbicacionesByRack(rack.getIdRack(), "3") ;
        
        for (UbicacionBE ubicacion : listaUbicacion)
        {
            //H: horizontal, V:vertical
            if (rack.getOrientacion().equals("V"))
            {
                Nodo nodo = new Nodo(id,rack.getPosX(),rack.getPosY()+ubicacion.getColumna()-1,ubicacion);
                listaNodos.add(nodo);
                id++;
            }
            else
            {
                Nodo nodo = new Nodo(id,rack.getPosX()+ubicacion.getColumna()-1,rack.getPosY(),ubicacion);
                listaNodos.add(nodo);
                id++;
            }
        }
    }


    public void mostrarGraficoMapa()
    {
        GUIMapa guiMapa = new GUIMapa(this);
        guiMapa.setVisible(true);
    }


    public void mostrarGraficoMapa(ArrayList<UbicacionBE> mejoresUbicaciones)
    {
        GUIMapa guiMapa = new GUIMapa(this, mejoresUbicaciones);
        guiMapa.setVisible(true);
    }


    public void mostrarGraficoMapa(ArrayList<Nodo> recorridoOptimo, boolean b)
    {
        GUIMapa guiMapa = new GUIMapa(recorridoOptimo, this);
        guiMapa.setVisible(true);
    }

    
    public int getNumX() {
        return numX;
    }


    public int getNumY() {
        return numY;
    }


    public ArrayList<ZonaBE> getListaZonas() {
        return listaZonas;
    }


    public ArrayList<RackBE> getListaRacks() {
        return listaRacks;
    }

    /**
     * @return the almacen
     */
    public AlmacenBE getAlmacen() {
        return almacen;
    }

    /**
     * @return the listaNodos
     */
    public ArrayList<Nodo> getListaNodos() {
        return listaNodos;
    }

    /**
     * @return the posPuertaX
     */
    public int getPosPuertaX() {
        return posPuertaX;
    }

    /**
     * @return the posPuertaY
     */
    public int getPosPuertaY() {
        return posPuertaY;
    }

    
}
