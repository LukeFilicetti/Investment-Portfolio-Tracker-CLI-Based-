/**
 * Author: Luke Filicetti
 * Description:
 * This program simulates managing an investment portfolio with mock stock price data.
 * Users can add stocks, view their portfolio, and update stock prices with simulated fluctuations.
 * The stock prices are updated randomly for educational purposes and do not reflect real-world data.
 * 
 * Features:
 * - Add stocks with a symbol, quantity, and purchase price.
 * - View portfolio with profit/loss calculations.
 * - Simulate stock price updates using random fluctuations.
 * 
 * Note: The stock prices are simulated and are not based on real-time data. This program is intended for educational purposes only.
 */

import java.util.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class InvestmentPortfolioTracker {
    private static final List<Stock> portfolio = new ArrayList<>();
    private static final Map<String, BigDecimal> stockPrices = new HashMap<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Investment Portfolio Tracker");
        System.out.println("----------------------------");

        while (true) {
            System.out.println("\n1. Add Stock\n2. View Portfolio\n3. Update Prices\n4. Exit");
            System.out.print("Select an option: ");
            int choice = getIntInput();

            // Clear the newline character left from getIntInput
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStock();
                case 2 -> viewPortfolio();
                case 3 -> updateStockPrices();
                case 4 -> {
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Add stock to portfolio
    private static void addStock() {
        System.out.print("Enter stock symbol (e.g., AAPL): ");
        String symbol = scanner.nextLine().toUpperCase();

        System.out.print("Enter quantity (e.g., 3): ");
        int quantity = getIntInput();

        System.out.print("Enter purchase price (e.g., 400.50): ");
        double price = getDoubleInput();

        BigDecimal purchasePrice = BigDecimal.valueOf(price);
        portfolio.add(new Stock(symbol, quantity, purchasePrice));
        stockPrices.put(symbol, purchasePrice);

        System.out.println(symbol + " added to portfolio.");
    }

    // View the current portfolio and profit/loss for each stock
    private static void viewPortfolio() {
        if (portfolio.isEmpty()) {
            System.out.println("No stocks in portfolio.");
            return;
        }

        System.out.println("\nPortfolio Summary");
        System.out.println("+--------+--------+-------------+-------------+------------+");
        System.out.println("| Symbol | Qty    | Bought at   | Current     | P/L        |");
        System.out.println("+--------+--------+-------------+-------------+------------+");

        for (Stock stock : portfolio) {
            BigDecimal currentPrice = stockPrices.getOrDefault(stock.symbol, stock.purchasePrice);
            BigDecimal investment = stock.purchasePrice.multiply(BigDecimal.valueOf(stock.quantity));
            BigDecimal currentValue = currentPrice.multiply(BigDecimal.valueOf(stock.quantity));
            BigDecimal profitLoss = currentValue.subtract(investment);

            System.out.printf("| %-6s | %-6d | $%-10.2f | $%-10.2f | $%-9.2f |%n",
                    stock.symbol, stock.quantity, stock.purchasePrice, currentPrice, profitLoss);
        }

        System.out.println("+--------+--------+-------------+-------------+------------+");
    }

    // Simulate updating stock prices
    private static void updateStockPrices() {
        System.out.println("Updating stock prices (simulated)...");

        for (Stock stock : portfolio) {
            BigDecimal currentPrice = stockPrices.get(stock.symbol);
            BigDecimal newPrice = currentPrice.multiply(BigDecimal.valueOf(1 + (Math.random() * 0.1 - 0.05))); // Simulate random change ±5%

            stockPrices.put(stock.symbol, newPrice);

            System.out.printf("%s: $%.2f%n", stock.symbol, newPrice);
        }

        System.out.println("Stock prices updated.");
    }

    // Get integer input safely
    private static int getIntInput() {
        int input = 0;
        boolean valid = false;

        while (!valid) {
            try {
                if (scanner.hasNextInt()) {
                    input = scanner.nextInt();
                    valid = true;
                } else {
                    System.out.println("Invalid input! Please enter a valid integer.");
                    scanner.next(); // Clear the invalid input
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid integer.");
                scanner.next(); // Clear the invalid input
            }
        }

        return input;
    }

    // Get double input safely
    private static double getDoubleInput() {
        double input = 0;
        boolean valid = false;

        while (!valid) {
            try {
                if (scanner.hasNextDouble()) {
                    input = scanner.nextDouble();
                    valid = true;
                } else {
                    System.out.println("Invalid input! Please enter a valid number.");
                    scanner.next(); // Clear the invalid input
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid number.");
                scanner.next(); // Clear the invalid input
            }
        }

        return input;
    }
}

// Stock class to represent each stock in the portfolio
class Stock {
    String symbol;
    int quantity;
    BigDecimal purchasePrice;

    Stock(String symbol, int quantity, BigDecimal purchasePrice) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
    }
}
