import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UniqueNumberUsingBitWiseXOR {
    public static void main(String[] args) {
        //1st Program
        int[] arr = {1, 3, 2, 4, 4, 3, 1};
        int num = 0;

        //Using xor
        for (int a : arr) {
            num ^= a; //  num=num^a;
        }
        //System.out.println(num);

        //Using streams
        int num2 = Arrays.stream(arr).reduce(0, (a, b) -> a ^ b);
        System.out.println(num2);

        //2nd program
        int[] arrWithDuplicates = {1, 3, 2, 4, 3, 1};
        int xor = 0;
        for (int a : arrWithDuplicates) {
            xor ^= a;
        }

        int setBit = xor & -xor;
        int num3 = 0, num4 = 0;
        for (int a : arrWithDuplicates) {
            if ((setBit & a) == 0) {
                num3 ^= a;
            } else {
                num4 ^= a;
            }
        }
        //System.out.println("The unique elements in array are : " + num3 + " & " + num4);

        Map<Boolean, List<Integer>> partition = Arrays.stream(arrWithDuplicates)
                .boxed()
                .collect(Collectors.partitioningBy(n -> (n & setBit) == 0));

        Integer num5 = partition.get(true).stream().reduce(0, (a, b) -> a ^ b);
        Integer num6 = partition.get(false).stream().reduce(0, (a, b) -> a ^ b);

        System.out.println("The unique elements in array are : " + num5 + " & " + num6);
    }
}
