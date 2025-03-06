# Investment Portfolio Tracker (CLI-Based) (Java)
Description:A simple Java CLI app that allows users to track stocks, mutual funds, and crypto investments.

Users can input stock purchases (symbol, quantity, purchase price).

The **Investment Portfolio Tracker** is a simple command-line application that simulates managing a portfolio of stocks. It allows you to:
- Add stocks to the portfolio with their purchase price and quantity.
- View the portfolio with profit/loss information.
- Simulate stock price updates with random fluctuations.

Features

- **Add Stock**: Add a stock symbol, quantity, and purchase price to the portfolio.
- **View Portfolio**: View a summary of your portfolio, including each stock's current value and profit/loss.
- **Update Prices**: Simulate updating stock prices using random fluctuations.

 Limitations

- This program **simulates stock price updates** and does not fetch real data from any stock market APIs. The stock prices fluctuate randomly with a random walk pattern, and the updates are for educational purposes only.
- **Simulated Data**: The stock price simulation is based on random values and may not reflect real-world stock behavior. The program is meant to demonstrate basic portfolio management and how stock prices might affect the portfolio's performance.
  
Requirements
- **JDK 8+**: This program is written in Java, and you need to have a JDK installed to run the code.

Running the Program

1. Clone or download the repository to your local machine.
2. Open the project directory in a terminal.
3. Compile the Java file:

`javac InvestmentPortfolioTracker.java`

4. Run the application:

`java InvestmentPortfolioTracker`

Example Usage
Upon running the application, you will see a menu with the following options:

`1. Add Stock`

`2. View Portfolio`

`3. Update Prices`

`4. Exit`

You can:

- Add a stock: Input a stock symbol, quantity, and purchase price.
- View your portfolio: Get an overview of your portfolio, showing your stocks' details, including profit/loss.
- Update prices: Simulate updating the stock prices with random changes.
- Exit: Quit the application.