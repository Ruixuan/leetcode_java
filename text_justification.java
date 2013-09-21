public class Solution {
    private String repeat_space(int len){
        String tmp = "";
        for(int i = 0; i < len; i ++)
            tmp += " ";
        return tmp;        
    }
    private String fill_one_line(ArrayList<String> words_list, int m){
        // seperate word list with m spaces
        int k = words_list.size();
        if ( k == 0){
            return "";
        }
        if ( k == 1){
            return words_list.get(0) + repeat_space(m);
        }
	int tmp_len;
        int base_len = m / (k-1);
        int extra_count = m % (k-1);
        String tmp;
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < k - 1; i ++){
            if ( i < extra_count){
                tmp_len = base_len + 1;
            }else{
                tmp_len = base_len;
            }
            tmp = repeat_space( tmp_len);
            builder =  builder.append(words_list.get(i)).append(tmp);
        }
        builder.append(words_list.get(k - 1));
        return builder.toString();
    }

    public ArrayList<String> fullJustify(String[] words, int L) {
        // Start typing your Java solution below
        // DO NOT write main() function
        ArrayList<String> words_list = new ArrayList<String>();
        ArrayList<String> answer = new ArrayList<String>();
        int curr_len = 0;
        for( String one_word: words){
            // check if we need create a new line
            if ( curr_len + one_word.length() + words_list.size() > L){
                answer.add(fill_one_line( words_list, L - curr_len));
                words_list = new ArrayList<String>();
                curr_len = 0;
            }
            words_list.add(one_word);
            curr_len += one_word.length();
        }
        // print out the last line
        String tmp;
        tmp = fill_one_line( words_list, words_list.size() - 1);
        tmp += repeat_space(L - tmp.length());
        answer.add(tmp); 
        return answer;
    }
}
