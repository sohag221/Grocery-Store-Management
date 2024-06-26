import java.util.Scanner;

public class GroceryStoreManagement {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("What do you want to do?");
            System.out.println("1. Add Category");
            System.out.println("2. Add Product");
            System.out.println("3. Update Product");
            System.out.println("4. Remove Product");
            System.out.println("5. Delete Category");
            System.out.println("6. Show Product List");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addCategory(manager, scanner);
                    break;
                case 2:
                    addProduct(manager, scanner);
                    break;
                case 3:
                    updateProduct(manager, scanner);
                    break;
                case 4:
                    removeProduct(manager, scanner);
                    break;
                case 5:
                    deleteCategory(manager, scanner);
                    break;
                case 6:
                    showProductList(manager, scanner);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void addCategory(Manager manager, Scanner scanner) {
        System.out.println("Enter new category name:");
        String categoryName = scanner.nextLine();
        manager.addCategory(categoryName);
        System.out.println("Category added successfully.");
    }

    private static void addProduct(Manager manager, Scanner scanner) {
        System.out.println("Enter category name:");
        String category = scanner.nextLine();
        System.out.println("Enter product name:");
        String name = scanner.nextLine();
        System.out.println("Enter product price:");
        double price = scanner.nextDouble();
        System.out.println("Enter product quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        Item item;
        switch (category.toLowerCase()) {
            case "fruit":
                item = new Fruit(name, price, quantity);
                break;
            case "drink":
                item = new Drink(name, price, quantity);
                break;
            case "cosmetic":
                item = new Cosmetic(name, price, quantity);
                break;
            default:
                item = new Item(name, price, quantity) {};
                break;
        }

        manager.addProduct(category, item);
        System.out.println("Product added successfully."); 
    }

    private static void updateProduct(Manager manager, Scanner scanner) {
        System.out.println("Enter category name:");
        String category = scanner.nextLine();
        System.out.println("Enter product name to update:");
        String name = scanner.nextLine();
        System.out.println("Enter new product price:");
        double price = scanner.nextDouble();
        System.out.println("Enter new product quantity:");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // consume newline

        manager.updateProduct(category, name, price, quantity);
        System.out.println("Product updated successfully.");
    }

    private static void removeProduct(Manager manager, Scanner scanner) {
        System.out.println("Enter category name:");
        String category = scanner.nextLine();
        System.out.println("Enter product name to remove:");
        String name = scanner.nextLine();
        manager.removeProduct(category, name);
        System.out.println("Product removed successfully.");
    }

    private static void deleteCategory(Manager manager, Scanner scanner) {
        System.out.println("Enter category name to delete:");
        String category = scanner.nextLine();
        manager.deleteCategory(category);
        System.out.println("Category deleted successfully.");
    }

    private static void showProductList(Manager manager, Scanner scanner) {
        System.out.println("Enter category name to show:");
        String category = scanner.nextLine();
        manager.displayProductsByCategory(category);
    }
}
