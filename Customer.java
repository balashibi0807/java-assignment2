package javaassign2;

public class Customer {
    private static int idCounter = 1000;  // Auto-increment customer ID
    private int customerId;
    private String name;

    public Customer(String name) {
        this.name = name;
        this.customerId = ++idCounter;  // Assign unique ID
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }
}
