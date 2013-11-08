public class Solution {
    public int[] searchRange(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int head, tail, mid;
        int[] answer = new int[]{-1, -1};
        if (A.length == 0)
            return answer;

        head = 0;
        tail = A.length - 1;
        
        while(head <= tail){
            mid = (head + tail) / 2;
            if (A[mid] <= target)
                head = mid + 1;
            else
                tail = mid - 1;
        }
        
        if (tail < 0 || A[tail] != target)
            return answer;
            
        answer[1] = tail;
        head = 0;
        tail = A.length - 1;
        while(head <= tail){
            mid = (head + tail) / 2;
            if (A[mid] < target)
                head = mid + 1;
            else
                tail = mid - 1;
        }
        answer[0] = head;
        return answer;
    }
}
