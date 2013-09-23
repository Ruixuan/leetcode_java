public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // Start typing your Java solution below
        // DO NOT write main() function
        int head, tail;
        head = 0;
        tail = numbers.length - 1;
        while( head < tail ){
            while(numbers[head] + numbers[tail] > target){
                head ++;
            }
            while(numbers[head] + numbers[tail] > target ){
                tail ++;
            }
            if ( numbers[head] + numbers[tail] == target){
                int[] answer = new int[2];
                answer[0] = head;
                answer[1] = tail;
                return answer;
            }
        }
    }
}
