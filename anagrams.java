public class Solution {
    private String signiture(String s){
        char[] s_arr = s.toCharArray();
        Arrays.sort(s_arr);
        return new String(s_arr);
    }
    public ArrayList<String> anagrams(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashSet<String, String> sig_map = new HashSet<String, String>();
        String target = null;
        ArrayList<String> answer = new ArrayList();
        for(String s:strs){
            String sig = signiture(s);
            if (target == null){
                if (sig_map.containsKey(sig)){
                    target = sig;
                    answer.add(sig_map.get(sig));
                    answer.add(s);
                }else{
                    sig_map.put(sig, s);
                }
            }else{
                // target not null
                if (target.equals(sig)
                    answer.add(s);
            }
        }
        return answer;
        
    }
}
