package sdo_parcial;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Client {
    private String url;

    public Client(String url){
        this.url = url;
    }

    public void solicitud() {
        try {
            URL obj = new URL(this.url);
            HttpURLConnection conn = (HttpURLConnection) obj.openConnection();
            conn.setReadTimeout(5000);
            conn.addRequestProperty("Accept-Language", "en-US,en;q=0.8");
            conn.addRequestProperty("User-Agent", "Mozilla");
            conn.addRequestProperty("Referer", "google.com");
            System.out.println("Request URL... "+url);

            boolean redirect = false;
            int status = conn.getResponseCode();
            if (status != HttpURLConnection.HTTP_OK){
                redirect = true;
            }
            System.out.println("Response code: "+ status);
            System.out.println(leer_respuesta(conn));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String leer_respuesta(HttpURLConnection conn) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer html = new StringBuffer();

        while ((inputLine = in.readLine()) != null){
            html.append(inputLine);
        }
        in.close();
        return html.toString();
    }
}
