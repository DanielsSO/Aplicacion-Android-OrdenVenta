package gt.edu.umg.sistema.ordenventa;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import gt.edu.umg.sistema.ordenventa.api.ApiService;
import gt.edu.umg.sistema.ordenventa.api.RetrofitClient;
import gt.edu.umg.sistema.ordenventa.model.DetalleOrdenVentaRequest;
import gt.edu.umg.sistema.ordenventa.model.OrdenVenta;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    EditText etIdCliente, etIdVendedor, etIdProducto, etCantidad;
    Button btnEnviar;
    TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etIdCliente = findViewById(R.id.etIdCliente);
        etIdVendedor = findViewById(R.id.etIdVendedor);
        etIdProducto = findViewById(R.id.etIdProducto);
        etCantidad = findViewById(R.id.etCantidad);
        btnEnviar = findViewById(R.id.btnEnviar);
        tvResultado = findViewById(R.id.tvResultado);

        btnEnviar.setOnClickListener(v -> enviarOrden());
    }

    private void enviarOrden() {

        String textCliente = etIdCliente.getText().toString().trim();
        String textVendedor = etIdVendedor.getText().toString().trim();
        String textProducto = etIdProducto.getText().toString().trim();
        String textCantidad = etCantidad.getText().toString().trim();

        if (textCliente.isEmpty() || textVendedor.isEmpty() || textProducto.isEmpty() || textCantidad.isEmpty()) {
            tvResultado.setText("Completar todos los campos.");
            return;
        }

        long idCliente = Long.parseLong(textCliente);
        long idVendedor = Long.parseLong(textVendedor);
        long idProducto = Long.parseLong(textProducto);
        int cantidad = Integer.parseInt(textCantidad);

        List<DetalleOrdenVentaRequest> detalle = new ArrayList<>();
        detalle.add(new DetalleOrdenVentaRequest(idProducto, cantidad));

        OrdenVenta orden = new OrdenVenta(idCliente, idVendedor, detalle);

        ApiService api = RetrofitClient.getApiService();
        Call<String> call = api.crearOrdenVenta(orden);

        tvResultado.setText("Enviando...");

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (response.isSuccessful()) {
                    tvResultado.setText("Éxito: " + response.body());
                } else {
                    tvResultado.setText("Error del servidor: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                tvResultado.setText("Fallo de conexión: " + t.getMessage());
            }
        });
    }
}