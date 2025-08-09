import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class RemoveDuplicateCharactersInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String:");
        String x = sc.nextLine();
        sc.close();
        //x=x.replaceAll("\\s","");
        char[] y = x.toCharArray();
        int size = y.length;
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
        Set<Map.Entry<Character, Integer>> lhmap = map.entrySet();
        String res="";
        for (Map.Entry<Character, Integer> data : lhmap) {
            res=res+data.getKey();
        }
        System.out.println(res);
    }
}
