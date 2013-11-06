public class Solution {
    int find(int A[], int B[], int k){
        // find the k-th element in two sorted array
        // two pointer: i, j and i + j = k
        // 1 3 5 7 9
        // 2 4 6 8 10     
        int i = 0, j = 0;
        int head, tail, mid;
        head = 1;
        tail = A.length;
        int flag;
        while(head <= tail){
            flag = 0;// flag to indicate how to move two pointers
            mid = ( head + tail) / 2;
            i = mid;
            j = k - i;
            if (j < 1)
                flag = - 1;
            if ( j > B.length)
                flag = 1;
            if ( j < B.length)
                if(A[i - 1] > B[j])
                    flag = -1;
            if (i < A.length)
                if(A[i] < B[i - 1])
                    flag = 1;
            if (flag == 0)
                break;
            if (flag == 1)
                head = mid + 1;
            if (flag == -1)
                tail = mid - 1;
        }
        return Math.max(A[i  - 1], B[j - 1]);
    }
    public double findMedianSortedArrays(int A[], int B[]) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int m = A.length;
        int n = B.length;
        if ( (m + n) % 2 == 1)
            return find(A, B, (m + n) / 2);
        else
            return ((double)(find(A, B, (m + n) / 2) + find(A, B, (m + n) / 2 - 1))) / 2;
    }
}
