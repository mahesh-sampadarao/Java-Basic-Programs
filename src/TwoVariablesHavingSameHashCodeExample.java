/*
Two Variables Having Same HashCode leads to Hash Collisions Scenario.
*/

public class TwoVariablesHavingSameHashCodeExample {
    public static void main(String[] args) {
        String s1="FB";
        String s2="Ea";
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }
}
