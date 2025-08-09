import java.util.Arrays;
import java.util.Scanner;

public class DemoArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] n = new int[size];
        for (int i = 0; i != size; i++) {
            n[i] = sc.nextInt();
        }
        sc.close();

        boolean isAscending = true;
//		int min = Integer.MIN_VALUE;
//		int max = Integer.MAX_VALUE;
        for (int i = 0; i != n.length-1 ; i++) {
//			if (n[i] < min) {
//				min = n[i];
//			}
//			if (n[i] > max) {
//				max = n[i];
//			}
            if (n[i] > n[i + 1]) {
                isAscending = false;
                break;
            }
        }
        if(isAscending) {
            System.out.println("Array is sorted in ascending order");
        }else {
            System.out.println("Array is not sorted in ascending order");
        }
//		System.out.println(min);
//		System.out.println(max);

        final int[] array ={1,2,3,4};//Making array reference only final but not its content. Same for ArrayList.
        System.out.println(Arrays.toString(array));
        array[0]=5;

        //array=new int[10];
        System.out.println(Arrays.toString(array));
        int[] arrayInt = Arrays.copyOf(array, 10);
        Arrays.fill(arrayInt,12);
        System.out.println("New Copied Array : "+Arrays.toString(arrayInt));
    }
}
