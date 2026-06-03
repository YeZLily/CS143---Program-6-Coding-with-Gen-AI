public class Customer {
    private int customerId;
    private String name;
    private int points;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.points = 0;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public void addPoints(int pointsEarned) {
        points += pointsEarned;
    }

    public boolean hasEnoughPoints(int rewardCost) {
        return points >= rewardCost;
    }

    public void subtractPoints(int pointsUsed) {
        points -= pointsUsed;
    }

    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Points: " + points;
    }
}
