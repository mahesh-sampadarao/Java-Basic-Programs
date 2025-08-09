import java.util.Arrays;
import java.util.stream.IntStream;

public class Anagram {
    public static void main(String[] args) {
        String x = "silent";
        String y = "listen";
        char[] a = x.toCharArray();
        char[] b = y.toCharArray();
        Arrays.sort(a);
        Arrays.sort(b);
        Boolean result = Arrays.equals(a, b);
//		 System.out.println(result);
        if (result) {
            System.out.println("It's an Anagram");
        } else {
            System.out.println("Not an Anagram");
        }
//		System.out.println(a);
//		System.out.println(b);

        boolean pow=isPowerOfTwo(128);
        System.out.println(pow);
    }

    public static boolean isPowerOfTwo(int n) {
        if (n <= 0) return false;

        return IntStream.iterate(1, x -> x > 0 && x <= n, x -> x * 2)
                .anyMatch(x -> x == n);
    }
}
