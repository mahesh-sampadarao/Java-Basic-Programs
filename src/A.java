import java.util.Arrays;

interface C {
    default void show() {
        System.out.println("C Interface");
    }

    static void dis1() {
    }
}

interface B {
    default void show() {
        System.out.println("B Interface");
    }
}


public class A implements C, B {

    public static void main(String arg[]) {
        display((Object)null); //Reference should be casted to know which method to call.
        A a=new A();
        a.show();

        Object[] i=new Object[3];
        i[0]="1";
        System.out.println(Arrays.toString(i));
    }

    public void show() {
        //Write line to call B interface show method
        B.super.show(); //B Interface
        System.out.println("A Interface");
    }

    public static void display(String arg) {
        System.out.println("String");
    }

    public static void display(Integer arg) {
        System.out.println("Integer");
    }

    public static void display(Object arg) {
        System.out.println("Object");
    }


}
