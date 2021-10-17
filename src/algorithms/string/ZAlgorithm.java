package algorithms.string;

public class ZAlgorithm {

    public static void main(String[] args) {
        String pattern = "aabcaabxaaaz";
        int[] z = zAlgo(pattern.toCharArray());
        for (int i = 0; i < pattern.length(); i++) {
            System.out.print(z[i] + ", ");
        }
    }

    /*
    * https://github.com/AhmadElsagheer/Competitive-programming-library/blob/master/strings/Z_Algorithm.java
    * */
    static int[] zAlgo(char[] s)
    {
        int n = s.length;
        int[] z = new int[n];
        for(int i = 1, l = 0, r = 0; i < n; ++i)
        {
            if(i <= r)
                z[i] = Math.min(r - i + 1, z[i - l]);
            while(i + z[i] < n && s[z[i]] == s[i + z[i]])
                ++z[i];
            if(i + z[i] - 1 > r)
                r = i + z[l = i] - 1;
        }
        return z;
    }

    static int[] zFunction(String s) {
        int n = s.length();
        int z[] = new int[n];
        int R = 0;
        int L = 0;
        for(int i = 1; i < n; i++) {
            z[i] = 0;
            if (R > i) {
                z[i] = Math.min(R - i, z[i - L]);
            }
            while (i + z[i] < n && s.charAt(i+z[i]) == s.charAt(z[i])) {
                z[i]++;
            }
            if (i + z[i] > R) {
                L = i;
                R = i + z[i];
            }
        }
        z[0] = n;
        return z;
    }
}
