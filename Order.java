import java.util.*;

public class Order {
    private Customer customer;
    private ArrayList<OrderItem> items;

    public Order(Customer customer) {
        this.customer = customer;
        this.items = new ArrayList<>();
    }

    public void addItem(Drink drink, int quantity, String sugarLevel) {
        items.add(new OrderItem(drink, quantity, sugarLevel));
    }

    public void removeItem(int itemNumber) {
        int index = itemNumber - 1;

        if (index >= 0 && index < items.size()) {
            OrderItem removedItem = items.remove(index);
            System.out.println(removedItem.getDrink().getName() + " was removed from the order.");
        } else {
            System.out.println("Invalid item number.");
        }
    }

    public void adjustQuantity(int itemNumber, int newQuantity) {
        int index = itemNumber - 1;

        if (index >= 0 && index < items.size()) {
            if (newQuantity > 0) {
                items.get(index).setQuantity(newQuantity);
                System.out.println("Quantity updated.");
            } else {
                System.out.println("Quantity must be greater than 0.");
            }
        } else {
            System.out.println("Invalid item number.");
        }
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double calculateTotal() {
        double total = 0;

        for (OrderItem item : items) {
            total += item.getSubtotal();
        }

        return total;
    }

    public int calculateTotalPoints() {
        int totalPoints = 0;

        for (OrderItem item : items) {
            totalPoints += item.calculatePoints();
        }

        return totalPoints;
    }

    public void printOrder() {
        if (items.isEmpty()) {
            System.out.println("Your order is currently empty.");
        } else {
            System.out.println("\n=== Current Order ===");

            for (int i = 0; i < items.size(); i++) {
                System.out.println((i + 1) + ". " + items.get(i));
            }

            System.out.printf("Total: $%.2f\n", calculateTotal());
            System.out.println("Estimated points: " + calculateTotalPoints());
        }
    }

    public void processOrder() {
        int pointsEarned = calculateTotalPoints();
        customer.addPoints(pointsEarned);

        System.out.println("\nOrder confirmed!");
        System.out.println("Customer: " + customer.getName());

        printOrder();

        System.out.println("Points earned: " + pointsEarned);
        System.out.println("Total customer points: " + customer.getPoints());
    }
}
