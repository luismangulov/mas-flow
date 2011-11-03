/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * GUIMapa.java
 *
 * Created on 02/11/2011, 07:18:04 PM
 */

package Algoritmos.Mapa;

import Algoritmos.RecorridoOptimo.Cromosoma;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.RackBL;
import Util.Configuracion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author carlitos
 */
public class GUIMapa extends javax.swing.JFrame {

    /** Creates new form GUIMapa */
    public GUIMapa() {
        initComponents();
    }

    public GUIMapa(Mapa mapa) {
        this.mapa = mapa;
        calcularFactores();
        initComponents();
        setBounds(new java.awt.Rectangle(0, 0, 1024, 768));
        this.createBufferStrategy(2);
    }

    public GUIMapa(Mapa mapa, ArrayList<UbicacionBE> mejoresUbicaciones) {
        this.mapa = mapa;
        calcularFactores();
        this.mejoresUbicaciones= mejoresUbicaciones;
        initComponents();
        setBounds(new java.awt.Rectangle(0, 0, 1024, 768));
        this.createBufferStrategy(2);
    }
        
    public GUIMapa(Mapa mapa, Cromosoma mejorCromosoma) {
        this.mapa = mapa;
        calcularFactores();
        this.mejorCromosoma = mejorCromosoma;
        initComponents();
        setBounds(new java.awt.Rectangle(0, 0, 1024, 768));
        this.createBufferStrategy(2);
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setTitle("Mapa del almacén");
        setBounds(new java.awt.Rectangle(400, 400, 800, 600));
        setName("mapaFrame"); // NOI18N
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUIMapa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    @Override
    public void paint(Graphics g) {

           Graphics2D g2 = (Graphics2D)g;
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                 RenderingHints.VALUE_ANTIALIAS_ON);
           g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);

           super.paint(g);

           dibujaCoordenadas(g);

           dibujaUbicaciones(g);

           dibujaZonas(g);

           if (mejoresUbicaciones != null) dibujaMejoresUbicaciones(g);

           dibujaLeyenda(g);
    }


    private void dibujaCoordenadas(Graphics g)
    {
        g.setColor(Color.BLACK);

        for (int i=0;i<mapa.getNumX();i++)
        {
            g.drawString(String.valueOf(i), factorX*i+50+(factorX/2), pixelesAncho+factorY+10 );
        }

        for (int j=0;j<mapa.getNumY();j++)
        {
            g.drawString(String.valueOf(j), 25, factorY*j+50+(factorY/2));
        }

    }
    

    private void dibujaUbicaciones(Graphics g)
    {
        for (Nodo nodo : mapa.getListaNodos())
        {
            if (nodo.isNodoInicial())
            {
                g.setColor(Color.ORANGE);
                g.fillRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
                g.drawRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
            }
            else if (nodo.getItem()==null)
            {
                g.setColor(Color.BLACK);
                g.drawRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
            }
            else
            {
                g.setColor(Color.BLACK);
                g.fillRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
                g.drawRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
            }
        }
    }


    private void dibujaZonas(Graphics g)
    {
        for (ZonaBE zona : mapa.getListaZonas())
        {
                g.setColor(Color.BLUE);
                g.drawRect(convertirX(zona.getPosX()), convertirY(zona.getPosY()), factorX*zona.getAncho(), factorY*zona.getLargo());
        }
    }


    private void dibujaMejoresUbicaciones(Graphics g)
    {
        for (UbicacionBE ubicacion : mejoresUbicaciones)
        {
                RackBL rackBL = new RackBL();
                RackBE rack = rackBL.getByIdRack(ubicacion.getIdRack());
                
                g.setColor(Color.RED);
                g.fillRect(convertirX(rack.getPosX()), convertirY(rack.getPosY()+ubicacion.getColumna()-1), factorX, factorY);
                g.drawRect(convertirX(rack.getPosX()), convertirY(rack.getPosY()+ubicacion.getColumna()-1), factorX, factorY);

                g.setColor(Color.WHITE);
                g.drawString(String.valueOf(ubicacion.getFila()),convertirX(rack.getPosX())+(factorX/2), convertirY(rack.getPosY()+ubicacion.getColumna()-1)+(factorY/2));
        }
    }


    private void dibujaLeyenda(Graphics g)
    {

    }

    private void calcularFactores()
    {
        factorX = (pixelesLargo/mapa.getNumX());
        factorY = (pixelesAncho/mapa.getNumY());
    }

    private int convertirX(int x)
    {
        return x*factorX+50;
    }

    private int convertirY(int y)
    {
        return y*factorY+50;
    }


    private Mapa mapa;
    private ArrayList<UbicacionBE> mejoresUbicaciones;
    private Cromosoma mejorCromosoma;

    private int pixelesLargo=800;
    private int pixelesAncho=600;

    private int factorX;
    private int factorY;

}
