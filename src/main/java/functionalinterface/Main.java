package functionalinterface;

import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        //Normal java function
        Customer maria = new Customer("Maria", "+234567887097");
        greetCustomer(maria);
        // Consumer Functional interface
        greetCustomerConsumer.accept(maria);
    }

    static Consumer<Customer> greetCustomerConsumer = customer ->
            System.out.println("Hello " + customer.customerName + ", thanks for registering your Phone number " + customer.getCustomerPhoneNumber);

    static void greetCustomer(Customer customer){
        System.out.println("Hello " + customer.customerName + ", thanks for registering your Phone number " + customer.getCustomerPhoneNumber);
    }
    public static class Customer{
        public final String customerName;
        public final String getCustomerPhoneNumber;


        public Customer(String customerName, String getCustomerPhoneNumber) {
            this.customerName = customerName;
            this.getCustomerPhoneNumber = getCustomerPhoneNumber;
        }
    }
}
