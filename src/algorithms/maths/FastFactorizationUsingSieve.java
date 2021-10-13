package algorithms.maths;

import java.util.ArrayList;
import java.util.List;

public class FastFactorizationUsingSieve {

    public static void main(String[] args) {
        int n = 50;
        List<Integer> list = factorization(n);
        System.out.println(list);
    }

    private static List<Integer> factorization(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 2; i * i <= n; ++i) {
            while (n % i == 0) {
                res.add(i);
                n /= i;
            }
        }
        if (n != 1) {
            res.add(n);
        }
        return res;
    }
}

