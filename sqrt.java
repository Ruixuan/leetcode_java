public class Solution {
    public int sqrt(int x) {
        // tricky part
        //
        if ( x == 0){
            return 0;
        }
        int head, tail, k;       
        int tmp;
        head = 1;
        tail = (x ) / 2 + 1;
        while(head <= tail){
            // tricky part 1: avoid int over flow
            k = head + ( - head + tail) / 2; // alternative 
            // tricky part 2: using div rather than multiply
            tmp = x / k;
            if ( tmp == k){
                return k;
            }
            if ( k < tmp ){
                head = k + 1;
            }else{
                tail = k - 1;
            }
        }
        return tail;
    }
}
