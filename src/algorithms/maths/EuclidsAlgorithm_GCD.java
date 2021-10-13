package algorithms;

public class EuclidAlgoGCD {
    public static void main(String[] args) {
        int result = gcd(6, 10);
        System.out.println(result);
    }

    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a%b);
    }

}
