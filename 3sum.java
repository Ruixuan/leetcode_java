public class Solution {
    private boolean equal(ArrayList<Integer> a, ArrayList<Integer> b){
        if (a.size() != b.size())
            return false;
        for(int i = 0; i < a.size(); i ++)
            if (!a.get(i).equals(b.get(i)))
                return false;
        return true;
    }
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        int i,j,k,n;
        n = num.length;
        if ( n < 3) return result;
        Arrays.sort(num);
        for( i = 0; i < n - 2; i ++){
            if ( num[i] > 0 ) break;
            if ( i >0)
                if (num[i] == num[i -1] ) continue;
            k = n - 1;
            j = i + 1;
            while( k > j){
                if (num[i] + num[j] + num[k] == 0){
                  ArrayList<Integer> one_answer = new ArrayList<Integer>();
                  one_answer.add(num[i]);
                  one_answer.add(num[j]);
                  one_answer.add(num[k]);
                  result.add(one_answer);                  
                  do{ k --;} while(k > j && num[k] == num[k + 1]);
                  do{ j ++;} while(k > j && num[j] == num[j - 1]);
                }else
                    if (num[i] + num[j] + num[k] > 0)
                        k --;
                    else
                        j ++;
            }
        }
        return result;        
    }
}
