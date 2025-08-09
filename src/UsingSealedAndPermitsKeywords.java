/*
Note:
 In abstract classes in java, It is mandatory to inherit from these classes since objects of these classes cannot be instantiated.
 On the other hand, In final class in Java, which cannot be inherited or extended by any other class.
 A sealed class is a technique that limits the number of classes that can inherit the given class.

 Human is the parent class of Uma, Mahesh, Rao. It is a sealed class so; other classes cannot inherit it.
 Uma, Mahesh, Rao are child classes of the Human class, and it is necessary to make them either sealed, non-sealed, or final.
 Child classes of a sealed class must be sealed, non-sealed, or final.
 If any class other than Uma, Mahesh, Rao tries to inherit from the Human class, it will cause a compiler error.
*/

sealed class Human permits Uma, Mahesh, Rao{
    public void printName(){
        System.out.println("Default");
    }
}

non-sealed class Uma extends Human{
    public void printName(){
        System.out.println("Uma");
    }
}

final class Mahesh extends Human{
    public void printName(){
        System.out.println("Mahesh");
    }
}

sealed class Rao extends Human permits Sampadarao{
    public void printName(){
        System.out.println("Rao");
    }
}

final class Sampadarao extends Rao {
    public void printName(){
        System.out.println("Sampadarao");
    }
}

public class UsingSealedAndPermitsKeywords {
    public static void main(String[] args) {
        Human h0=new Human();
        Human h1 = new Uma();
        Human h2 = new Mahesh();
        Human h3 = new Rao();
        Rao h4 = new Sampadarao(); //h4 Object is of type Rao
        Human h5 = new Sampadarao(); //h5 Object is of type Rao which itself is a type of Human

        h0.printName();
        h1.printName();
        h2.printName();
        h3.printName();
        h4.printName();
        h5.printName();
    }
}
