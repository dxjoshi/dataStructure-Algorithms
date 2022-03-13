package algorithms.commonPatterns;

public class SlidingWindow {
    public static void main(String[] args) {
        int res = solve(new int[]{0,1,0,1,1,0,1,0,0,1,1,0,0,0});
        System.out.println(res);
    }

/*
    one = 5
    s - 0
    e - 5
*/
    private static int solve(int[] nums) {
        int ones = 0;
        for(int i = 0; i<nums.length; i++)    {
            if(nums[i] == 1) ones++;
        }
        System.out.println(ones );

        //sliding window of width ones from  0 to n-1
        int min = Integer.MAX_VALUE;
        int zeros = 0;
        for (int end = 0, start = 0; end <nums.length; end++)   {
            if (end - start > ones-1) {
                if (nums[start] == 0) zeros--;
                if (nums[end] == 0) zeros++;
                start++;
                min = Math.min(min, zeros);
            } else {
                if (nums[end] == 0) zeros++;
            }
            System.out.println(String.format("Start: %s | End: %s | Zeros: %s | Min: %s", start, end, zeros, min));
        }
        return min;
    }
}
