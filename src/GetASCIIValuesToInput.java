import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetASCIIValuesToInput {
    public static void main(String[] args) throws IOException {
        int num;
        BufferedReader bf=null;
        InputStreamReader in=null;

        /*try {
            System.out.print("Enter a single digit number : ");
            num=System.in.read();//Reads only one number/character at a time
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Entered num is : "+(num-48)+" and their respective ASCII number is : "+num);
*/
        //here num gives the ASCII representation of one digit/char present in Keyboard
        //0-ASCII Value(48)
        //A-ASCII Value(65)
        //a-ASCII Value(97)

        //Using Buffered-Reader
        try {
            System.out.print("Enter a multi digit number : ");
            in = new InputStreamReader(System.in);
            bf = new BufferedReader(in);
            num = Integer.parseInt(bf.readLine());
        } finally {
            in.close();
            bf.close();
        }
        System.out.println(num);

    }
}
