public class CountingVowelsConsonantsSpecialCharacters {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String x = "My name is a umamaheshwar rao";
        x=x.toUpperCase();
        char[] y = x.toCharArray();
        int size = y.length;
        int vowcnt=0, concnt=0, splcnt = 0;
        for (int i = 0; i != size; i++) {
            if (y[i] >= 'A' && y[i] <= 'Z') {
                if (y[i] == 'A' || y[i] == 'E' || y[i] == 'I' || y[i] == 'O' || y[i] == 'U') {
                    vowcnt++;
                }
                else {
                    concnt++;
                }
            }
            else {
                splcnt++;
            }
        }
        System.out.println("Vowel Count="+vowcnt);
        System.out.println("Consonant Count="+concnt);
        System.out.println("Special Count="+splcnt);

    }

}
