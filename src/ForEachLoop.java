import java.util.Arrays;

public class ForEachLoop {
    public static void main(String[] args) {
        int[] a = { 100, 10, 20, 30, 40, 50 };
        int size=a.length;
        int sum = 0;
        for (int data : a) {
            sum=sum+data;
        }
        System.out.println(sum);
        System.out.println(size);

        Integer sumStream=Arrays.stream(a).reduce(0,(c,b)->c+b);
        System.out.println(sumStream);
    }
}
