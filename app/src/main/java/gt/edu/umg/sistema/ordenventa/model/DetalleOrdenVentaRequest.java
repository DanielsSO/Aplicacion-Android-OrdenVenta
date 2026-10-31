package gt.edu.umg.sistema.ordenventa.model;

public class DetalleOrdenVentaRequest {

    private long idProducto;
    private int cantidad;

    public DetalleOrdenVentaRequest(long idProducto, int cantidad) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
    }

    public long getIdProducto() {
        return idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }
}