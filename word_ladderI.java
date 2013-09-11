public class Solution {
    private ArrayList<Step> bfs;
    
    private int min_step;
    private int distance_str(String a, String b){
        if (a.length() != b.length()){
            return a.length();
        }
        int i,count;
        count = 0;
        for( i = 0; i < a.length(); i ++){
            if (a.charAt(i) != b.charAt(i)){
                count ++;
            }           
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
    
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function 
        bfs = new ArrayList<Step>();
        dict.remove(start);        
        dict.remove(end);    
        int dict_size = dict.size();
        min_step = dict_size + 1;           
        String[] words = new String[dict_size + 2];
        words[0] = start;
        boolean[] is_visited = new boolean[dict_size + 2];
		is_visited [0] = true;
        words[dict_size + 1] = end;      
        String tmp;
        int i,j;
        i = 1;
        for(String tmp1:dict){
            words[i] = tmp1;
            i ++;
        }
        Step step0 = new Step(start, 0, -1);
        bfs.add(step0);        
        if(start.equals(end)){           
            min_step = -1;
        }
        i = 0;
        Step curr;   
        while( i < bfs.size() && min_step > dict_size){  
            curr = bfs.get(i);
            for(j = 1; j < dict_size + 2; j ++){ 
                if ( is_visited[j])
                    continue;
                tmp = words[j];    
                if (distance_str(curr.val,tmp) == 1){
                    Step new_step = new Step(tmp, curr.step + 1, i);
                    bfs.add(new_step); 
                    is_visited[j] = true;
                    if (end.equals(tmp)){                       
                        min_step = curr.step;   
                        break;
                    }
                }
            }
            i ++;
        }
        if (min_step > dict_size){
            return 0;
        }else{
            return min_step + 2;
        }
        
    }
}