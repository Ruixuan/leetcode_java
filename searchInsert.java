public class Solution {
    public int searchInsert(int[] A, int target) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int head, tail, mid;
        head = 0;
        tail = A.length - 1;
        while( head <= tail){
            mid = head + (tail - head) / 2;
            if(A[mid] == target)
                return mid;
            if (A[mid] < target)
                head = mid + 1;
            else
                head = mid - 1;
        }
        return tail + 1;
    }
}
