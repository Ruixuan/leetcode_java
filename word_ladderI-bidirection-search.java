public class Solution {
    private ArrayList<Step> bfs_start;
    private ArrayList<Step> bfs_end;
    private String[] words;
    private int[] is_visited_start;
    private int[] is_visited_end;
    private int min_step;
    private int start_step;
    private int end_step;
    private int size;
    
    private int distance_str(String a, String b){

        int i,count;
        count = 0;
        for( i = 0; i < a.length(); i ++){
            if (a.charAt(i) != b.charAt(i)){
                count ++;
                if (count > 1) break;
            }           
        }
        return count;
    }
    
    private class Step{    
        String val;
        int step, index_pre;              
        public Step( String val, int step){
            this.val = val;
            this.step = step;   
        }
    }
    private int travel(ArrayList<Step> bfs, int[] is_visited_self, int[] is_visited_other ,int curr_step){
        if (curr_step >= bfs.size()){
            return curr_step;
        }
        int curr_depth = bfs.get(curr_step).step;
        int i;
        Step curr;      
        do{
        	curr = bfs.get(curr_step);
            if (curr.step != curr_depth)
                break;                
            for(i = 0; i < size; i ++){
                if (is_visited_self[i] != -1){
                    continue;
                }
                String tmp = words[i];
                
                if (distance_str(curr.val, tmp) == 1){
                    if( is_visited_other[i] > -1){
                        min_step = is_visited_other[i] + curr_step + 2;
                        return size;
                    }
                    Step new_step = new Step( tmp, curr_depth + 1);
                    bfs.add(new_step);
                    is_visited_self[i] = curr_depth + 1;
                }
            }
            curr_step ++;                       
        }while(curr.step == curr_depth && curr_step < bfs.size());
        return curr_step;
    }
    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i;
        if (start.equals(end)){
            return 1;
        }
        dict.remove(start);
        dict.remove(end);
        size = dict.size() + 2;
        bfs_start = new ArrayList<Step>();
        bfs_end = new ArrayList<Step>();
        is_visited_start = new int[size];
        is_visited_end = new int[size];
        for(i = 0; i < size; i ++){
            is_visited_start[i] = -1;
            is_visited_end[i] = -1;            
        }
        
        words = new String[size];
        words[0] = start;
        words[size - 1] = end;
        i = 1;
        for (String tmp:dict){
            words[i] = tmp;
            i ++;
        }
        
        min_step = size + 1;
        start_step = 0;
        end_step = 0;
        Step step0;
        step0 = new Step(start, 0);
        bfs_start.add(step0);
        is_visited_start[0] = 0;
        start_step = 0;
        step0 = new Step(end, 0);
        bfs_end.add(step0);
        is_visited_end[size - 1] = 0;
        end_step = 0;
        while(bfs_start.size() > start_step && bfs_end.size() > end_step){
            start_step = travel(bfs_start, is_visited_start, is_visited_end,start_step);
            end_step = travel(bfs_end, is_visited_end, is_visited_start, end_step);
        }
        if (min_step == size + 1){
            return 0;
        }else{
            return min_step;
        }
    }
}