package algorithms.maths;

public class SegmentedSeiveAlgorithm {
    public static void main(String[] args) {
        int n = 800;
        int m = 1000;
        boolean[] v = new boolean[1000000];
        int[] primes = new int[1000000];
        //counter for the primes vector
        int counter = 0;

        for (int i = 2; i <= (int) Math.sqrt(m); i++) {
            v[i] = true;
        }

        for (int i = 2; i <= (int) Math.sqrt(m); i++) {
            if (v[i]) {
                primes[counter++] = i;
                for (int j = i * i; j <= (int) Math.sqrt(m); j += i) {
                    v[j] = false;
                }
            }
        }

        boolean[] flags = new boolean[1000000];
        for (int i = n; i < m; i++) {
            flags[i] = true;
        }

        for (int i = 0; i < counter; i++) {
            int start = n + (-n % primes[i]);
            for (int j = start; j < m; j += primes[i])
                if (j != primes[i])
                    flags[j] = false;
        }

        for (int i = n; i < m; i++)
            if (flags[i])
                System.out.println(i);
    }
}
