import java.util.Scanner;

public class BoxOfStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        sc.close();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
//				if (i == n || j == m) {
                if (i == 1 || j == 1 || j == m || i == n) {
                    System.out.print("*");
                }else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
