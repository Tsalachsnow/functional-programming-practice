package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
//        Object value = Optional.ofNullable(null)
//                .orElseGet(() -> "default value");
//        System.out.println(value);
//      Supplier<IllegalStateException> exception = () -> new IllegalStateException("exception");
//        Object value = Optional.ofNullable("Hello")
//                .orElseThrow(() -> new IllegalStateException("exception"));
//        System.out.println(value);

//        Optional.ofNullable("amalahaprosper@gmail.com")
//                //.ifPresent(System.out::println);
//                .ifPresent(email -> System.out.println("Sending email to " + email));

        Optional.ofNullable(null)
                .ifPresentOrElse(email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("cannot send email"));

    }

    }
