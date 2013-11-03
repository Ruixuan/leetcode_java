public class Solution {
    public int threeSumClosest(int[] num, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        Arrays.sort(num);
        int n;
        n = num.length;
        
        int closest = num[0] + num[1] + num[2];
        for(int i = 0; i < n; i ++){
            int k = n - 1;
            for(int j = i + 1; j < n; j ++){
                while(k > j && num[i] + num[j] + num[k] > target){
                    if (Math.abs(num[i] + num[j] + num[k] - target) < Math.abs(closest - target))
                        closest = num[i] + num[j] + num[k];
                    k --;
                }
                if (k > j)
                    if (Math.abs(num[i] + num[j] + num[k] - target) < Math.abs(closest - target))
                        closest = num[i] + num[j] + num[k];
            }
        }
        return closest;
        
    }
}
