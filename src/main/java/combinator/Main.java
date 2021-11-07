package combinator;

import java.time.LocalDate;

import static combinator.CustomerRegistrationValidator.*;

public class Main {
    public static void main(String[] args) {
        Customer customer = new Customer("Alice",
                "alice@gmail.com",
                "+0845652713",
                LocalDate.of(2000, 1, 23)
        );
//        CustomerValidatorService validatorService = new CustomerValidatorService();
//        validatorService.isValid(customer); OR

        //System.out.println(new CustomerValidatorService().isValid(customer));
       ValidationResult result = isEmailValid().and(isPhoneNumberValid()).and(isAnAdult()).apply(customer);
        System.out.println(result);

        if(result != ValidationResult.SUCCESS){
            throw new IllegalStateException(result.name());
        }
    }
}
