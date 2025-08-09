public class ConvertStringToIntegerAndViceVersa {
    public static void main(String[] args) {
        // StringToInteger
        String z = "64";
        //Integer b=Integer.valueOf(z);
        int a = Integer.parseInt(z);
        System.out.println(z);
        System.out.println(a);

        // IntegerToString
        int x = 64;
    	// int y=Integer.rotateRight(x, 2);
        // int y=Integer.rotateLeft(x, 2);
        String y = Integer.toString(x);
        System.out.println(x);
        System.out.println(y);

    }
}
