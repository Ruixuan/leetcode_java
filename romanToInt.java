public class Solution{
    // input is 1 -- 3999
    // rules
    // I V X L C D M
    HashMap<Character, Integer> value;
    public int romanToInt(String s){
        value = new HashMap<Character, Integer>();
        value.put('I', 1);
        value.put('V', 5);
        value.put('X', 10);
        value.put('L', 50);
        value.put('C', 100);
        value.put('D', 500);
        value.put('M', 1000);
        int result = 0;
        char[] numbers = s.toCharArray();
        for(int i = 0; i < numbers.length; i ++){
            int val = value.get(numbers[i]);
            if( i != numbers.length - 1)
                if ( value.get(numbers[i + 1]) > val)
                    val = -val;
            result += val;
        }

        return result;
    }
}
