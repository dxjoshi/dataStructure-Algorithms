package algorithms.maths;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
Our goal is to calculate minimum prime factor lp[i] for every number i in the segment [2-n].
Besides, we need to store the list of all the found prime numbers - let's call it pr[].
We'll initialize the values lp[i] with zeros, which means that we assume all numbers are prime. During the algorithm execution this array will be filled gradually.
Now we'll go through the numbers from 2 to n. We have two cases for the current number i:
lp[i]=0 - that means that i is prime, i.e. we haven't found any smaller factors for it.
Hence, we assign lp[i]=i and add i to the end of the list pr[].
lp[i]≠0 - that means that i is composite, and its minimum prime factor is lp[i].
In both cases we update values of lp[] for the numbers that are divisible by i. However, our goal is to learn to do so as to set a value lp[] at most once for every number. We can do it as follows:

Let's consider numbers x(j) = i⋅p(j), where p(j) are all prime numbers less than or equal to lp[i] (this is why we need to store the list of all prime numbers).
We'll set a new value lp[x(j)] = p(j) for all numbers of this form.
*/

public class LinearSieveAlgorithm {

    public static void main(String[] args) {
        // useful only till 10^7 as it takes a lot of memory
        long start = System.nanoTime();
        int N = 1000000;
        int[] res = sieve(N);
        for (int i = 0; i < res.length ; i++) {
            System.out.print(res[i] + ", ");
            if (i%100 == 0) System.out.println();
        }
        System.out.println();
        System.out.println(String.format("Time Taken: %d sec", TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - start)));
    }

    public static int[] sieve(int N) {
        int lp[] = new int[N+1];
        List<Integer> pr = new ArrayList<>();
        for (int i=2; i<=N; ++i) {
            if (lp[i] == 0) {
                lp[i] = i;
                pr.add(i);
            }
            for (int j=0; j<(int)pr.size() && pr.get(j)<=lp[i] && i*pr.get(j)<=N; ++j) {
                lp[i * pr.get(j)] = pr.get(j);
            }
        }
        return lp;
    }
}
