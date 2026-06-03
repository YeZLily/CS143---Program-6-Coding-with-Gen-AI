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
            showMainMenu();

            int choice = console.nextInt();
            console.nextLine();

            if (choice == 1) {
                showMenu(menu);
                pause(console);

            } else if (choice == 2) {
                buyDrinks(console, customers, menu);
                pause(console);

            } else if (choice == 3) {
                System.out.print("Enter customer ID: ");
                int id = console.nextInt();
                console.nextLine();

                if (customers.containsKey(id)) {
                    Customer customer = customers.get(id);
                    System.out.println(customer.getName() + " has " + customer.getPoints() + " points.");
                } else {
                    System.out.println("Customer not found.");
                }

                pause(console);

            } else if (choice == 4) {
                System.out.print("Enter customer ID: ");
                int id = console.nextInt();
                console.nextLine();

                if (customers.containsKey(id)) {
                    Customer customer = customers.get(id);
                    customer.redeemReward();
                } else {
                    System.out.println("Customer not found.");
                }

                pause(console);

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

                pause(console);

            } else if (choice == 6) {
                running = false;
                System.out.println("Thank you for using the Coffee Shop Rewards System!");

            } else {
                System.out.println("Invalid option.");
                pause(console);
            }
        }
    }

    public static void buyDrinks(Scanner console, HashMap<Integer, Customer> customers, ArrayList<Drink> menu) {
        System.out.print("Enter customer ID: ");
        int id = console.nextInt();
        console.nextLine();

        if (!customers.containsKey(id)) {
            System.out.println("Customer not found.");
            return;
        }

        Customer customer = customers.get(id);
        Order order = new Order(customer);

        boolean ordering = true;

        while (ordering) {
            System.out.println("\n=== Current Order Menu ===");
            System.out.println("1. Add drink");
            System.out.println("2. Remove drink");
            System.out.println("3. Adjust quantity");
            System.out.println("4. View order");
            System.out.println("5. Confirm order");
            System.out.println("6. Cancel order");
            System.out.print("Choose an option: ");

            int orderChoice = console.nextInt();
            console.nextLine();

            if (orderChoice == 1) {
                showMenu(menu);

                System.out.print("Choose a drink number: ");
                int drinkChoice = console.nextInt();
                console.nextLine();

                if (drinkChoice >= 1 && drinkChoice <= menu.size()) {
                    Drink selectedDrink = menu.get(drinkChoice - 1);

                    System.out.print("Enter quantity: ");
                    int quantity = console.nextInt();
                    console.nextLine();

                    if (quantity <= 0) {
                        System.out.println("Quantity must be greater than 0.");
                    } else {
                        System.out.print("Enter sugar level, for example 0%, 25%, 50%, 75%, or 100%: ");
                        String sugarLevel = console.nextLine();

                        order.addItem(selectedDrink, quantity, sugarLevel);
                        System.out.println("Drink added to order.");
                    }

                } else {
                    System.out.println("Invalid drink choice.");
                }

            } else if (orderChoice == 2) {
                if (order.isEmpty()) {
                    System.out.println("Your order is currently empty.");
                } else {
                    order.printOrder();

                    System.out.print("Enter item number to remove: ");
                    int itemNumber = console.nextInt();
                    console.nextLine();

                    order.removeItem(itemNumber);
                }

            } else if (orderChoice == 3) {
                if (order.isEmpty()) {
                    System.out.println("Your order is currently empty.");
                } else {
                    order.printOrder();

                    System.out.print("Enter item number to adjust: ");
                    int itemNumber = console.nextInt();
                    console.nextLine();

                    System.out.print("Enter new quantity: ");
                    int newQuantity = console.nextInt();
                    console.nextLine();

                    order.adjustQuantity(itemNumber, newQuantity);
                }

            } else if (orderChoice == 4) {
                order.printOrder();

            } else if (orderChoice == 5) {
                if (order.isEmpty()) {
                    System.out.println("You cannot confirm an empty order.");
                } else {
                    order.processOrder();
                    ordering = false;
                }

            } else if (orderChoice == 6) {
                System.out.println("Order canceled.");
                ordering = false;

            } else {
                System.out.println("Invalid option.");
            }
        }
    }

    public static void showMainMenu() {
        System.out.println("\n=== Coffee Shop Rewards System ===");
        System.out.println("1. Show drink menu");
        System.out.println("2. Buy a drink");
        System.out.println("3. Check customer points");
        System.out.println("4. Redeem points");
        System.out.println("5. Add new customer");
        System.out.println("6. Exit");
        System.out.print("Choose an option: ");
    }

    public static void showMenu(ArrayList<Drink> menu) {
        System.out.println("\n=== Drink Menu ===");

        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }
    }

    public static void pause(Scanner console) {
        System.out.println();
        System.out.print("Press Enter to go back to the main menu...");
        console.nextLine();
    }
}
