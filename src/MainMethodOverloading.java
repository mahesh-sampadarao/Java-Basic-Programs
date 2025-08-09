public class MainMethodOverloading {
    public static void main(String[] args) {
        System.out.println("Main Method Called");
        main(5);
        main(10.5);
    }

    public static void main(int args) {
        System.out.println("Main Method overloaded with int");
    }

    public static void main(double args) {
        System.out.println("Main Method overloaded with double");
    }
}
