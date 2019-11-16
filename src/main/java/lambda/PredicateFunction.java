package lambda;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

@SuppressWarnings("all")
public class PredicateFunction {

    private static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T element : list) {
            if (predicate.test(element)) {
                result.add(element);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> list = filter(
                Arrays.asList("Daniel", "", "Senften"),
                (String s) -> !s.isEmpty());
        // [Daniel, Senften]
        System.out.println(list);


        // Filtering with lambdas
        List<Apple> inventory = Arrays.asList(
                new Apple(80, "green"),
                new Apple(155, "green"),
                new Apple(120, "red"));

        // [Apple{color='green', weight=80}, Apple{color='green', weight=155}]
        List<Apple> greenApples = filter(inventory, (Apple a) -> "green".equals(a.getColor()));
        System.out.println(greenApples);

        // before... Method Reference
        inventory.sort((Apple a1, Apple a2)
                -> a1.getWeight().compareTo(a2.getWeight()));

        // ...and after using a Method Reference
        inventory.sort(comparing(Apple::getWeight));

        // [Apple{color='green', weight=80}, Apple{color='red', weight=120}, Apple{color='green', weight=155}]
        System.out.println(inventory);


        // Composing Predicates
        Predicate<Apple> redApple = a -> "red".equals(a.getColor());

        Predicate<Apple> notRedApple = redApple.negate();

        Predicate<Apple> redAndHeavyApple =
                redApple.and(a -> a.getWeight() > 150);

        Predicate<Apple> redAndHeavyAppleOrGreen =
                redApple.and(a -> a.getWeight() > 150)
                        .or(a -> "green".equals(a.getColor()));
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

        Apple(int weight, String color) {
            this.weight = weight;
            this.color = color;
        }

    }

    interface ApplePredicate {
        public boolean test(Apple a);
    }

}
