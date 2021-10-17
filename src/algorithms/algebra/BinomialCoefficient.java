package algorithms.algebra;

/*
*
* https://cp-algorithms.com/combinatorics/binomial-coefficients.html
* */
public class BinomialCoefficient {
    public static void main(String[] args) {
        System.out.println(binomialCoef(10, 4));
    }

    // optimal way to return nCk
    public static int binomialCoef(int n, int k) {
        double res = 1;
        for (int i = 1; i <= k; ++i)
            res = res * (n - k + i) / i;
        return (int)(res + 0.01);       // to handle floating point errors
    }
}
