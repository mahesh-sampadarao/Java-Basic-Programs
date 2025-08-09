import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class PrintDuplicateCharactersInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String:");
        String x = sc.nextLine();
        sc.close();
        char[] y = x.toCharArray();
        int size = y.length;
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
        Set<Map.Entry<Character, Integer>> hmap = map.entrySet();
        for (Map.Entry<Character, Integer> data : hmap) {
            if(data.getValue()>1) {
                System.out.print(data.getKey());
                System.out.println(data.getValue());
            }
        }

    }
}
