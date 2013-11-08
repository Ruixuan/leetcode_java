public class Solution{
    public double pow(double x, int n){
        int flag = 0;
        if (n == 0)
            return 1;
        if (n < 0){
            flag = 1;
            n = -n;
        }
        double answer = 1;
        while(n > 0){
            if ( (n & 1) == 1)
                answer *= x;
            x = x * x;
            n = n >> 1;

        }
        if (flag == 1)
           return 1.0 / answer;
        else
           return answer;
    }
}
