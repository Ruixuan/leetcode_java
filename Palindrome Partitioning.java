public class Solution {
    private boolean[][] is_pali;
    LinkedList<String> one_answer; 
    ArrayList<ArrayList<String>> answer_list; 
    int length;
    private void append_one_answer(){
        ArrayList<String> tmp = new ArrayList<String>();
        // copy the linkedlist to an arraylist and add to the answer list
        for(String sub_str: this.one_answer){
            tmp.add(sub_str);
        }
        this.answer_list.add(tmp);
    }
    // generate answer recursively
    private void gen_answer(int index, String s){
        if (index >= this.length){
            this.append_one_answer();
        }
        int end;
        for ( end = index; end < s.length(); end ++){
            if (this.is_pali[index][end]){                
                // add one sub string
                one_answer.add(s.substring(index,end+1));
                this.gen_answer(end+1, s);
                //backtrace
                one_answer.removeLast();  
            }
        }
    }
    
    public ArrayList<ArrayList<String>> partition(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int i,l,j;
        length = s.length();
        // init is_pali
        this.is_pali = new boolean[length][length];
        for( i = 0; i < length; i ++){
            //true for one length string
            this.is_pali[i][i] = true;
            // true for zero length string
            if (i < length - 1){
                this.is_pali[i+1][i] = true;
            }    
        }
        //calc  is_pali[][]
        for( l = 2; l <= length; l++)
            for( i = 0; i <= length - l; i++){
                j = i + l - 1;
                this.is_pali[i][j] = this.is_pali[i+1][j-1] && s.charAt(i) == s.charAt(j);
            }
        // now we can generate the answer list
        one_answer = new LinkedList<String>();
        answer_list = new ArrayList<ArrayList<String>>();
        this.gen_answer(0, s);
        return this.answer_list;             
    }
}