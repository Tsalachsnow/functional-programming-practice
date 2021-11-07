package bifunction;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

    public class Main {
        public static void main(String[] args) {
            //Normal java function
            Customer maria = new Customer("Maria", "+234567887097");
            greetCustomer(maria);
            // Consumer Functional interface
            greetCustomerConsumer.accept(maria);
greetCustomerV2(maria, true);
            greetCustomerConsumerV2.accept(maria, false);
        }


        static BiConsumer<Customer, Boolean> greetCustomerConsumerV2 = (customer, showPhoneNumber) ->
                System.out.println("Hello " + customer.customerName + ", thanks for registering your Phone number " + (showPhoneNumber ? customer.getCustomerPhoneNumber : "************"));

        static Consumer<Customer> greetCustomerConsumer = customer ->
                System.out.println("Hello " + customer.customerName + ", thanks for registering your Phone number " + customer.getCustomerPhoneNumber);


        static void greetCustomer(Customer customer){
            System.out.println("Hello " + customer.customerName + ",thanks for registering your Phone number " + customer.getCustomerPhoneNumber);
        }
        static void greetCustomerV2(Customer customer, boolean showPhoneNumber) {
            System.out.println("Hello " + customer.customerName + ", thanks for registering your Phone number " + (showPhoneNumber ? customer.getCustomerPhoneNumber : "************"));
        }

            static class Customer{
            private final String customerName;
            private final String getCustomerPhoneNumber;

            public Customer(String customerName, String getCustomerPhoneNumber) {
                this.customerName = customerName;
                this.getCustomerPhoneNumber = getCustomerPhoneNumber;
            }
        }
}
