import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Request {
    public static String  getRawAPI(){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/ec66f1b072a0116cecc0eb20/latest/USD");

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception e) {
            throw new RuntimeException("Error al consulta la API.");
        }
    }

    public static Conversiones getConversiones(){
        String respuesta = getRawAPI();
        JsonObject json = JsonParser.parseString(respuesta).getAsJsonObject();
        JsonObject monedasJson = json.getAsJsonObject("conversion_rates");
        JsonObject lowerCaseJson = new JsonObject();
        for (String key : monedasJson.keySet()) {
            lowerCaseJson.add(key.toLowerCase(), monedasJson.get(key));
        }
        return new Gson().fromJson(lowerCaseJson, Conversiones.class);
    }
}
