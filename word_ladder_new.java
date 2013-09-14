public class Solution {
    private class Node{
        public int step;
        public String val;
        public Node(String val, int step){
            this.step = step;
            this.val = val;                       
            }

        public String replace(int i, char a){
            return val.substring(0,i) + a + val.substring(i + 1);
        }
    }

    LinkedList<Node> bfs;
    int size;
    int word_len;
    int min_steps;
    HashSet<String> dict;
    String start, end;

    private void init(String start, String end, HashSet<String> dict){
        this.dict = new HashSet<String>(dict);
        this.dict.add(start);
        this.dict.add(end);
        this.start = start;
        this.end = end;
        word_len = start.length();
        size = this.dict.size();
        Node node0 = new Node(start, 1);
        bfs = new LinkedList<Node>();
        bfs.add(node0);
        min_steps = size + 1;
    }

    private void bfs_start(){
        Iterator<Node> it = bfs.iterator();
        Node curr;
        int i;
        char a;
        String tmp;
        Node tmp_node;
        while(!bfs.isEmpty()){
            curr = bfs.pop();
            // replace the i-th word with a
            for(i = 0; i < word_len; i ++){
                for(a = 'a'; a <= 'z'; a ++){
                    if (a == curr.val.charAt(i)){
                        continue;
                    }
                    tmp = curr.replace(i,a);
                    if (tmp.equals(end)){
                        min_steps = curr.step + 1;
                        return;
                    }
                    if (dict.contains(tmp)){
                        tmp_node = new Node(tmp, curr.step + 1);
                        bfs.add(tmp_node);
                        dict.remove(tmp);
                    }
                }
            }
        }
        min_steps = 0;
        return;
    }

    public int ladderLength(String start, String end, HashSet<String> dict) {
        // Start typing your Java solution below
        // DO NOT write main() function
        init(start, end, dict);       
        bfs_start();
        return min_steps;
    }
}
