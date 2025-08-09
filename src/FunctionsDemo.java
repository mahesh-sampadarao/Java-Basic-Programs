import java.util.Scanner;

public class FunctionsDemo {
    public static int functionName(int a, int b) {
        int sum = a + b;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b=sc.nextInt();
        sc.close();
        System.out.println(functionName(a,b));
    }

}
