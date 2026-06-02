class Test{
    static void display(){IO.println("Static Called!");}

    void display(int x){IO.println("Non-Static Called!");}
}

//Capgemini
public class StaticVsNonStatic {
    static void main(String[] args) {
        Test t=new Test();
        //t.display(2);
        t.display();
        //Here static is called due to input args(int x) of non-static method.
        // If input args is removed it will result in compilation error
    }
}
