import java.util.HashSet;


public class test {

	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	private static void find(int[] A, int target){
		int head, tail, k;
		int start, end;
		head = 0;
		tail = A.length - 1;
		while( head <= tail){
			k = head + (tail - head) / 2;// avoid int over flow
			if (A[k] <= target)
				head = k + 1;
			else 
				tail = k - 1;			
		}
		end = tail;
		head = 0;
		tail = A.length - 1;
		
		while( head <= tail){
			k = head + (tail - head) / 2;// avoid int over flow
			if (A[k] < target)
				head = k + 1;
			else 
				tail = k - 1;			
		}
		//  tail <= target < A[head] 
		start = head;
		System.out.println(start);
		System.out.println(end);
	}
	private static String reverse(String s){
		if (s.isEmpty()) return "";
		else return reverse(s.substring(1)) + s.substring(0,1); 
				
	}
	
	private static int search_sorted_array(int[] A, int target){
		int index,pivot,head, tail, k;
		head = 0;
		tail = A.length - 1;
		//first step find pivot point
		while(A[head] > A[tail]){
			k = head + (tail - head) / 2;
			if (A[k] < A[head])
				tail = k - 1;
			else 
				head = k + 1;				
		}
		pivot = head % A.length;
		System.out.println(pivot);
		if (A[0] > target){
			head = pivot;
			tail = A.length - 1;
		}else{
			head = 0;
			tail = (pivot - 1 + A.length) % A.length;
		}
		index = -1;
		while(head <= tail){
			k = head + (tail - head) / 2;
			if (A[k] == target){
				index = k;
				break;
			}
			if (A[k] < target)
				head = k + 1;
			else
				tail = k - 1;
		}
		System.out.println(index);
		return index;
	}
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int[] A = {0,0,1,2,3,3,3,3,3,4,7,7,9};
		find(A,17);
		//int[] B = {5,6,7,8,1,2,3,4};
		int[] B = {1,2,3,4,5,6,7,8};		
		search_sorted_array(B, 0);
		search_sorted_array(B, 7);
		search_sorted_array(B, 8);
		search_sorted_array(B, 15);
		
	}

}
