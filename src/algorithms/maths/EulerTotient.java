package algorithms.maths;


/*
 *
 * Euler's totient function, also known as phi-function ϕ(n), counts the number of integers between 1 and n inclusive, which are coprime to n.
 * Two numbers are coprime if their greatest common divisor equals 1 (1 is considered to be coprime to any number).
 * Refer to <a href= "https://cp-algorithms.com/algebra/phi-function.html">CP-Algo-Euler</a>
 *
 * */
public class EulerTotient {
    public static void main(String[] args) {
        int[] res = phiFunction(21);
        for (int i = 1; i<res.length ; i++) {
            System.out.print(i + ", ");
        }
        System.out.println();
        for (int i = 1; i<res.length ; i++) {
            System.out.print(res[i] + ", ");
        }
    }

    // This returns euler totient from 1 to n in O(nloglogn)
    static int[] phiFunction(int n) {
        int[] phi = new int[n + 1];
        phi[0] = 0;
        phi[1] = 1;
        for (int i = 2; i <= n; i++) {
            phi[i] = i;
        }

        for (int i = 2; i <= n; i++) {
            if (phi[i] == i) {
                for (int j = i; j <= n; j += i)
                    phi[j] -= phi[j] / i;
            }
        }

        return phi;
    }

    /*
    *
    * ∑d|nϕ(d)=n
    * Here the sum is over all positive divisors d of n.
    * For instance the divisors of 10 are 1, 2, 5 and 10. Hence ϕ(1)+ϕ(2)+ϕ(5)+ϕ(10)=1+1+4+4=10.
    *
    * */
    // Finding the totient from 1 to n using the divisor sum property: O(nlogn)
    static int[] phi_DivisorSum(int n) {
        int[] phi = new int[n + 1];
        phi[0] = 0;
        phi[1] = 1;
        for (int i = 2; i <= n; i++) {
            phi[i] = i - 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 2 * i; j <= n; j += i) {
                phi[j] -= phi[i];
            }
        }
        return phi;
    }

}
