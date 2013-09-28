public class Solution{
    public int longestValidParentheses(String s){
        char[] tokens = s.toCharArray();
        LinkedList<Integer> stack = new LinkedList<Integer>();
        int curr_len, longest;
        curr_len = 0;
        longest = 0;
        stack.push(-1);
        for( int i = 0; i < tokens.length; i ++){
            if ( '(' == tokens[i])
                stack.push(i);
            else{
                if (1 < stack.size()){
                    stack.pop();
                    curr_len = i - stack.getFirst();
                    if (curr_len > longest)
                        longest = curr_len;
                }else{
                    stack.clear();
                    stack.push(i);
                }
                    
            }
        }
        return longest;
    }
}
