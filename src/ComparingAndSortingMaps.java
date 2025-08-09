import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ComparingAndSortingMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("a", 10);
        map1.put("b", 5);
        map1.put("c", 20);
        map1.put("d", 15);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("x", 30);
        map2.put("y", 25);
        map2.put("z", 35);
        map2.put("w", 40);

        ArrayList<Map.Entry<String, Integer>> list1 = new ArrayList<>(map1.entrySet());
        list1.sort(Map.Entry.comparingByValue());

        ArrayList<Map.Entry<String, Integer>> list2 = new ArrayList<>(map2.entrySet());
        list2.sort(Map.Entry.comparingByKey());

        System.out.println("Sorted map1 by values:");
        for (Map.Entry<String, Integer> entry : list1) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        // Print sorted map2
        System.out.println("\nSorted map2 by keys:");
        for (Map.Entry<String, Integer> entry : list2) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }
}
