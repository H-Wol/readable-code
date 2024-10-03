package cleancode.missons.day4;

public class Customer {
    private String name;
    private String address;

    private Customer() {
        this.name = "";
        this.address = "";
    }

    private Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public static Customer of(String name, String address) {
        return new Customer(name, address);
    }

    public static Customer of() {
        return new Customer();
    }

    public boolean hasCustomerInfo() {
        return name != null && !name.isEmpty() && address != null && !name.isEmpty();
    }

}
