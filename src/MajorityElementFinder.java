public class MajorityElementFinder {
    public static int findMajorityElement(int[] arr) {
        int candidate = findCandidate(arr);
        return isMajority(arr, candidate) ? candidate : -1;
    }

    private static int findCandidate(int[] arr) {
        int count = 0, candidate = -1;
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }

    private static boolean isMajority(int[] arr, int candidate) {
        int count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }
        return count > arr.length / 2;
    }

    // Example usage
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 2, 1, 3, 5, 1};
        System.out.println(findMajorityElement(arr1)); // Output: 1

        int[] arr2 = {7};
        System.out.println(findMajorityElement(arr2)); // Output: 7

        int[] arr3 = {1, 2, 3, 4};
        System.out.println(findMajorityElement(arr3)); // Output: -1
    }
}
