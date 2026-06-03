public class OrderItem {
    private Drink drink;
    private int quantity;
    private String sugarLevel;

    public OrderItem(Drink drink, int quantity, String sugarLevel) {
        this.drink = drink;
        this.quantity = quantity;
        this.sugarLevel = sugarLevel;
    }

    public Drink getDrink() {
        return drink;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getSugarLevel() {
        return sugarLevel;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubtotal() {
        return drink.getPrice() * quantity;
    }

    public int calculatePoints() {
        return drink.calculatePoints() * quantity;
    }

    public String toString() {
        return drink.getName()
                + " | Quantity: " + quantity
                + " | Sugar: " + sugarLevel
                + " | Subtotal: $" + String.format("%.2f", getSubtotal());
    }
}