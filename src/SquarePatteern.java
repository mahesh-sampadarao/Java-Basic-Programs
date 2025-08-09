import java.util.Scanner;

public class SquarePatteern {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String x=sc.nextLine();
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        // System.out.println(x);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
