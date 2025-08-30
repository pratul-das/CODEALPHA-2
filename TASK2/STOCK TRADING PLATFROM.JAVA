import java.util.*;

class Stock {
    String symbol;
    double price;

    Stock(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }
}

public class StockTradingPlatform {
    public static void main(String[] args) {
        // Market data
        Map<String, Stock> market = new HashMap<>();
        market.put("TCS", new Stock("TCS", 3200));
        market.put("INFY", new Stock("INFY", 1500));

        double cashBalance = 100000;
        Map<String, Integer> portfolio = new HashMap<>();

        Scanner sc = new Scanner(System.in);

        System.out.println("📌 Welcome to Stock Trading Platform!");
        System.out.println("Available Market Data:");
        for (Stock s : market.values()) {
            System.out.println(s.symbol + " @ ₹" + s.price);
        }

        // Buy one stock
        System.out.print("\nEnter stock to buy (TCS/INFY): ");
        String symbol = sc.next().toUpperCase();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        if (market.containsKey(symbol)) {
            Stock stock = market.get(symbol);
            double cost = stock.price * qty;
            if (cashBalance >= cost) {
                cashBalance -= cost;
                portfolio.put(symbol, portfolio.getOrDefault(symbol, 0) + qty);
                System.out.println("✅ Bought " + qty + " shares of " + symbol);
            } else {
                System.out.println(" NOT ENOGH BALANCE ");
            }
        } else {
            System.out.println("INVAILD BALANCE ");
        }

        // Show portfolio
        System.out.println("\n Portfolio:");
        double totalValue = cashBalance;
        for (String sym : portfolio.keySet()) {
            int q = portfolio.get(sym);
            double val = q * market.get(sym).price;
            System.out.println(sym + " : " + q + " shares = ₹" + val);
            totalValue += val;
        }
        System.out.println(" Cash Balance: ₹" + cashBalance);
        System.out.println(" Total Portfolio Value: ₹" + totalValue);

        sc.close();
    }
}