public class Solution {
    private boolean is_all_digit(String s){
         for( char a:s.toCharArray()){
           if  ( a <'0' || a > '9')
               return false;

        }
        return true;
   }
    public boolean isNumber(String s) {
        // Start typing your Java solution below
        // DO NOT write main() function
        s = s.trim();
        int index_e;
        index_e = s.indexOf('e');
        if (index_e != -1){
            if(!is_all_digit(s.substring(index_e + 1)))
                return false;
            if(index_e == s.length())
                return false;
        }else
            index_e = s.length();
            
        s = s.substring(0,index_e);
        int index_dot;
        index_dot = s.indexOf('.');
        if (index_dot != -1){
            String front, end;
            front = s.substring(0, index_dot);
            end = s.substring(index_dot + 1);
            if ( !(is_all_digit(front) && is_all_digit(end)))
                return false;
            if(front.length() + end.length() == 0)
                return false;
        }else
            return is_all_digit(s) && s.length() > 0;
            
        return true;
       
    }
}
