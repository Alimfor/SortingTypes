import java.sql.Time;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main{
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        fillList(list);
        long startTime = System.currentTimeMillis();

        SortingType select = new Sorting();
        select.quickSort(list);

        long endTime = System.currentTimeMillis();
        System.out.println("Working time: " + (endTime - startTime) +
                           "\nSorted list: " + list);
    }
    private static void fillList(List<Integer> arr) {
        Random random = new Random();
        final int n = 1000;//random.nextInt(100);

        for (int i = 0; i < n; i++) {
            arr.add(random.nextInt(1000));
        }
    }

}