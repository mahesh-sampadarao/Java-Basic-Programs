public class SecondsAndMinutesChallenge {
    public static void main(String[] args) {
        System.out.println("Total time in seconds:"+getDurationString(610));

        System.out.println("Total time in seconds:"+getDurationString(10,10));
    }

    public static String getDurationString(int seconds) {
        if(seconds>=0) {
            getDurationString(0,seconds);
        }else {
            System.out.println("Invalid Values.");
        }
        return Integer.toString(seconds);
    }

    public static String getDurationString(int minutes, int seconds) {
        if(minutes<=59 && seconds>=0) {
            int toSeconds=((minutes*60)+seconds);
            String toSecondsFinal=Integer.toString(toSeconds);
            return toSecondsFinal;
        }else {
            System.out.println("Invalid Values.");
            return "";
        }
    }

}
