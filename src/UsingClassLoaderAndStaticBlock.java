/*
When we create an Object in Java.

Creation of Object in memory happens in two steps:
1. Class Loader is called in first step(Your class loads here).
2. Object is instantiated in next step.

These 2 steps happen everytime you create an Object.
Every time when you call a class loader then it will call static block.
Since Class loading happens first this is reason static block is always run first and Only once and then constructors of class and rest all.

If we don't create an object then it will not load class also due to this static and constructors are also not called.

To load the class without Object. We have Class named Class in java.lang.Class package.
It has a method called forName which takes className for loading that class. Usage see below.

*/

class Mobile {
    String brand;
    int price;
    static String name;

    public Mobile(String brand, int price) {
        this.brand = brand;
        this.price = price;
        System.out.println("In Constructor Block");
    }

    static {
        name = "Phone";
        System.out.println("In Static Block");
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "brand='" + brand + '\'' +
                ", price=" + price + '\'' +
                ", name=" + name +
                '}';
    }
}

public class UsingClassLoaderAndStaticBlock {
    public static void main(String[] args) throws ClassNotFoundException {
        //I want to load class without creating object then
        Class.forName("Mobile");

        //Creation of Object
        Mobile mobile = new Mobile("Apple", 2000);
        System.out.println(mobile);

    }
}
