package bootcamp.core.publico;

import android.content.Context;
import android.widget.TextView;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Funciones {

    public static String primero(String direccion) {
        URL url = null;
        String linea = "";
        int respuesta = 0;
        StringBuilder result = null;
         try {
             url = new URL(direccion);
             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
             respuesta = connection.getResponseCode();
             result = new StringBuilder();
             if (respuesta == HttpURLConnection.HTTP_OK) {
                 InputStream in = new BufferedInputStream(connection.getInputStream());
                 BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                 while ((linea = reader.readLine()) != null) {
                     result.append(linea);
                 }
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
         return result.toString();
    }

    public static int segundo(String response) {
        int res = 0;
        if (response != null) {
            res = 1;
        }
        return res;
    }

    public static void crearArchivo(Context context, String nombreArchivo, String puntoExtension, String contenido) {
        try {
            FileOutputStream fos = null;
            fos = context.openFileOutput(nombreArchivo, Context.MODE_PRIVATE);
            fos.write(contenido.getBytes());
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void leerArchivo(Context context, String nombreArchivo, TextView textView) {
        try {
            FileInputStream fis = context.openFileInput(nombreArchivo);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
            textView.setText(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //recuerda los permisos en Manifest <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
    public static void crearArchivoSd(String nombreArchivo, String puntoExtension, String contenido) {
        try {
            File file = new File("/sdcard/" + nombreArchivo + puntoExtension);
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            OutputStreamWriter osw = new OutputStreamWriter(fos);
            osw.append(contenido);
            osw.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //recuerda los permisos en Manifest <uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
    public static void leerArchivoSd(String nombreArchivo, String puntoExtension, TextView textView) {
        try {
            File file = new File("/sdcard/" + nombreArchivo + puntoExtension);
            FileInputStream fis = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fis));
            String dataRow = "";
            String buffer = "";
            while ((dataRow = br.readLine()) != null) {
                buffer += dataRow;
            }
            textView.setText(buffer.toString());
            fis.close();
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
