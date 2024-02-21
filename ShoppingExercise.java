// Define the Customer interface
interface DiscountRate {
    double getServiceDiscountRate(String type);
    double getProductDiscountRate(String type);
}

// Define the Sale class
class Sale implements DiscountRate {
    // Implement the getServiceDiscountRate method
    @Override
    public double getServiceDiscountRate(String type) {
        switch (type) {
            case "Premium":
                return 0.20; // 20% discount
            case "Gold":
                return 0.15; // 15% discount
            case "Silver":
                return 0.10; // 10% discount
            default:
                return 0.00; // No discount for Normal
        }
    }

    // Implement the getProductDiscountRate method
    @Override
    public double getProductDiscountRate(String type) {
        switch (type) {
            case "Premium":
            case "Gold":
            case "Silver":
                return 0.10; // 10% discount for Premium, Gold, and Silver
            default:
                return 0.00; // No discount for Normal
        }
    }
}

// Define the Customer class
class Customer {
    private String type;

    // Constructor
    public Customer(String type) {
        this.type = type;
    }

    // Getter method for type
    public String getType() {
        return type;
    }
}

// Main class
public class ShoppingExercise {
    public static void main(String[] args) {
        Sale sale = new Sale();

        // Example usage
        Customer premiumCustomer = new Customer("Premium");
        Customer goldCustomer = new Customer("Gold");
        Customer silverCustomer = new Customer("Silver");
        Customer normalCustomer = new Customer("Normal");

        System.out.println("Premium customer service discount rate: " + sale.getServiceDiscountRate(premiumCustomer.getType()));
        System.out.println("Gold customer service discount rate: " + sale.getServiceDiscountRate(goldCustomer.getType()));
        System.out.println("Silver customer service discount rate: " + sale.getServiceDiscountRate(silverCustomer.getType()));
        System.out.println("Normal customer service discount rate: " + sale.getServiceDiscountRate(normalCustomer.getType()));

        System.out.println("Premium customer product discount rate: " + sale.getProductDiscountRate(premiumCustomer.getType()));
        System.out.println("Gold customer product discount rate: " + sale.getProductDiscountRate(goldCustomer.getType()));
        System.out.println("Silver customer product discount rate: " + sale.getProductDiscountRate(silverCustomer.getType()));
        System.out.println("Normal customer product discount rate: " + sale.getProductDiscountRate(normalCustomer.getType()));
    }
}
