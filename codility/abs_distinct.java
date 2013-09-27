class Solution {
    // no extra memory
    public int solution(int[] A){
        int pt_p, pt_n, curr_val, val_p, val_n, max;
        int pre;
        int count = 0;
        pt_p = A.length - 1;
        pt_n = 0;
        curr_val = -1;
        do{

           if ( pt_n < A.length){
               val_n = -A[pt_n];               
           }else{
               val_n = -1;
           }

           if ( pt_p >= 0){
               val_p = A[pt_p];
           }else{
               val_p = -1;
           }
           if ( val_p > val_n){
               max = val_p;
               pt_p --;
           }else{
               max = val_n;
               pt_n ++;
           }
            
           if ( max != curr_val && max >= 0){
               curr_val = max;
               count ++;
           }

        }while( max >= 0);
        return count;
    }
}
