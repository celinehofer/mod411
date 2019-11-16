package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class CommonFunctionalInterfaces {

    public static void main(String[] args) {
        List<Integer> list = map(
                Arrays.asList("Mein", "Name", "ist", "Daniel", "Senften"),
                String::length); // (String s) -> s.length()

        // [4, 4, 3, 6, 7]
        System.out.println(list);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> result = new ArrayList<>();
        for (T element : list) {
            result.add(function.apply(element));
        }
        return result;
    }
}
