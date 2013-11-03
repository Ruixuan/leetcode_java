public class Solution {
    boolean breakable[];
    
    ArrayList<String> answer;
    Set<String> dict;
    LinkedList<String> curr;
    private void dfs(String s, int i){
        if( i >= s.length()){
            StringBuilder sb = new StringBuilder();
            for(String one:curr){
                sb.append(one);
                sb.append(' ');
            }
            answer.add(sb.toString().trim());
            return;
        }
        for(int j = i+1; j <= s.length(); j ++)
            if (breakable[j]){
                String word;
                word = s.substring(i,j);
                if(dict.contains(word)){
                    curr.addLast(word);
                    dfs(s, j);
                    curr.removeLast();
                }
            }
    }
    public ArrayList<String> wordBreak(String s, Set<String> dict) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n;
        n = s.length();
        this.dict = dict;
        answer = new ArrayList<String>();
        if (n == 0)
            return answer;
            
        breakable = new boolean[n + 1];
    
        for(int i = 0; i <= n; i ++)
            breakable[i] = false;
        breakable[0] = true;
        for(int i = 1; i <= n; i ++)
            for(int j = 0; j < i; j ++){
                if(breakable[i])
                    break;
                if (dict.contains(s.substring(j,i)) && breakable[j])
                    breakable[i] = true;
            }
        
        curr = new LinkedList<String>();        
        if(breakable[n])
            dfs(s,0);
        return answer;
    }
}
