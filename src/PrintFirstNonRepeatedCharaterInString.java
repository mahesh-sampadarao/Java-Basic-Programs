import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class PrintFirstNonRepeatedCharaterInString {
    public static void main(String[] args) {
//		String[] input={"apple","racecars","ababdc"};
//		ArrayList<String> al=new ArrayList<>(Arrays.asList(input));
        //String x = "SILLYSPIDERS";
        String x = "AAABBEAA";

        char[] y = x.toCharArray();
        int size = y.length;
        // creating a map and inserting data into it
        Map<Character, Integer> map = new LinkedHashMap<>();
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
        // System.out.println(map.isEmpty());
        Set<Map.Entry<Character, Integer>> lhmap = map.entrySet();
        for (Map.Entry<Character, Integer> data : lhmap) {
            if (data.getValue() == 1) {
                System.out.print(data.getKey());
                System.exit(0);
            }
        }
    }
}
