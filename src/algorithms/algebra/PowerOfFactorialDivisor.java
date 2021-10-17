package algorithms.algebra;

public class PowerOfFactorialDivisor {
    public static void main(String[] args) {
        System.out.println(factPow(10, 3));
    }

    //only for prime K
    public static int factPow (int n, int k) {
        int res = 0;
        while (n != 0) {
            n /= k;
            res += n;
        }
        return res;
    }
}
