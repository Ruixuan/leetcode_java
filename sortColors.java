public class Solution {
    private void swap(int[] A, int i, int j){
        int tmp;
        tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public void sortColors(int[] A) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int p0, p2, n;
        n = A.length;
        p0 = 0;
        p2 = n - 1;
        int i =0;
        while(i < n){
            if(A[i] == 0 && p0 < i){
                swap(A, p0, i);
                p0 ++;
                continue;
            }
            if(A[i] == 2 && p2 > i){
                swap(A, p2, i);
                p2 --;
                continue;
            }
            i ++;
        }
    }
}
