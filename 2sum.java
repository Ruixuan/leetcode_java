public class Solution {
    public int[] twoSum(int[] numbers, int target) {
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
    }
}

