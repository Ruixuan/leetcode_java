public class Solution {
    char one_answer[];
    ArrayList<String> answer;
    int n;
    private void put(int i, int count_l){
        if ( count_l > n) 
            return;
    
        int count_r = i - count_l;
        if (count_r > count_l)
            return;
  
        if ( i >= 2*n){
            answer.add(new String(one_answer));
            return;
        }
       one_answer[i] = '(';
        put(i + 1, count_l + 1);
        one_answer[i] = ')';
        put(i + 1, count_l);
    }

    public ArrayList<String> generateParenthesis(int n) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        this.n = n;
        one_answer = new char[n*2];
        answer = new ArrayList<String>();
        put(0, 0);
        return answer;
    }
}
