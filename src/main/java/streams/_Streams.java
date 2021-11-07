package streams;

import imperative.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;



import static streams._Streams.Gender.*;

public class _Streams {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Aisha",FEMALE),
                new Person("Alex",MALE),
                new Person("Alice",FEMALE),
                new Person("Maria",FEMALE),
                new Person("Bob",PREFER_NOT_TO_SAY)
        );
//        Function<Person, String> personStringFunction = person -> person.name;
//        ToIntFunction<String> length = String ::length;
//        IntConsumer println = x -> System.out.println();
//
//        people.stream()
//                        .map(personStringFunction)
//                .mapToInt(length)
//                                //.collect(Collectors.toSet())
//                                        .forEach(println);
        Predicate<Person> personPredicate = person -> PREFER_NOT_TO_SAY.equals(person.gender);
        boolean containsOnlyFemales = people.stream()
                //.allMatch(person -> FEMALE.equals(person.gender));
        //.anyMatch(person -> FEMALE.equals(person.gender));
                .noneMatch(personPredicate);
        System.out.println(containsOnlyFemales);

        System.out.println("//Imperative approach");
        List<Person> females = new ArrayList<>();
        for (Person person: people){
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        for (Person female : females){
            System.out.println(female);
        }

        System.out.println("//Declarative approach");
        //Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);
        List<Person> females2 = people.stream()
                .filter(person -> FEMALE.equals(person.gender))
                .collect(Collectors.toList());
        females2.forEach(System.out::println);
    }
    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum Gender {
        MALE, FEMALE, PREFER_NOT_TO_SAY
    }
}
