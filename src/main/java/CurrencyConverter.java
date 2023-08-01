import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final Map<String, Double> conversionRates;

    static {
        // Initialize the conversion rates for different currencies.
        // You can update these values based on real exchange rates.
        conversionRates = new HashMap<>();
        conversionRates.put("USD", 1.0);
        conversionRates.put("INR", 73.0);
        // Add more currencies and their corresponding conversion rates.
    }

    public static double convert(String fromCurrency, String toCurrency, double amount) {
        double fromRate = conversionRates.getOrDefault(fromCurrency, 1.0);
        double toRate = conversionRates.getOrDefault(toCurrency, 1.0);

        // Convert the amount from the "fromCurrency" to the "toCurrency".
        try {
            return amount * (toRate / fromRate);
        } catch (NullPointerException e) {
            // Handle the exception.
            return -1;
        }
    }
}
