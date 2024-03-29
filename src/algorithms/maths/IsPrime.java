package algorithms.maths;

public class IsPrime {
    public static void main(String[] args) {
        System.out.println(String.format("Is Prime? %s", isPrime(29)));;
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
