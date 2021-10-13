package algorithms.maths;

public class ExtendedEuclidsAlgorithm {

    public static void main(String[] args) {
        int[] res = gcd(16, 10);
        System.out.println(String.format("GCD= %s | x= %s | y= %s", res[0], res[1] , res[2]));
    }

    //  return array [d, x, y] such that d = gcd(a, b), ax + by = d
    static int[] gcd(int a, int b) {
        if (b == 0)     return new int[] { a, 1, 0 };

        int[] vals = gcd(b, a % b);
        int d = vals[0];
        int x = vals[2];
        int y = vals[1] - (a / b) * vals[2];
        return new int[] { d, x, y };
    }

}
