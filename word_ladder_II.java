public class Solution {
    private String start;
    private String end;
    private HashSet<String> dict;
    private ArrayList<Node> bfs;
    private int index_of_end;
    private int index_of_begin;
    private int min_steps;
    private int word_len;
    private ArrayList<ArrayList<String>> answer;
    private HashMap<String, Node> is_in_pool;
    private class Node{
        public int steps;
        public String val;
        public ArrayList<int> pre;
        public Node(int steps, String val){
            this.steps = steps;
            this.val = val;
            pre = new ArrayList<int>();
        }
        public String change_str(int i, char a){
            return this.val.substring(0,i) + a + this.val.substring(i+1);
        }
    }
    private void start_bfs(){
        bfs = new ArrayList<Node>();
        Node node0 = new Node(1,start);
        bfs.add(node0);
        is_in_pool.put(start, node0);
        this.index_of_begin = 0;
        this.index_of_end = -1;
        int curr_index = 0;
        int i;
        char a;
        String tmp;
        Node curr, tmp_node;
        while( curr_index < bfs.size()){
           curr = bfs.get(curr_index);
           if ( curr.steps >= min_steps){
                break;
           }
           for( i = 0 ; i < word_len; i ++){
               for( a = 'a'; a <= 'z'; a++){
                    tmp = curr.change_str(i,a);
                    tmp_node = is_in_pool.get(tmp);
                    if (tmp_node == null){
                        // create a new node if possible
                        if (index_of_end >= 0)
                            continue;
                        tmp_node = new Node(tmp, curr.steps + 1);
                        bfs.add(tmp_node);
                        if ( tmp.equals(end)){
                             this.index_of_end = bfs.size() - 1;
                             this.min_steps = curr.steps + 1;
                        }
                        is_in_pool.put(tmp, tmp_node);
                    }
                    
                    if ( tmp_node.steps + 1 = curr.steps){
                        tmp_node.pre.add(curr_index);         
                    }
               }
           }

           curr_index ++;
        }
    }

    private void print(LinkedList<String> one_answer, int curr_index){
        Node curr = bfs.get(curr_index);
        one_answer.push(curr.val);
        if (curr_index == index_of_begin){
            ArrayList<String> tmp_answer = ArrayList<String>(one_answer);
            one_answer.pop();
            return;
        }

        for(int index: curr.pre){
            print(one_answer, index);    
        }
        one_answer.pop();
    }

    public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {
        // init variables
        this.word_len = start.lenght();
        this.start = start;
        this.end = end;
        this.dict = dict;
        this.start_bfs();
        this.min_steps = dict.size() + 3;
        this.is_in_pool = new HashMap<String, Node>();
        LinkedList<String> one_answer = new LinkedList<String>();
        print( one_answer, index_of_end);
        return answer;
    }
}
