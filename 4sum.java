public class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) {
        int n = num.length;
        ArrayList<ArrayList<Integer>> answer = new ArrayList<ArrayList<Integer>>();

        if ( n < 3)
            return answer;

        //bubble sort
        for( int i = 0; i < n; i ++)
            for( int j = n - 1; j > i; j --)
                if( num[j] < num[j-1]){
                    int tmp = num[j];
                    num[j] = num[i];
                    num[i] = tmp;
                }
        // now find sum 4
        for(int i = 0; i < n - 3; i ++){
            if ( i > 0)
                if ( num[i] == num[i - 1])
                    continue;
            for(int j = i + 1; j < n - 2; j ++){
                if ( j > i + 1)
                    if( num[j] == num[j - 1])
                        continue;
                int l = n - 1;
                for(int k = j + 1; k < l; k ++){
                    if (k > j + 1)
                       if( num[k] == num[k - 1])
                           continue;
                    while(num[i] + num[j] + num[k] + num[l] > target){
                        l --;
                        if ( l <= k) break;
                    }
                    if( l > k && num[i] + num[j] + num[k] + num[l] == target){
                        ArrayList<Integer> one_answer = new ArrayList<Integer>();
                        one_answer.add(num[i]);
                        one_answer.add(num[j]);
                        one_answer.add(num[k]);
                        one_answer.add(num[l]);
                        answer.add(one_answer);
                    }
                }
            }
        }
        return answer;
    }
}
