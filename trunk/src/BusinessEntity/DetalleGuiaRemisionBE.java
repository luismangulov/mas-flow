/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

/**
 *
 * @author DIEGO
 */
public class DetalleGuiaRemisionBE {
    private String codigo;
    private int cantidad;
    private double subtotal;
    private ProductoBE producto;
   

    /**
     * @return the codigo
     */
    
    public DetalleGuiaRemisionBE(String codigo,int cantidad,double subtotal,String codProducto){
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
        this.producto = null;
        this.producto.setIdProducto(codProducto);
    }
    
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the cantidad
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * @param cantidad the cantidad to set
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * @return the subtotal
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * @param subtotal the subtotal to set
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    /**
     * @return the producto
     */
    public ProductoBE getProducto() {
        return producto;
    }

    /**
     * @param producto the producto to set
     */
    public void setProducto(ProductoBE producto) {
        this.producto = producto;
    }

    /**
     * @return the estado
     */
   
}
