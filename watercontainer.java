public class Solution {
    public int maxArea(int[] height) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.
        int n = height.length;
        if (n == 0)
            return 0;
            
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        left.add(0);
        
        for(int i = 1; i < n; i ++){
            if(height[i] > height[left.get(left.size() -1)])
                left.add(i);
        }
        
        right.add(n - 1);
        for(int i = n - 2; i >= 0; i --){
            if(height[i] > height[right.get(right.size() -1)])
                right.add(i);
        }
        
        int max_area = 0;
        Iterator<Integer> li = left.iterator();
        Iterator<Integer> ri = right.iterator();
        int l,r;
        l = 0;
        r = n - 1;
        while(li.hasNext()){
            l = li.next();
            max_area = Math.max(max_area, (r - l)* Math.min(height[r], height[l]));
            while(ri.hasNext()){
                if (height[l] <= height[r])
                    break;
                r = ri.next();
                max_area = Math.max(max_area, (r - l)* Math.min(height[r], height[l]));
            }
        }
        return max_area;
        
    }
}
