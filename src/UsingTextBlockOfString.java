public class UsingTextBlockOfString {
    public static void main(String[] args) {
        String bulletIt = "Print a bulleted list : \n"+
                "\t\u2022 First Point\n"+
                "\t\t\u2022 Second Point";
        System.out.println(bulletIt);

        String textBlock = """
                Print a bulleted list :
                    \u2022 First Point
                        \u2022 Second Point""";
        System.out.println(textBlock);

        int age=30;
        System.out.printf("Your age is %d\n",age); //using printf format specifier from string

        int yearOfBirth=2025-age;
        System.out.printf("Your age is %d, your date of birth is %d %n",age,yearOfBirth);

        System.out.printf("Your age is %.2f using precision of 2 digits after dot occurs %n",(float)age);

        String formattedString=String.format("Your age is %d from String.format method %n",age); //Using static method from String Class
        System.out.println(formattedString);

        formattedString="Your age is %d from formatted method".formatted(age); //Using instance method formatted from String Class
        System.out.println(formattedString);
    }
}
