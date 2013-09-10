public class Solution {
    int min_step;
    private ArrayList<ArrayList<String>> answer;
    private ArrayList<Step> bfs;
    private int distance_str( String a, String b){
        if (a.length() != b.length()){
            return a.length();
        }
        int i,count;
        count = 0;
        for( i = 0; i < a.length(); i ++){
            if (a.charAt(i) != b.charAt(i)){
                count ++;
            }
            if (count > 1) return count;
        }
        return count;
    }
    private class Step{    
        String val;
        int step, index_pre;              
        public Step( String val, int step, int index_pre){
            this.val = val;
            this.step = step;
            this.index_pre = index_pre;
        }
    }
    private void add_answer(int tail, String end){
        ArrayList<String> one_answer = new ArrayList<String>();
        int i;
        i = tail;
        while(i >= 0){
            Step tmp;
            tmp = bfs.get(i);
            one_answer.add(tmp.val);
            i = tmp.index_pre;
        }
        // reverse the string list 
        Collections.reverse(one_answer);
        one_answer.add(end);
        answer.add(one_answer);      
    }
    
    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        min_step = dict.size() + 1;
        answer =  new ArrayList<ArrayList<String>>();
        bfs = new ArrayList<Step>();
        int i,j;
        Step step0 = new Step(start, 0, -1);
        bfs.add(step0);
        if(distance_str(start,end) == 1){
            add_answer(0,end);
            min_step = 0;
        }
        if(start.equals(end)){
            add_answer(0,end);
            min_step = -1;
        }
        i = 0;
        
        while( i < bfs.size()){           
            Step curr = bfs.get(i);
            if (curr.step >= min_step){
                break;
            }
            // find all possible neighbors
            for(String tmp: dict){             
                if (distance_str(curr.val,tmp) == 1){
                    Step new_step = new Step(tmp, curr.step + 1, i);
                    bfs.add(new_step);
                    if (distance_str(end,tmp) == 1){
                        add_answer(bfs.size() -1, end);
                        min_step = curr.step + 1;
                    }
                }
            }
            i ++;
        }
        return answer;
    }
}