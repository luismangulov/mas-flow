/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BusinessEntity;

import java.util.Date;

/**
 *
 * @author DIEGO
 */
public class DetalleNotaIngresoBE {
     private String codigo;
    private int cantidad;
    private ProductoBE producto = new ProductoBE();
    private Date fechaVencimiento;

    
     public  DetalleNotaIngresoBE(String codigo,int cantidad,String codProducto,Date fecha){
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.producto.setIdProducto(codProducto);
        this.fechaVencimiento = fecha;
     }
     
     public DetalleNotaIngresoBE(String codigo,int cantidad,ProductoBE producto,Date fecha){
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.producto = producto;
        this.fechaVencimiento = fecha; 
    }
    /**
     * @return the codigo
     */
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
     * @return the fechaVencimiento
     */
    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    /**
     * @param fechaVencimiento the fechaVencimiento to set
     */
    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }
}
