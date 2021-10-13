package algorithms.maths;

import java.util.Arrays;

public class SieveofEratosthenes {
    /*
    *
    * Sieve of Eratosthenes is an algorithm for finding all the prime numbers in a segment [1-n] using O(nloglogn) operations.
    *
    * */
    public static void main(String[] args) {
        int n = 100;
        sieve(n);
    }

/*
    Mark all the numbers as prime numbers except 1
    Traverse over each prime numbers smaller than sqrt(N)
    For each prime number, mark its multiples as composite numbers
    Numbers, which are not the multiples of any number, will remain marked as prime number and others will change to composite numbers.
*/
    public static void sieve(int n) {
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; i++) {
            if (isPrime[i] && i * i <= n) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }
}
