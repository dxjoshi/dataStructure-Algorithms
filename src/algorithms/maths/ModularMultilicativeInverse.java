package algorithms.maths;

public class ModularMultilicativeInverse {

/*
    A modular multiplicative inverse of an integer a is an integer x such that a⋅x is congruent to 1 modular some modulus m. To write it in a formal way: we want to find an integer x so that
        A.X ≡ 1modM.
    We will also denote X simply with A^−1.
*/
    public static void main(String[] args) {
        int a = 5, m = 12;
        int[] res = gcd(a, m);
        // res[0] contains the GCD, we need to first check if the GCD is coprime or GCD(A, M) = 1
        if (res[0] != 1) {
            System.out.println("Multiplicative inverse not valid");
        } else {
            // res[1] return the coefficient x for the Linear Diophantine Equation in 2 variables: ax + by = 1
            int x = (res[1]% m + m) % m;
            System.out.printf("The multiplicative inverse of a=%d is %d%n", a, x);
        }

    }

    //  Extended Euclidean Algorithm => return array [d, x, y] such that d = gcd(a, b), ax + by = d
    static int[] gcd(int a, int m) {
        if (m == 0)     return new int[] { a, 1, 0 };

        int[] vals = gcd(m, a % m);
        int d = vals[0];
        int x = vals[2];
        int y = vals[1] - (a / m) * vals[2];
        return new int[] { d, x, y };
    }

    //If m is a prime number, we can use the Fermat's little theorem to find the inverse: A^(M-2) ≡ (A^−1)modM
    // This equation can be solved by binary exponentiation method.
    static int modInverse(int A,int M)
    {
        return modularExponentiation(A,M-2, M);
    }

    // x - number
    // n - exponent
    // M - modulo
    static int modularExponentiation(int x,int n,int M)
    {
        if(n==0) {
            return 1;
        } else if(n%2 == 0)        //n is even
        {
            return modularExponentiation((x*x)%M,n/2,M);
        } else                             //n is odd
        {
            return (x*modularExponentiation((x*x)%M,(n-1)/2,M))%M;
        }
    }

}
