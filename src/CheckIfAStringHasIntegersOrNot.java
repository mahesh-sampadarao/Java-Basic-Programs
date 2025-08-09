public class CheckIfAStringHasIntegersOrNot {
    public static void main(String[] args) {
        String x = "12ABC";
        int size = x.length();
        for (int i = 0; i != size; i++) {
            if (x.charAt(i) >= '0' && x.charAt(i) <= '9') {
                System.out.println("Integer String");
                System.exit(0);
            } else {
                System.out.println("Not an Integer String");
                System.exit(0);
            }
        }
//		System.out.println("Integer String");
    }

}
