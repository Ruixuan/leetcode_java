public class Solution {
    public int maxSubArray(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        if (A.length == 0)
            return 0;
        int sum, max;
        max = A[0];
        sum = 0;
        for(int val:A){
            sum += val;
            max = Math.max(sum, max);
            if(sum < 0)
                sum = 0;
        }
        return max;
    }
}
