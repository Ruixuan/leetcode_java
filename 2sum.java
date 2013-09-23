public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer,Integer> number_index_map = new HashMap<Integer,Integer>();
        for(int i=0; i < numbers.length; i ++){
            number_index_map.put(new Integer(numbers[i]), new Integer(i));
        }
        for (int i = 0; i < numbers.length; i ++){
            Integer tmp = number_index_map.get(new Integer(i));
            if (tmp == null){
                continue;
            }
            int[] answer = new int[2];
            answer[0] = i + 1;
            answer[1] = tmp.intValue();
            return answer;
        }
        return new int[2];
    }
/*    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int head, tail;
        int[] answer = new int[2];
        Arrays.sort(numbers);
        head = 0;
        tail = numbers.length - 1;
    
        while( head < tail ){
            // find a tail that enable number[head] + number[tail] == target          
            while( numbers[head] + numbers[tail] > target){
                tail --;
            }
            if ( numbers[head] + numbers[tail] == target){
                answer[0] = head;
                answer[1] = tail;
                return answer;
            }
            head ++;
        }
        return answer;
    }*/
}

