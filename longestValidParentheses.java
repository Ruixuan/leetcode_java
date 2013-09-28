public class Solution{
    public int longestValidParentheses(String s){
        char[] tokens = s.toCharArray();
        LinkedList<char> stack = new LinkedList<char>();
        int curr_len, longest;
        curr_len = 0;
        longest = 0;
        for(char a:tokens){
            if ( a == '(')
                stack.add(a);
            else{
                if (stack.isEmpty())
                    curr_len = 0;
                else{
                    stack.pop();
                    curr_len += 2;
                    if (curr_len > longest)
                        longest = curr_len;
                }
            }
        }
        return longest;
    }
}

/*public class Solution {
    public int longestValidParentheses(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        char[] tokens = s.toCharArray();
        int n = tokens.length;
        int[] left_match = new int[n]; // ')'
        int[] right_match = new int[n]; // '('
        int left_count;
        int right_count;
        left_count = 0;
        for( int i = 0; i < n ; i ++){
            if (tokens[i] == '(')
                left_count ++;
            else
                left_count --;
            
            if ( left_count >= 0)
                left_match[i] = 1;
            else{
                left_match[i] = 0;
                //reset, start over
                left_count = 0;
            }
       }
       right_count = 0;
       for(int i = n - 1; i >= 0; i--){
            if (tokens[i] == ')')
                right_count ++;
            else
                right_count --;
            if ( right_count >= 0)
                right_match[i] = 1;
            else{
                right_match[i] = 0;
                // reset 
                right_count = 0;
            }
       }
       int curr_len = 0 ; 
       int longest = 0;
       for(int i = 0; i < n ; i ++)
           if ( right_match[i] + left_match[i] == 2){
               curr_len ++;
               if (curr_len > longest)
                   longest = curr_len;
           }else
               curr_len = 0;

       return longest;

    }
}*/
