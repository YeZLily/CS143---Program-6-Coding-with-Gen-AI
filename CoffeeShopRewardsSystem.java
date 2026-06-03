import java.util.*;

public class CoffeeShopRewardsSystem {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        ArrayList<Drink> menu = new ArrayList<>();
        menu.add(new Drink("Latte", 4.50));
        menu.add(new Drink("Americano", 3.25));
        menu.add(new Drink("Matcha Latte", 5.00));
        menu.add(new Drink("Mocha", 4.75));
        menu.add(new Drink("Iced Coffee", 3.50));

        HashMap<Integer, Customer> customers = new HashMap<>();

        customers.put(101, new Customer(101, "Lily"));
        customers.put(102, new Customer(102, "Alex"));
        customers.put(103, new Customer(103, "Maria"));

        boolean running = true;

        while (running) {
            System.out.println("\n=== Coffee Shop Rewards System ===");
            System.out.println("1. Show drink menu");
            System.out.println("2. Buy a drink");
            System.out.println("3. Check customer points");
            System.out.println("4. Redeem points");
            System.out.println("5. Add new customer");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = console.nextInt();

            if (choice == 1) {
                showMenu(menu);

            } else if (choice == 2) {
                System.out.print("Enter customer ID: ");
                int id = console.nextInt();

                if (customers.containsKey(id)) {
                    Customer customer = customers.get(id);

                    showMenu(menu);
                    System.out.print("Choose a drink number: ");
                    int drinkChoice = console.nextInt();

                    if (drinkChoice >= 1 && drinkChoice <= menu.size()) {
                        Drink selectedDrink = menu.get(drinkChoice - 1);
                        Order order = new Order(customer, selectedDrink);
                        order.processOrder();
                    } else {
                        System.out.println("Invalid drink choice.");
                    }

                } else {
                    System.out.println("Customer not found.");
                }

            } else if (choice == 3) {
                System.out.print("Enter customer ID: ");
                int id = console.nextInt();

                if (customers.containsKey(id)) {
                    Customer customer = customers.get(id);
                    System.out.println(customer.getName() + " has " + customer.getPoints() + " points.");
                } else {
                    System.out.println("Customer not found.");
                }

            } else if (choice == 4) {
                System.out.print("Enter customer ID: ");
                int id = console.nextInt();

                if (customers.containsKey(id)) {
                    Customer customer = customers.get(id);
                    customer.redeemReward();
                } else {
                    System.out.println("Customer not found.");
                }

            } else if (choice == 5) {
                System.out.print("Enter new customer ID: ");
                int id = console.nextInt();
                console.nextLine();

                if (customers.containsKey(id)) {
                    System.out.println("A customer with this ID already exists.");
                } else {
                    System.out.print("Enter customer name: ");
                    String name = console.nextLine();

                    customers.put(id, new Customer(id, name));
                    System.out.println("Customer added successfully.");
                }

            } else if (choice == 6) {
                running = false;
                System.out.println("Thank you for using the Coffee Shop Rewards System!");

            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    public static void showMenu(ArrayList<Drink> menu) {
        System.out.println("\n=== Drink Menu ===");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }
}