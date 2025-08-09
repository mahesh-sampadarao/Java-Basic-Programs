import java.util.Arrays;

public class SumOfNumbersInAArray {
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3};
        int n = 900;
        int[] output = plusN(array, n);
        System.out.println(Arrays.toString(output));
    }

    public static int[] plusN(int[] array, int n) {
        int number = 0;
        for (int i = 0; i < array.length; i++) {
            number = number * 10 + array[i];
        }

        number += n;
        System.out.println(number);

        int temp = number;
        int length = 0;
        while (temp > 0) {
            temp /= 10;
            length++;
        }
        System.out.println(length);

        int[] output=new int[length];
        for (int i = output.length-1; i >=0 ; i--) {
            output[i]=number%10;
            number/=10;
        }

        return output;
    }
}
