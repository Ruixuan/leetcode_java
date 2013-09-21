public class Solution {
        public double pow(double x, int n) {
            // power(x, n ) = power(x*x, n/2) * x^(n mod 2)
            int i,k;
            int flag = 0;
            if ( n == 0)
                return 1;
            if ( x ==0){
                return 0;
            }
            if ( n < 0){
                n = -n;
                flag = 1;
            }
            double answer;
            answer = 1;
            
            while( n > 0){
                k = n % 2;
                if (k == 1){
                    answer *= x;
                }// other wise answer = answer * 1
                x = x * x;
                n = n / 2;
            }
            
            if (flag == 1){
                return 1/answer;
            }else{
                return answer;
            }
    }
}
