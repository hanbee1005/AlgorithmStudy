package math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Closest_Prime_Numbers_InRange_2523 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(closestPrimes(10, 19)));
        System.out.println(Arrays.toString(closestPrimes(4, 6)));
    }

    private static int[] closestPrimes(int left, int right) {
        List<Integer> primeNumbers = new ArrayList<>();

        // Find all prime numbers in the given range
        for (int candidate = left; candidate <= right; candidate++) {
            if (candidate % 2 == 0 && candidate > 2) {
                continue;
            }
            if (isPrime(candidate)) {
                // If a twin prime (or [2, 3]) is found, return immediately
                if (
                        !primeNumbers.isEmpty() &&
                                candidate <= primeNumbers.get(primeNumbers.size() - 1) + 2
                ) {
                    return new int[] {
                            primeNumbers.get(primeNumbers.size() - 1),
                            candidate,
                    };
                }
                primeNumbers.add(candidate);
            }
        }

        // If fewer than 2 primes exist, return {-1, -1}
        if (primeNumbers.size() < 2) {
            return new int[] { -1, -1 };
        }

        // Find the closest prime pair
        int[] closestPair = new int[] { -1, -1 };
        int minDifference = 1000000;
        for (int index = 1; index < primeNumbers.size(); index++) {
            int difference =
                    primeNumbers.get(index) - primeNumbers.get(index - 1);
            if (difference < minDifference) {
                minDifference = difference;
                closestPair = new int[] {
                        primeNumbers.get(index - 1),
                        primeNumbers.get(index),
                };
            }
        }

        return closestPair;
    }

    // Function to check if a number is prime
    private static boolean isPrime(int number) {
        if (number == 1) {
            return false;
        }
        for (int divisor = 2; divisor <= (int) Math.sqrt(number); divisor++) {
            if (number % divisor == 0) {
                return false;
            }
        }
        return true;
    }
}
