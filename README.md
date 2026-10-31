\# App Android - Orden de Venta



Aplicacion Android que permite crear una Orden de Venta y enviarla mediante una peticion POST a la API REST del Sistema de Ventas.



\* Tecnologias

\- Java

\- Retrofit 2.11.0 (consumo de API)

\- Gson y Scalars (conversion de datos)



\* Funcionamiento



1\. El usuario ingresa: ID Cliente, ID Vendedor, ID Producto y Cantidad

2\. Al presionar "Crear Orden de Venta", la app arma el JSON y lo envia por POST

3\. Se muestra en pantalla el resultado (exito o error) que responde la API



\* Configuracion importante



La URL de la API se encuentra en:

app/src/main/java/gt/edu/umg/sistema/ordenventa/api/RetrofitClient.java



Como se usa ngrok para exponer la API durante las pruebas, esta URL cambia cada vez que se reinicia el tunel. Antes de correr la app, actualizar la constante BASE\_URL con la URL activa de ngrok.



\* Como correr el proyecto



1\. Clonar el repositorio

2\. Abrir en Android Studio

3\. Verificar que la API REST este corriendo y expuesta con ngrok

4\. Actualizar la URL en RetrofitClient.java

5\. Ejecutar en un dispositivo o emulador con conexion a internet

