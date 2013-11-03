public class Solution {
    private String remove_front(String s){
        if (s.length() == 0)
            return s;
        if (s.charAt(0) == '-' || s.charAt(0) == '+')
            return s.substring(1);
        else 
            return s;
    }
    
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
        s = remove_front(s);
        int index_e;
        index_e = s.indexOf('e');
        if (index_e != -1){
            String power = s.substring(index_e + 1);
            power = remove_front(power);
            if(!is_all_digit(power))
                return false;
                
            if(power.length() == 0)
                return false;
        }else
            index_e = s.length();
            
        s = s.substring(0,index_e);
        int index_dot;
        index_dot = s.indexOf('.');
        if (index_dot != -1){
            String front, end;
            
            front = remove_front(s.substring(0, index_dot));
            
            if (index_dot == s.length() - 1)
                end = "";
            else
                end = s.substring(index_dot + 1);
                
            if (end.length() != 0)    
                if (end.charAt(0) == '-')
                    return false;
            if ( !(is_all_digit(front) && is_all_digit(end)))
                return false;
            if(front.length() + end.length() == 0)
                return false;
        }else
            return is_all_digit(s) && s.length() > 0;
        return true;
    }
}
