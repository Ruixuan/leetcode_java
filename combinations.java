public class Solution {
    int one_answer[];
    ArrayList<ArrayList<Integer>> answer;
    int n,k;
    private void fill(int i, int smallest){
        if (i > k){
            answer.add(new ArrayList<Integer>(one_answer));
            return;
        }
        for(int val = smallest + 1; val <= n - (k - i) + 1; val ++){
            one_answer[i] = val;
            fill(i + 1, val);
        }
    }
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        this.n = n;
        this.k = k;
        one_answer = new int[k];
        answer = new ArrayList<ArrayList<Integer>>();
        fill(0,0);
        return answer;
    }
}
