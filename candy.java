public class Solution{
    public int candy(int[] ratings){
		// think it as a topological sort problem
		// because there are some dependencies
		// a < b , then there is a dependency a -> b
		int n = ratings.length;
		int[] pre_count = new int[n];
		for(int i = 0; i < n; i ++)
			pre_count[i] = 0;
		
		for(int i = 1; i < n; i ++){
			if (ratings[i] < ratings[i-1])
				pre_count[i-1] ++;
			if (ratings[i] > ratings[i-1])
				pre_count[i]++;				
		}
		int[] candies = new int[n];
		LinkedList<Integer> topo_que = new LinkedList<Integer>();
		for(int i = 0; i < n; i++)
			if (pre_count[i] == 0){
				candies[i] = 1;
				topo_que.add(i);
			}
		while( ! topo_que.isEmpty()){
			int i = topo_que.removeFirst();
			if (i>0)
				if ( ratings[i] < ratings[i - 1]){
					// remove dependency
					pre_count[i-1] --;
					// update the candies
					if ( candies[i] + 1 > candies[i-1])
						candies[i-1] = candies[i] + 1;
					if (pre_count[i-1] == 0)
						topo_que.add(i-1);
				}
			if (i < n-1)
				if ( ratings[i] < ratings[i + 1]){
					// remove dependency
					pre_count[i+1] --;
					// update the candies
					if ( candies[i] + 1 > candies[i+1])
						candies[i+1] = candies[i] + 1;
					if (pre_count[i+1] == 0)
						topo_que.add(i+1);
				}	
		}
		int sum = 0;
		for(int i = 0; i < n ; i ++)
			sum += candies[i];
		
		return sum;
	

    }
}
