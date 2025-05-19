package service;

import com.google.gson.Gson;
import model.ConversionResponse;
import model.ExchangeRateResponse;
import util.ApiClient;

public class CurrencyService {
    private final ApiClient apiClient = new ApiClient();
    private final Gson gson = new Gson();

    public void showAvailableCurrencies() {
        try {
            String response = apiClient.get("/codes");
            ExchangeRateResponse rates = gson.fromJson(response, ExchangeRateResponse.class);
            if ("success".equalsIgnoreCase(rates.result)) {
                System.out.println("\nMonedas disponibles:");
                System.out.println(rates.supported_codes);

            } else {
                System.out.println("Error en la respuesta: " + rates.result);
            }
        } catch (Exception e) {
            System.out.println("Error al obtener monedas: " + e.getMessage());
        }
    }

    public void convertCurrency(String from, String to, double amount) {
        try {
            String path = "/pair/" + from + "/" + to + "/" + amount;
            String response = apiClient.get(path);
            ConversionResponse conversion = gson.fromJson(response, ConversionResponse.class);
            if ("success".equalsIgnoreCase(conversion.result)) {
                System.out.println("\nResultado JSON:");
                System.out.println(gson.toJson(conversion));
            } else {
                System.out.println("Error: " + conversion.result);
            }
        } catch (Exception e) {
            System.out.println("Error en conversión: " + e.getMessage());
        }
    }

}
