public class Order {
    private Customer customer;
    private Drink drink;

    public Order(Customer customer, Drink drink) {
        this.customer = customer;
        this.drink = drink;
    }

    public void processOrder() {
        int pointsEarned = drink.calculatePoints();
        customer.addPoints(pointsEarned);

        System.out.println("\nOrder completed!");
        System.out.println("Customer: " + customer.getName());
        System.out.println("Drink: " + drink.getName());
        System.out.println("Price: $" + drink.getPrice());
        System.out.println("Points earned: " + pointsEarned);
        System.out.println("Total points: " + customer.getPoints());
    }
}