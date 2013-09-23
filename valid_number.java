public class Solution {
    private boolean is_all_digit(String s){
        for( char a:s){
           if  ( a <'0' || a > '9')
               return false;

        }
        return true;
   }
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        String front,back;
        String[] tmp;
        s = s.trim();
        tmp = s.split("e");
        if (tmp.length > 2){
            return false;
        }
        if ( tmp == 2){
            if (!is_all_digit(tmp[1]))
                return false;
        }
        s = tmp[0];
        tmp = s.split("\\.");
        if (tmp.length > 2){
            return false;
        }
        if (tmp.length == 2){
            return is_all_digit(tmp[0]) && is_all_digit(tmp[1]);
        }else{
            return is_all_digit(tmp[0]);
        }

       
    }
}
