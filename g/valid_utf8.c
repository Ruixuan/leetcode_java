#include <stdio.h>

int valid(char* s){
    int len, tmp, i;
    unsigned int bit7, bit67;
    bit7 = 1 << 7;
    bit67 = 3 << 6;
    while(*s){
        // count how many 1s in the head
        len = 0;
        tmp = (unsigned int)*s;
        while(tmp & bit7){
            len ++;
            tmp = tmp << 1;
        }
        if( len == 1 || len > 4)
            return 0;

        for(i = 0; i < len - 1; i ++){
            s ++;
            if (bit67 & (*s) != bit7)
                return 0;
        }
        s ++;
    }

    return 1;
}

int main(){
    char buffer[10];
    buffer[0] = (3 << 6) + 3;

    buffer[10] = 0;
    printf("%d \n", valid(buffer));

}
