import java.util.Random;

public class SubarrayTester {

    public static void main(String[] args) {
        int[] sizes = {1000, 5000, 10000, 50000, 100000};
        Random rand = new Random();

        System.out.println("--- Maximum Subarray Sum Algorithm Comparison ---");

        for (int n : sizes) {
            int[] arr = generateRandomArrayWithNegatives(n);

            System.out.println("\n--- Testing for array size n = " + n + " ---");

            // Time Brute Force
            long start = System.nanoTime();
            MaxSubarraySolver.bruteForceMaxSum(arr);
            long end = System.nanoTime();
            double bruteForceTime = (end - start) / 1_000_000.0;

            // Time Kadane’s Algorithm
            start = System.nanoTime();
            MaxSubarraySolver.kadanesAlgorithmMaxSum(arr);
            end = System.nanoTime();
            double kadaneTime = (end - start) / 1_000_000.0;

            System.out.printf("Brute-Force (O(n^2)) : %.3f ms\n", bruteForceTime);
            System.out.printf("Kadane's (O(n))      : %.3f ms\n", kadaneTime);
        }
    }

    public static int[] generateRandomArrayWithNegatives(int size) {
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            // Range [-1000, 1000]
            arr[i] = rand.nextInt(2001) - 1000;
        }
        return arr;
    }
}
