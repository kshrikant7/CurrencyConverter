import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/currencyConverter")
public class CurrencyConverterServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        // Get the parameters from the request.
        String amount = request.getParameter("amount");
        String fromCurrency = request.getParameter("fromCurrency");
        String toCurrency = request.getParameter("toCurrency");

        // Perform currency conversion using the CurrencyConverter class.
        double convertedAmount = CurrencyConverter.convert(fromCurrency, toCurrency, Double.parseDouble(amount));

        // Return the converted amount as the response.
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        out.print(convertedAmount);
        out.flush();
    }
}
