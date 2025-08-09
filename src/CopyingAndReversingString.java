public class CopyingAndReversingString {
    public static void main(String[] args) {
        String x = "umamahesh";
        char[] y = x.toCharArray();
        int size = y.length;
        char[] a = new char[size];
        int i = 0;
        while (i != size) {
            // a[i]=y[i]; //copying
            a[size - i - 1] = y[i]; // reversing
            i++;
        }
        System.out.println(y);
        System.out.println(a);
    }
}
