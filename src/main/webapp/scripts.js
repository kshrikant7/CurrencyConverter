document.getElementById("convertButton").addEventListener("click", function () {
    const amount = document.getElementById("amount").value;
    const fromCurrency = document.getElementById("fromCurrency").value;
    const toCurrency = document.getElementById("toCurrency").value;

    fetch(`/currencyConverter?amount=${amount}&fromCurrency=${fromCurrency}&toCurrency=${toCurrency}`)
        .then(response => response.text())
        .then(data => {
            if (data === "-1") {
                document.getElementById("result").textContent = "Invalid currency";
            } else {
                document.getElementById("result").textContent = `Result: ${data}`;
            }
        })
        .catch(error => console.error("Error occurred:", error));
});
