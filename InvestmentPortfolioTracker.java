import java.util.*;

public class InvestmentPortfolioTracker {
    private static final Map<String, Double> stockPrices = new HashMap<>();
    private static final List<Stock> portfolio = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n1. Add Stock\n2. View Portfolio\n3. Update Prices\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> addStock();
                case 2 -> viewPortfolio();
                case 3 -> updateStockPrices();
                case 4 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }
    }

    private static void addStock() {
        System.out.print("Enter stock symbol: ");
        String symbol = scanner.nextLine().toUpperCase();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();
        System.out.print("Enter purchase price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        portfolio.add(new Stock(symbol, quantity, price));
        System.out.println(symbol + " added to portfolio.");
    }

    private static void viewPortfolio() {
        if (portfolio.isEmpty()) {
            System.out.println("No stocks in portfolio.");
            return;
        }
        for (Stock stock : portfolio) {
            double currentPrice = stockPrices.getOrDefault(stock.symbol, stock.purchasePrice);
            double profitLoss = (currentPrice - stock.purchasePrice) * stock.quantity;
            System.out.printf("%s | Qty: %d | Bought at: $%.2f | Current: $%.2f | P/L: $%.2f%n",
                    stock.symbol, stock.quantity, stock.purchasePrice, currentPrice, profitLoss);
        }
    }

    private static void updateStockPrices() {
        for (Stock stock : portfolio) {
            // Placeholder for API call (Replace this with actual API integration)
            stockPrices.put(stock.symbol, stock.purchasePrice * (0.95 + Math.random() * 0.1));
        }
        System.out.println("Stock prices updated.");
    }
}

class Stock {
    String symbol;
    int quantity;
    double purchasePrice;

    Stock(String symbol, int quantity, double purchasePrice) {
        this.symbol = symbol;
        this.quantity = quantity;
        this.purchasePrice = purchasePrice;
    }
}