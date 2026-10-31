package gt.edu.umg.sistema.ordenventa.api;

import gt.edu.umg.sistema.ordenventa.model.OrdenVenta;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {

    @Headers("ngrok-skip-browser-warning: true")
    @POST("api/ordenes-venta")
    Call<String> crearOrdenVenta(@Body OrdenVenta orden);
}
