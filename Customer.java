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

    public void redeemReward() {
        int rewardCost = 50;

        if (points >= rewardCost) {
            points -= rewardCost;
            System.out.println(name + " redeemed 50 points for a free drink reward!");
            System.out.println("Remaining points: " + points);
        } else {
            System.out.println(name + " does not have enough points to redeem a reward.");
            System.out.println("Current points: " + points);
            System.out.println("Points needed: " + rewardCost);
        }
    }

    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Points: " + points;
    }
}