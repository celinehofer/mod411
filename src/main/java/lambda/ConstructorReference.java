package lambda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

import static java.util.stream.Collectors.toList;

public class ConstructorReference {

    public static void main(String[] args) {

        /*
         * Constructor with zero arguments.
         */
        {
            // Supplier<Apple> apple = () -> new Apple()
            Supplier<Apple> lambda = Apple::new;
            Apple apple = lambda.get();

            // Apple{color='', weight=0}
            System.out.println(apple);
        }


        /*
         * Constructor with one argument.
         */
        {
            // Function<Integer, Apple> lambda = (weight) -> new Apple(weight);
            Function<Integer, Apple> lambda = Apple::new;
            Apple apple = lambda.apply(110);

            // Apple{color='', weight=110}
            System.out.println(apple);

            List<Integer> weights = Arrays.asList(7, 3, 4, 10);
            List<Apple> apples = map(weights, Apple::new);

            // [Apple{color='', weight=7}, Apple{color='', weight=3}, Apple{color='', weight=4}, Apple{color='', weight=10}]
            System.out.println(apples);


            // Apple{color='', weight=0}
            System.out.println(apple);
        }

        /*
         * Verwenden eines Konstruktors mit einem Argument.
         */
        {
            // Function<Integer, Apple> lambda = (weight) -> new Apple(weight);
            Function<Integer, Apple> lambda = Apple::new;
            Apple apple = lambda.apply(110);

            // Apple{color='', weight=110}
            System.out.println(apple);
        }

        /*
         * Verwenden eines Konstruktors mit zwei Argumenten.
         */
        {
            BiFunction<Integer, String, Apple> lambda = Apple::new;
            Apple apple = lambda.apply(10, "red");

            // Apple{color='red', weight=10}
            System.out.println(apple);
        }


        /*
         * Verwenden eines Konstruktors mit drei Argumenten.
         */
        {
            TriFunction<Integer, String, Boolean, Apple> lambda = Apple::new;
            Apple apple = lambda.apply(10, "red", true);

            // Apple{color='red', weight=10, bio=true}
            System.out.println(apple);
        }

    }


    private static List<Apple> map(List<Integer> list,
                                   Function<Integer, Apple> f) {
//        List<Apple> result = new ArrayList<>();
//        for (Integer e : list) {
//            result.add(f.apply(e));
//        }
        // return result;
        return list.stream()
                .map(f)
                .collect(toList());
    }

    /**
     * Eine lokale Klasse, welche einen Apfel representiert. Die notwendigen Getter/Setter und toString Methoden
     * werden hier durch das <a href="https://projectlombok.org/features/GetterSetter">Lombok Plugin</a>
     * generiert.
     */
    @Getter
    @Setter
    @ToString
    public static class Apple {
        private Integer weight = 0;
        private String color = "";
        private Boolean bio = false;

        Apple() {
        }

        Apple(int weight) {
            this(weight, "");
        }

        Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

        Apple(Integer weight, String color, Boolean bio) {
            this(weight, color);
            this.bio = bio;
        }

    }

}
