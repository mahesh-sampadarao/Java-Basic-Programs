import java.util.stream.IntStream;

public class PrimeNumbersBetweenGivenRange {
    public static void main(String[] args) {
//		int primecount=0;
//		for(int i=2;i<=100;i++) {
//			int flag=0;
//			for(int j=2;j<i;j++) {
//				if(i%j==0) {
//					flag=1;
//				    break;
//				}
//			}
//		if(flag==0) {
//			primecount++;
//			System.out.print(i+" ");
//		}
//		}
//		System.out.printf("\n"+primecount);


/**This method is faster compared to above method by about half of run time.
 */
        int primecount = 0;
        for (int i = 2; i <= 100; i++) {
            int flag = 0;
            for (int j = 2; j <= i / 2; j++) {
                if (i % j == 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0) {
                primecount++;
                System.out.print(i + " ");
            }
        }
        System.out.println("\nThe total prime numbers present in between 1 to 100 : " + primecount);

        System.out.println("-".repeat(30));
        //Using Streams and Math.sqrt
        IntStream.rangeClosed(2,100)
                .filter(PrimeNumbersBetweenGivenRange::isPrime)
                .forEach(s-> System.out.print(s+" "));
    }

    public static boolean isPrime(int num){
        return IntStream.rangeClosed(2,(int)Math.sqrt(num)).allMatch(n->num%n!=0);
    }
}
