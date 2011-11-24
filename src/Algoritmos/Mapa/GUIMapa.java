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
import BusinessEntity.PalletBE;
import BusinessEntity.ProductoBE;
import BusinessEntity.RackBE;
import BusinessEntity.UbicacionBE;
import BusinessEntity.ZonaBE;
import BusinessLogic.PalletBL;
import BusinessLogic.ProductoBL;
import BusinessLogic.RackBL;
import BusinessLogic.ZonaBL;
import java.awt.Font;
import java.awt.Image;import java.awt.geom.AffineTransform;
;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.geom.Line2D;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;


/**
 *
 * @author carlitos
 */
public class GUIMapa extends javax.swing.JFrame {
    private BufferStrategy bf;

    /** Creates new form GUIMapa */
    public GUIMapa() {
        initComponents();
    }

    public GUIMapa(Mapa mapa) {
        this.mapa = mapa;
        calcularFactores();
        initComponents();
        inicializarFrame(mapa);
    }

    public GUIMapa(Mapa mapa, ArrayList<UbicacionBE> mejoresUbicaciones) {
        this.mapa = mapa;
        calcularFactores();
        this.mejoresUbicaciones= mejoresUbicaciones;
        initComponents();
        inicializarFrame(mapa);
    }
       
    public GUIMapa(ArrayList<Nodo> recorridoOptimo, Mapa mapa) {
        this.mapa = mapa;
        calcularFactores();
        this.recorridoOptimo = recorridoOptimo;
        initComponents();
        inicializarFrame(mapa);
    }

    public GUIMapa(Mapa mapa, ArrayList<UbicacionBE> mejoresUbicaciones, ArrayList<Nodo> recorridoOptimo) {
        this.mapa = mapa;
        calcularFactores();
        this.mejoresUbicaciones= mejoresUbicaciones;
        this.recorridoOptimo = recorridoOptimo;
        initComponents();
        inicializarFrame(mapa);
    }

    private void inicializarFrame(Mapa mapa)
    {
        pixelesAncho=1024;
        pixelesLargo=768-75;

        setBounds(new java.awt.Rectangle(0100, 0, pixelesAncho, pixelesLargo));
        this.createBufferStrategy(2);

        scrollbar1.setMaximum((int)(1.13*(mapa.getNumY())));
        scrollbar2.setMaximum((int)(3.83*(mapa.getNumX())));

        pallet = Toolkit.getDefaultToolkit().getImage("src/Iconos/Mantenimientos.png");
        puerta = Toolkit.getDefaultToolkit().getImage("src/Iconos/door.png");
        palletElegido = Toolkit.getDefaultToolkit().getImage("src/Iconos/info.png");

        this.setTitle("Mapa del almacén " + mapa.getAlmacen().getNombre());
        bf = this.getBufferStrategy();

        nivel = 1;
        nivelMax = calcularNivelMax(mapa);

        posXMax = mapa.getNumX();
        posYMax = mapa.getNumY();

        if (nivelMax == 1) jMenuItem2.setEnabled(false);
        jMenuItem3.setEnabled(false);

        actualizarListaNodos();
    }

    private int calcularNivelMax(Mapa mapa)
    {
        int max=0;

        for (RackBE rack : mapa.getListaRacks())
        {
            if (rack.getPisos()>max)
                max = rack.getPisos();
        }

        return max;
    }


    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        jMenuItem1 = new javax.swing.JMenuItem();
        scrollbar1 = new java.awt.Scrollbar();
        scrollbar2 = new java.awt.Scrollbar();

        jPopupMenu1.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                jPopupMenu1PopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        jMenuItem4.setText("Ver Información");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem4);
        jPopupMenu1.add(jSeparator1);

        jMenuItem2.setText("Subir Nivel");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem3.setText("Bajar Nivel");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem3);
        jPopupMenu1.add(jSeparator2);

        jMenuItem1.setText("Marcar Punto");
        jMenuItem1.setName("Marcar"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setTitle("Mapa del almacén");
        setBounds(new java.awt.Rectangle(400, 400, 800, 600));
        setName("mapaFrame"); // NOI18N
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                formMouseMoved(evt);
            }
        });

        scrollbar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        scrollbar1.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                scrollbar1AdjustmentValueChanged(evt);
            }
        });
        getContentPane().add(scrollbar1, java.awt.BorderLayout.LINE_END);

        scrollbar2.setOrientation(java.awt.Scrollbar.HORIZONTAL);
        scrollbar2.addAdjustmentListener(new java.awt.event.AdjustmentListener() {
            public void adjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {
                scrollbar2AdjustmentValueChanged(evt);
            }
        });
        getContentPane().add(scrollbar2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void scrollbar1AdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_scrollbar1AdjustmentValueChanged
        // TODO add your handling code here:
        ajustarGraficoVertical(evt);
    }//GEN-LAST:event_scrollbar1AdjustmentValueChanged

    private void scrollbar2AdjustmentValueChanged(java.awt.event.AdjustmentEvent evt) {//GEN-FIRST:event_scrollbar2AdjustmentValueChanged
        // TODO add your handling code here:
        ajustarGraficoHorizontal(evt);
    }//GEN-LAST:event_scrollbar2AdjustmentValueChanged

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        if (evt.getButton()==evt.BUTTON3)
        {
            evtX=evt.getX();
            evtY=evt.getY();
            jPopupMenu1.show( evt.getComponent(),evt.getX(), evt.getY() );            
        }
    }//GEN-LAST:event_formMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        //Marcar
        mostrarInformacionCuadrado();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        //Bajar nivel
        nivel--;
        if (nivel == 1) jMenuItem3.setEnabled(false);
        jMenuItem2.setEnabled(true);
        actualizarListaNodos();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        //Mostrar información
        mostrarInformacionDialogo();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        //Subir nivel
        nivel++;
        if (nivel == nivelMax) jMenuItem2.setEnabled(false);
        jMenuItem3.setEnabled(true);
        actualizarListaNodos();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jPopupMenu1PopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_jPopupMenu1PopupMenuWillBecomeInvisible
        // TODO add your handling code here:
        repaint();
    }//GEN-LAST:event_jPopupMenu1PopupMenuWillBecomeInvisible

    private void formMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseMoved
        // TODO add your handling code here:
        posX=obtenerX(evt.getX());
        posY=obtenerY(evt.getY());

        //if ((posX<=posXMax)&&(posY<=posYMax))
        //{
            int x=800;
            int y=pixelesLargo - 50 - (int)scrollbar2.getBounds().getHeight();
            int ancho=150;
            int largo=50;

            if (!jPopupMenu1.isVisible()) this.repaint(x, y, ancho, largo);
        //}


    }//GEN-LAST:event_formMouseMoved

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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private java.awt.Scrollbar scrollbar1;
    private java.awt.Scrollbar scrollbar2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void paint(Graphics g)
    {
//        pintar(g);
        Graphics2D g2 = null;

        try {
            //obtenemos uno de los buffers para dibujar
            g2 = (Graphics2D) bf.getDrawGraphics();
            pintar(g2);

        } finally {
            g2.dispose();
        }

//        pintamos el buffer en pantalla
        bf.show();
    }


    public void pintar(Graphics g) {

           Graphics2D g2 = (Graphics2D)g;
           g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                 RenderingHints.VALUE_ANTIALIAS_ON);
           g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION,RenderingHints.VALUE_INTERPOLATION_BICUBIC);

           super.paint(g);

           dibujaUbicaciones(g);

           dibujaZonas(g);

           if (mejoresUbicaciones != null) dibujaMejoresUbicaciones(g);
           if (recorridoOptimo != null) dibujaRecorridoOptimo(g);

           dibujaMarca(g);

           dibujaEtiquetas(g);

           dibujaCuadroInfo(g);           

           if (jPopupMenu1.isVisible()) jPopupMenu1.repaint();

    }
   

    private void dibujaUbicaciones(Graphics g)
    {
        for (Nodo nodo : listaNodos)
        {
            if (nodo.isNodoInicial())
            {
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
                g.drawImage(puerta, convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY, this);
            }
            else if (nodo.getItem()==null)
            {
                g.setColor(Color.LIGHT_GRAY);
                g.drawRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
            }
            else
            {                
                /*if (((UbicacionBE)nodo.getItem()).getIndActivo().equals("2")) */ //g.drawImage(pallet, convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY, this);
                if (((UbicacionBE)nodo.getItem()).getIndActivo().equals("0"))
                {
                    //g.setColor(Color.RED);
                    g.setColor(new Color(255,50,50));
                    g.fillRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
                    g.drawRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
                }
                if (((UbicacionBE)nodo.getItem()).getIndActivo().equals("1"))
                {
                    //g.setColor(Color.BLUE);
                    g.setColor(new Color(70,70,255));
                    g.fillRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
                    g.drawRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
                }
                if (((UbicacionBE)nodo.getItem()).getIndActivo().equals("2"))
                {
                    g.setColor(new Color(40,40,40));
                    g.fillRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
                    g.drawRect(convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY);
                    //g.drawImage(pallet, convertirX(nodo.getX()), convertirY(nodo.getY()), factorX, factorY, this);
                }
            }
        }
    }


    private void dibujaZonas(Graphics g)
    {
        Graphics2D g2d = ( Graphics2D ) g;
        g2d.setPaint( Color.DARK_GRAY );
        Stroke s = g2d.getStroke();
        g2d.setStroke(new BasicStroke(6.0f));

                //new java.awt.Font("Tahoma", 0, 14)
        
        for (ZonaBE zona : mapa.getListaZonas())
        {
           g2d.drawRect(convertirX(zona.getPosX()), convertirY(zona.getPosY()), factorX*zona.getAncho(), factorY*zona.getLargo());
        }

        g2d.setStroke(s);
    }


    private void dibujaEtiquetas(Graphics g)
    {
        Graphics2D g2d = ( Graphics2D ) g;
        
        Stroke s = g2d.getStroke();
        g2d.setStroke(new BasicStroke(6.0f));

        Font f = g2d.getFont();

        g2d.setPaint( Color.DARK_GRAY );
        g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));

        for (ZonaBE zona : mapa.getListaZonas())
        {
           g2d.drawString(zona.getNombre(), convertirX(zona.getPosX()) + (zona.getAncho()*factorX*4)/10 , convertirY(zona.getPosY())+(factorY/10)*8);
        }

        g2d.setPaint( Color.WHITE);
        g2d.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18));
        for (RackBE rack: mapa.getListaRacks())
        {
            if (rack.getOrientacion().equals("V"))
            {
                AffineTransform fontAT = new AffineTransform();
                Font theFont = g2d.getFont();
                
                fontAT.rotate(Math.PI/2);
                Font theDerivedFont = theFont.deriveFont(fontAT);
                g2d.setFont(theDerivedFont);
                g2d.drawString(rack.getIdentificador(), convertirX(rack.getPosX())+(factorX/10)*3, convertirY(rack.getPosY()) + (rack.getColumnas()*factorY*3)/10);

                g2d.setFont(theFont);
            }
            else
            {
                g2d.drawString(rack.getIdentificador(), convertirX(rack.getPosX()) + (rack.getColumnas()*factorX*3)/10, convertirY(rack.getPosY())+(factorY/10)*7);
            }   
        }

        g2d.setFont(f);
        g2d.setStroke(s);
    }


    private void dibujaMejoresUbicaciones(Graphics g)
    {
        for (UbicacionBE ubicacion : mejoresUbicaciones)
        {
                RackBL rackBL = new RackBL();
                RackBE rack = rackBL.getByIdRack(ubicacion.getIdRack());

                if (rack.getOrientacion().equals("V"))
                {
                    g.setColor(Color.ORANGE);
                    g.fillRect(convertirX(rack.getPosX()), convertirY(rack.getPosY()+ubicacion.getColumna()-1), factorX, factorY);
                    g.drawRect(convertirX(rack.getPosX()), convertirY(rack.getPosY()+ubicacion.getColumna()-1), factorX, factorY);
                }
                else
                {
                    g.setColor(Color.ORANGE);
                    g.fillRect(convertirX(rack.getPosX()+ubicacion.getColumna()-1), convertirY(rack.getPosY()), factorX, factorY);
                    g.drawRect(convertirX(rack.getPosX()+ubicacion.getColumna()-1), convertirY(rack.getPosY()), factorX, factorY);                            
                }                
        }
    }


    private void dibujaMarca(Graphics g)
    {
        if (clickX!=-1 && clickY!=-1)
        {
            g.setColor(Color.BLUE);
            g.fillOval(convertirX(clickX)+factorX/4, convertirY(clickY)+factorY/4, factorX/2, factorY/2);
        }

        if (click1X!=-1 && click1Y!=-1)
        {
            g.setColor(Color.BLUE);
            g.fillOval(convertirX(click1X)+factorX/4, convertirY(click1Y)+factorY/4, factorX/2, factorY/2);

            if (click2X!=-1 && click2Y!=-1)
            {
                g.fillOval(convertirX(click2X)+factorX/4, convertirY(click2Y)+factorY/4, factorX/2, factorY/2);
                g.drawLine(convertirX(click1X)+factorX/2, convertirY(click1Y)+factorY/2, convertirX(click2X)+factorX/2, convertirY(click2Y)+factorY/2);

                g.drawLine(convertirX(click1X)+factorX/2, convertirY(click1Y)+factorY/2, convertirX(click2X)+factorX/2, convertirY(click1Y)+factorY/2);
                g.drawLine(convertirX(click1X)+factorX/2, convertirY(click1Y)+factorY/2, convertirX(click1X)+factorX/2, convertirY(click2Y)+factorY/2);
                g.drawLine(convertirX(click2X)+factorX/2, convertirY(click2Y)+factorY/2, convertirX(click1X)+factorX/2, convertirY(click2Y)+factorY/2);
                g.drawLine(convertirX(click2X)+factorX/2, convertirY(click2Y)+factorY/2, convertirX(click2X)+factorX/2, convertirY(click1Y)+factorY/2);
            }
        }
    }


    private void dibujaRecorridoOptimo(Graphics g)
    {
        Graphics2D g2d = ( Graphics2D ) g;
        Stroke s = g2d.getStroke();
        g2d.setStroke(new BasicStroke(4.0f));

        int n=0;

        
        for (int i=0;i<recorridoOptimo.size()-1;i++)
        {
            g.setColor(Color.CYAN);
            g.drawLine(convertirX(recorridoOptimo.get(i).getX())+factorX/2, convertirY(recorridoOptimo.get(i).getY())+factorY/2, convertirX(recorridoOptimo.get(i+1).getX())+factorX/2, convertirY(recorridoOptimo.get(i+1).getY())+factorY/2);

            n++;
        }

        g2d.setStroke(s);
    }


    private void dibujaCuadroInfo(Graphics g)
    {
        Graphics2D g2d = ( Graphics2D ) g;        
        Stroke s = g2d.getStroke();
        g2d.setStroke(new BasicStroke(8.0f));

        int x=800;
        int y=pixelesLargo - 50 - (int)scrollbar2.getBounds().getHeight();
        int ancho=150;
        int largo=50;

        g2d.setPaint(Color.WHITE); //Color.getHSBColor(0.85f, 1.0f, 0.8f)
        g2d.fill3DRect(x, y, ancho, largo, true);

        g2d.setPaint(Color.lightGray);
        g2d.drawRect(x, y, ancho, largo);

        g2d.setPaint(Color.BLACK);
        g2d.drawString("Nivel: " + nivel, x + (int)((ancho/10)*3.5), y + (int)((largo/10)*4));
        if ((posX<posXMax)&&(posY<posYMax)) g2d.drawString("X = " + posX + "  Y = " + posY, x+ancho/4, y + (int)((largo/10)*8));

        g2d.setStroke(s);
    }


    private void ajustarGraficoVertical(java.awt.event.AdjustmentEvent evt)
    {
        offSetY = 35 * (1-scrollbar1.getValue());
        repaint();
    }


    private void ajustarGraficoHorizontal(java.awt.event.AdjustmentEvent evt)
    {
        offSetX = 10 * (1-scrollbar2.getValue());
        repaint();
    }


    private void calcularFactores()
    {
          factorX=40;
          factorY=40;
    }

    private int convertirX(int x)
    {
        return x*factorX+offSetX;
    }

    private int convertirY(int y)
    {
        return y*factorY+offSetY;
    }


    private int obtenerX(int x)
    {
        return (x-offSetX)/factorX;
    }

    private int obtenerY(int y)
    {
        return (y-offSetY)/factorY;
    }


    private Nodo encontrarNodo(int x, int y)
    {
        for (Nodo nodo : listaNodos)
        {
            if ((nodo.getX()==x) && (nodo.getY()==y))
                return nodo;
        }

        return null;
    }


    private void mostrarInformacionDialogo()
    {
        int x;
        int y;
        
        x=obtenerX(evtX);
        y=obtenerY(evtY);

        Nodo nodo = encontrarNodo(x,y);

        clickX=x;
        clickY=y;

        if (nodo==null) return;

        repaint();

        String cadena = "\n"+"Posición X: " + x + "\nPosición Y: " + y;

        if (nodo.getItem()!=null)
        {
            RackBL rackBL = new RackBL();
            ZonaBL zonaBL = new ZonaBL();
            PalletBL palletBL =  new PalletBL();

            UbicacionBE ubicacion = (UbicacionBE)nodo.getItem();
            RackBE rack = rackBL.getByIdRack(ubicacion.getIdRack());
            ZonaBE zona = zonaBL.getZona(rack.getIdZona());
            PalletBE pallet = palletBL.getPalletByIdUbicacion(ubicacion.getIdUbicacion());

            if (pallet != null)
            {
                ProductoBL productoBL = new ProductoBL();
                ProductoBE producto = productoBL.getByIdProducto(pallet.getIdProducto());
                
                if (producto!=null)
                {
                    cadena = "\n"+"Fecha de Vencimiento: " + pallet.getFechaVencimiento() + cadena;
                    cadena = "\n"+"Cantidad: " + producto.getMaxCantPorPallet() + cadena;
                    cadena = "\n"+"Producto: " + producto.getNombre() + cadena;
                    cadena = "\n"+"Pallet: " + pallet.getIdPallet() + cadena;
                }
            }

            cadena = "\n"+"Columna: " + ubicacion.getColumna()+cadena;
            cadena = "\n"+"Piso: "+nivel+cadena;
            cadena = "\n"+"N° Pisos: "+rack.getPisos()+cadena;
            cadena = "\n"+"Rack: "+rack.getIdentificador()+cadena;
            cadena = "Zona: "+zona.getNombre()+cadena;
        }
        else
        {
            ZonaBE zona = devolverZonaPorXY(x,y);
            if (zona != null) cadena = "Zona: "+zona.getNombre()+cadena;
        }

        if (nodo.isNodoInicial()) cadena =cadena + "\n"+"   (Puerta)";

        JOptionPane.showMessageDialog(null,cadena, "Información",JOptionPane.INFORMATION_MESSAGE);
        
        clickX=-1;
        clickY=-1;

        repaint();
    }

    private void mostrarInformacionCuadrado()
    {
        int x;
        int y;

        x=obtenerX(evtX);
        y=obtenerY(evtY);

        int largo;
        int ancho;

        Nodo nodo = encontrarNodo(x,y);
        if (nodo==null) return;

        if (click1X!=-1 && click1Y!=-1)
        {

            click2X=x;
            click2Y=y;
            ancho = Math.abs(click1X-x)+1;
            largo = Math.abs(click1Y-y)+1;
            
            String cadena = "Posición X: " + click1X + "\nPosición Y: " + click1Y+ "\n";
            cadena = cadena + "Ancho : " + ancho + "\nLargo: " + largo;

            repaint();

            JOptionPane.showMessageDialog(null,cadena, "Información",JOptionPane.INFORMATION_MESSAGE);

            repaint();

            click2X=-1;
            click2Y=-1;
            click1X=-1;
            click1Y=-1;
        }
        else
        {
            click1X=x;
            click1Y=y;
            repaint();
        }
        
    }


    private ZonaBE devolverZonaPorXY(int x, int y)
    {
        for (ZonaBE zona : mapa.getListaZonas())
        {
            if ((x>=zona.getPosX()) &&
               (x<=zona.getPosX()+zona.getAncho()-1) &&
               (y>=zona.getPosY()) &&
               (y<=zona.getPosY()+zona.getLargo()-1))
            {
                return zona;
            }
        }
        return null;
    }


    private void actualizarListaNodos()
    {
        ArrayList<Nodo> temp = new ArrayList<Nodo>();
        for ( Nodo nodo : mapa.getListaNodos() )
        {
            if (nodo.getItem()!=null)
            {
                UbicacionBE ubicacion = (UbicacionBE)nodo.getItem();
                if (ubicacion.getFila() == nivel)
                {
                    temp.add(nodo);
                }
            }
            else
            {
                temp.add(nodo);
            }
        }
        listaNodos = temp;
        
        repaint();
    }



    private Mapa mapa;
    private ArrayList<UbicacionBE> mejoresUbicaciones;
    private ArrayList<Nodo> recorridoOptimo;
    private ArrayList<Nodo> listaNodos;

    private int pixelesAncho;
    private int pixelesLargo;

    private int offSetX=10;
    private int offSetY=35;

    private int factorX;
    private int factorY;

    private int evtX=-1;
    private int evtY=-1;

    private int clickX=-1;
    private int clickY=-1;

    private int click1X=-1;
    private int click1Y=-1;
    private int click2X=-1;
    private int click2Y=-1;

    private int nivel;
    private int nivelMax;

    private int posX;
    private int posY;

    private int posXMax;
    private int posYMax;

    Image pallet;
    Image puerta;
    Image palletElegido;


}
