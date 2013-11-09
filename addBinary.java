public class Solution {
    private void reverse(char[] a){
        for(int i = 0; i < a.length / 2 ; i ++){
            char tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = a[i];
        }
    }
    private int char2int(char a){
        return (int)(a - '0')
    }
    public String addBinary(String a, String b) {
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        reverse(ac);
        reverse(bc);
        int l;
        l = Math.max(ac.length, bc.length);
        int[] tmp = new int[l + 1];

        for(int i = 0; i < tmp.length; i ++)
            tmp[i] = 0;

        for(int i = 0; i < l; i ++){
            if ( i < ac.length)
                tmp[i] += char2int(ac[i]);
            if ( i < bc.length)
                tmp[i] += char2int(bc[i]);
            if (tmp[i] > 1){
                tmp[i] -= 2;
                tmp[i + 1] ++;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (tmp[l] == 1)
            sb.append(1);
        for(int i = l - 1; i >= 0; i --)
            sb.append(tmp[i]);

        return sb.toString();
    }
}
