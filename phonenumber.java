public class Solution{
    ArrayList<String> answer;
    HashMap<Character, char[]> digit_map;
    char[] digits;
    char[] one_answer;
    void generate(int i){
        if ( i >= digits.length){
            answer.add(new String(one_answer));
            return;
        }
        for(char c:digit_map.get(digits[i])){
            one_answer[i] = c;
            generate(i + 1);
        }
    }

    public ArrayList<String> letterCombinations(String digits){
        this.digits = digits.toCharArray();
        answer = new ArrayList<String>();
        digit_map = new HashMap<Character, char[]>();
        one_answer = new char[this.digits.length];
        digit_map.put('2', "abc".toCharArray());
        digit_map.put('3', "def".toCharArray());
        digit_map.put('4', "ghi".toCharArray());
        digit_map.put('5', "jkl".toCharArray());
        digit_map.put('6', "mno".toCharArray());
        digit_map.put('7', "pqrs".toCharArray());
        digit_map.put('8', "tuv".toCharArray());
        digit_map.put('9', "wxyz".toCharArray());
        generate(0);
        return answer;
    }
}
