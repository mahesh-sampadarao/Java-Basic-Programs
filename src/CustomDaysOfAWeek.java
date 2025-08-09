import java.time.DayOfWeek;
import java.util.EnumSet;

public enum CustomDaysOfAWeek {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY,SUNDAY;
    
    public static void main(String[] args) {
        EnumSet<CustomDaysOfAWeek> eset=EnumSet.range(CustomDaysOfAWeek.MONDAY,CustomDaysOfAWeek.THURSDAY);

        for(CustomDaysOfAWeek e:eset){
            System.out.println(e+" - "+e.ordinal()+" ");
        }

        System.out.println("-".repeat(20));

        for(DayOfWeek d:DayOfWeek.values()){
            System.out.println(d+" = "+d.ordinal()+" ");
        }

        System.out.println("-".repeat(20));

        for (CustomDaysOfAWeek esetday:CustomDaysOfAWeek.values()){
            System.out.println(esetday+" : "+esetday.ordinal()+" ");
        }
    }
}
