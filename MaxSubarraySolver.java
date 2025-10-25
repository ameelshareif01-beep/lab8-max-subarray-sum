public class MaxSubarraySolver {

    /**
     * Finds the maximum subarray sum using a brute-force approach.
     * Theoretical Complexity: O(n^2)
     *
     * Primitive operation count:
     * - Outer loop runs n times.
     * - Inner loop runs (n - i) times on average ~ n/2.
     * - Each iteration does constant-time work (sum += arr[j], comparison, etc.)
     * Total operations ≈ (n * n/2) → O(n^2).
     */
    public static int bruteForceMaxSum(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) {           // n iterations
            int currentSum = 0;
            for (int j = i; j < n; j++) {       // ~n/2 iterations
                currentSum += arr[j];            // Constant work
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                }
            }
        }
        return maxSum;
    }

    /**
     * Finds the maximum subarray sum using Kadane's Algorithm.
     * Theoretical Complexity: O(n)
     *
     * Analysis:
     * - Single loop traverses the array once.
     * - Each iteration performs a constant number of operations (max comparisons, assignments).
     * Total operations ≈ c * n → O(n).
     */
    public static int kadanesAlgorithmMaxSum(int[] arr) {
        int maxCurrent = arr[0];
        int maxGlobal = arr[0];

        for (int i = 1; i < arr.length; i++) {     // n-1 iterations
            // Choose between starting a new subarray at arr[i]
            // or extending the previous one
            maxCurrent = Math.max(arr[i], maxCurrent + arr[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }
        return maxGlobal;
    }
}
