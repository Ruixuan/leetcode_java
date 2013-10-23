#include<stdio.h>

int divide(unsigned int a, unsigned int b){
    // return a / b 
    unsigned int remain;
    unsigned int result;
    unsigned int bit_i;
    int i;
    remain = 0;
    result = 0;
    for( i = 31; i >= 0 ; i--){
        bit_i = (a & (1 << i)) >> i;
        remain = (remain << 1) | bit_i ;
        printf("%d %d\n", remain, bit_i);
        result = result << 1;
        if (remain >= b){
            result = result | 1;
            remain -= b;
        }
        printf("%d %d %d \n", i, remain, result);
   }
    printf("-------------------------\n");
    return result;
}

int main(){
    printf("%d \n %d\n", divide(26, 13), divide(20,4));
   
    return 1;
}
