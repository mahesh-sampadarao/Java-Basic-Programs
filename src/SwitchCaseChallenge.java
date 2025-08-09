public class SwitchCaseChallenge {
    public static void main(String[] args) {
        char Input = 'B';

        //Traditional Switch
        switch (Input) {
            case 'A':
                System.out.println("A for Able");
                break;
            case 'B':
                System.out.println("B for Baker");
                break;
            case 'C':
                System.out.println("C for Charlie");
                break;
            case 'D':
                System.out.println("D for Dog");
                break;
            case 'E':
                System.out.println("E for Easy");
                break;
            default:
                System.out.println("Bad Character");
        }

		System.out.println("-".repeat(15));

		//Enhanced Switch
		switch (Input) {
			case 'A' -> System.out.println("A for Able");
			case 'B' -> System.out.println("B for Baker");
			case 'C' -> System.out.println("C for Charlie");
			case 'D' -> System.out.println("D for Dog");
			case 'E' -> System.out.println("E for Easy");
			default -> System.out.println("Bad Character");

		}

		System.out.println("-".repeat(15));
		String month="MAY";
		System.out.println("The "+month+" is in "+getQuarter(month)+" quarter of the year");
		System.out.println("-".repeat(15));
    }

	public static String getQuarter(String month){
		//Traditional Case With Return Keyword

//		switch(month){
//			case "JANUARY":
//			case "FEBUARY":
//			case "MARCH":
//				return "1st";
//			case "APRIL":
//			case "MAY":
//			case "JUNE":
//				return "2nd";
//			case "JULY":
//			case "AUGUST":
//			case "SEPTEMBER":
//				return "3rd";
//			case "OCTOBER":
//			case "NOVEMBER":
//			case "DECEMBER":
//				return "4th";
//		}
//		return "Bad Month";

		//Enhanced Switch Case with return and yield
        return switch (month) {
            case "JANUARY", "FEBRUARY", "MARCH" -> "1st";
            case "APRIL", "MAY", "JUNE" -> "2nd";
            case "JULY", "AUGUST", "SEPTEMBER" -> "3rd";
            case "OCTOBER", "NOVEMBER", "DECEMBER" -> "4th";
            default ->{
				String resResponce="Bad Month";
				yield resResponce;
			}
        };

    }
}
