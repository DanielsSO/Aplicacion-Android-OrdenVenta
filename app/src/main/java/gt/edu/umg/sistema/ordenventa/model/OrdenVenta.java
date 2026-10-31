package gt.edu.umg.sistema.ordenventa.model;

import java.util.List;

public class OrdenVenta {
    private long idCliente;
    private long idVendedor;
    private List<DetalleOrdenVentaRequest> detalles;

    public OrdenVenta(long idCliente, long idVendedor, List<DetalleOrdenVentaRequest> detalles) {
        this.idCliente = idCliente;
        this.idVendedor = idVendedor;
        this.detalles = detalles;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public long getIdVendedor() {
        return idVendedor;
    }

    public List<DetalleOrdenVentaRequest> getDetalles() {
        return detalles;
    }
}
