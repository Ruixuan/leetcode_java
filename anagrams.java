public class Solution {
    private String signiture(String s){
        char[] s_arr = s.toCharArray();
        Arrays.sort(s_arr);
        return new String(s_arr);
    }
    public ArrayList<String> anagrams(String[] strs) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        HashMap<String, ArrayList<String> > sig_map = new HashMap<String, ArrayList<String>>();
        ArrayList<String> answer = new ArrayList();
        for(String s:strs){
            String sig = signiture(s);
            ArrayList<String> curr;
            if (!sig_map.containsKey(sig))
                sig_map.put(sig, new ArrayList<String>());
            curr = sig_map.get(sig);
            curr.add(s);
        }

        for(ArrayList<String> one_list:sig_map){
            answer.addAll(one_list);
        }
        return answer;
    }
}
