	
	private static void qsort(int[] a, int start, int end){
		if(start >= end)
			return;
		int i, j, pivot;
		pivot = a[start];
		i = start;
		j = end;
		while( i < j ){
			while(i < j && a[j] > pivot)
				j --;
			if(i < j){
				a[i] = a[j];
				i ++;
			}
			while(i < j && a[i] < pivot)
				i ++;
			if(i < j){
				a[j] = a[i];
				j --;
			}
		}
		a[i] = pivot;
		qsort(a, start, i - 1);
		qsort(a, i + 1, end);
	}
