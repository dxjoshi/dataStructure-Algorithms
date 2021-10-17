package algorithms.string;

public class KMP {
    public static void main(String[] args) {
        String txt = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";
        int[] prefix = prefix(pattern);
        for (int i = 0; i < prefix.length; i++) {
            System.out.print(prefix[i] + " ");
        }
        System.out.println();
        KMPSearch(pattern, txt);
    }

/*
    Method to create the prefix array
    TC: O(n^2)
    We compute the prefix values π[i] in a loop by iterating from i=1 to i=n−1 (π[0] just gets assigned with 0).
    To calculate the current value π[i] we set the variable j denoting the length of the best suffix for i−1. Initially j=π[i−1].
    Test if the suffix of length j+1 is also a prefix by comparing s[j] and s[i]. If they are equal then we assign π[i]=j+1, otherwise we reduce j to π[j−1] and repeat this step.
    If we have reached the length j=0 and still don't have a match, then we assign π[i]=0 and go to the next index i+1.
*/
    private static int[] prefix(String pattern) {
        char[] s = pattern.toCharArray();
        int n = s.length;
        int[] pi = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pi[i-1];
            while (j > 0 && s[i] != s[j]) {
                j = pi[j-1];
            }
            if (s[i] == s[j])   {
                j++;
            }
            pi[i] = j;
        }
        return pi;
    }

    static void KMPSearch(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Preprocess the pattern (calculate lps[]
        // array)
        prefix(pat);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
    }
}