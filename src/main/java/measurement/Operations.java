package measurement;

import java.util.LinkedList;
import java.util.Random;

@SuppressWarnings("all")
public class Operations {

    private static Random random = new Random();

    public static void insertStaticArray(int count) {
        Integer[] staticArray = new Integer[count];
        for (int i = 0; i < count; i++) {
            staticArray[i] = random.nextInt();
        }
    }

    public static void insertLinkedList(int count) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        for (int i = 0; i < count; i++) {
            linkedList.add(random.nextInt());
        }
    }

}
