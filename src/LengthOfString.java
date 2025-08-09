public class LengthOfString {
    public static void main(String[] args) {
        String x = "Uma Maheshwar Rao";
        x = x.concat("\0");
        char[] y = x.toCharArray();
        int count = 0;
        for (int i = 0; y[i] != '\0'; i++) {

//			 System.out.println(y[i]);
            count++;
        }
        System.out.println(count);
    }
}
