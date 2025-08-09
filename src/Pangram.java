public class Pangram {
    public static void main(String[] args) {
//		String x = "THE QUICK BROWN FOX JUMPS OVER A LAZY DOG";
//	 String x = "My name is UmaMaheshwar Rao";
        String x="uncopyrightable zebra swag and mood for jack query vex";
        x = x.replace(" ", "");
        x = x.toUpperCase();
        char[] a = x.toCharArray();
        int size = a.length;
//Arrays.sort(a);
        char[] b = new char[26];
        for (int i = 0; i != size; i++) {
            int index = a[i] - 65;
            b[index] = 1;
        }
        for (int i = 0; i != 26; i++) {
            if (b[i] == 1) {
                i++;
            } else {
                System.out.println("Not a Pangram");
                System.exit(0);
            }
        }
        System.out.println("Its a pangram");
//System.out.println(a);
//System.out.println(b);
    }
}
