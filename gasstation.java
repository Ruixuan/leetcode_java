public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        
        int n = cost.length;
        if (n == 0)
            return -1;
        if (n == 1){
            if (cost[0] > gas[0])
                return -1;
            else 
                return 0;
        }
        int[] remains = new int[n];
        for(int i = 0; i < n; i++)
            remains[i] = gas[i] - cost[i];
        int start, end, sum;
        start = 0;
        end = 1;
        sum = remains[0];
        while(start != end){
            while(sum < 0){
                start --;
                if (start < 0)
                    start += n;
                sum += remains[start];    
                if (start == end)                    
                    break;
                
            }
            while(sum >= 0){
                sum += remains[end];
                end ++;
                if (end >= n)
                    end -= n;
                if (start == end)    
                    break;
            }
        }
        if (sum >= 0 )
            return start;
        else 
            return -1;
    }
}
