import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CheckAStringHasAllUniqueCharacters {
    public static void main(String[] args) {
        String x = "uncopyrightable";
        char[] y = x.toCharArray();
        int size = y.length;
        // creating a map and inserting data into it
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i != size; i++) {
            if (!map.containsKey(y[i])) {
                map.put(y[i], 1);
            } else {
                int oldval = map.get(y[i]);
                int newval = oldval + 1;
                map.put(y[i], newval);
            }
        }
        // Accessing the map
        Set<Map.Entry<Character, Integer>> hmap = map.entrySet();
        for (Map.Entry<Character, Integer> data : hmap) {
            if (data.getValue() > 1) {
                System.out.println("Not Unique");
                System.exit(0);
            }
        }
        System.out.println("Unique");
    }

}
