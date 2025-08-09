public class UsingInternMethodFromString {
    public static void main(String[] args) {
        String s1="Java";
        String s2=new String("Java");

        System.out.println(s1==s2);
        System.out.println(s1==s2.intern());
        //Intern Method checks the value of s2 with string pool memory where s1 is present.
        System.out.println(s1.equals(s2));
    }
}
