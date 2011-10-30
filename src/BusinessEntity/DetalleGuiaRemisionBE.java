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
    private ProductoBE producto = new ProductoBE();
   

    /**
     * @return the codigo
     */
    
    public DetalleGuiaRemisionBE(String codigo,int cantidad,String codProducto){
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.producto.setIdProducto(codProducto);
    }
    
    public DetalleGuiaRemisionBE(String codigo,int cantidad,ProductoBE producto){
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.producto = producto;
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
