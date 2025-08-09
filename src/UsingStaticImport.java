import java.io.PrintStream;

public class UsingStaticImport {
    public static void main(String[] args) {
        PrintStream out =System.out;
        out.println("This is a example of static import statement");
        if(System.out== out){
            System.out.println("The result of reference is : "+(System.out== out));
        }
    }
}
