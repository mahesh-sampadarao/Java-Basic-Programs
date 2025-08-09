public class MaximumSumOfSubArrayUsingKadanesAlgo {
    public static void main(String[] args) {
        int arr[] = {2, 3, -8, 7, -1, 2, 3};
        int size = arr.length;

        int res = arr[0];
        int maxEnding = arr[0];
        for (int i = 1; i < arr.length; i++) {
            maxEnding = Math.max(maxEnding + arr[i], arr[i]);
            res = Math.max(res, maxEnding);
        }
        System.out.println(res);

        System.out.println(maxSubarraySum(arr)); //Naive Approach
    }

    static int maxSubarraySum(int[] arr) {
        int res = arr[0];

        // Outer loop for starting point of subarray
        for (int i = 0; i < arr.length; i++) {
            int currSum = 0;

            // Inner loop for ending point of subarray
            for (int j = i; j < arr.length; j++) {
                currSum = currSum + arr[j];

                // Update res if currSum is greater than res
                res = Math.max(res, currSum);
            }
        }
        return res;
    }
}
