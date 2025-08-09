import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CreatingMAPDataStructureAndAccessingIt {
    public static void main(String[] args) {
        //String x = "UMAMAHESHWAR";
        String x = "ARADHYA";

        char[] y = x.toCharArray();
        int size = y.length;
        // creating a map and inserting data into it
        Map<Character, Integer> map = new HashMap<>();
//		Map<Character, Integer> map = new LinkedHashMap<>();
//		Map<Character, Integer> map = new TreeMap<>();
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
        //System.out.println(map.isEmpty());
        Set<Map.Entry<Character, Integer>> hmap = map.entrySet();
        for (Map.Entry<Character, Integer> data : hmap) {
            System.out.print(data.getKey());
            System.out.println(data.getValue());
        }
    }

}
