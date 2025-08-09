public class MethodOverloadingChallenge {
    public static void main(String[] args) {
        System.out.println("Total Height in centimeters:" + convertToCentimeters(68));
        System.out.println("Total Height in centimeters :"+convertToCentimeters(5,8));
    }

    public static double convertToCentimeters(int inches) {
        double centimeters = (inches * 2.54);
        return centimeters;
    }

    public static double convertToCentimeters(int feet, int inches) {
        int inches1 = feet * 12;
        int totalInches = (inches1 + inches);
        double centimeters = convertToCentimeters(totalInches);
        return centimeters;
    }
}
