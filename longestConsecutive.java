
public class Solution {
    public int longestConsecutive(int[] num) {
        // Start typing your Java solution below
        // DO NOT write main() function
        HashSet<Integer> s = new HashSet<Integer>();
        int max,k,i,n;
        for(i = 0; i < num.length;i ++){
            s.add(num[i]);
        }
        max = 0;
        for(i = 0; i < num.length;i ++){
            if (s.contains(num[i]-1)){
                continue;
            }
            k = num[i] + 1;
            while(s.contains(k)){
                k ++;
            }
            if ( k - num[i]  > max){
                max = k - num[i];
            }
        }
        return max;       
    }
}    
