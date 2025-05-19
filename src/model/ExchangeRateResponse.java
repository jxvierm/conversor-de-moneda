package model;

import java.util.HashMap;
import java.util.Map;

public class ExchangeRateResponse {
    public String result;
    public Map<String, String> supported_codes = new HashMap<>();
}