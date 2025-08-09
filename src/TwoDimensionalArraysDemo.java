import java.util.Scanner;

public class TwoDimensionalArraysDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int c = sc.nextInt();
        int[][] num = new int[r][c];
        for(int i=0;i!=r;i++) {
            for(int j=0;j!=c;j++) {
                num[i][j]=sc.nextInt();
            }
        }
        sc.close();

        for(int i=0;i!=r;i++) {
            for (int j=0;j!=c;j++) {
                System.out.print(num[i][j]+" ");
            }
            System.out.println();
        }
    }
}
