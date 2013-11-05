	private static int[] merge_sort(int a[]){
		if(a.length <= 1)
			return a;
		// split array into two part
		int[] first, second;
		int len = a.length;
		first = new int[len / 2];
		for(int i = 0; i < len / 2; i ++)
			first[i] = a[i];
		first = merge_sort(first);
		second = new int[len - len / 2];
		for(int i = len / 2; i < len; i ++)
			second[i - len / 2] = a[i];
		second = merge_sort(second);
		int p1 = 0;
		int p2 = 0;
		
		for(int i = 0; i < len; i ++){
			int flag = 1;
			if(p1 >= first.length)
				flag = 2;
			
			if(p1 < first.length && p2 < second.length)
				if(first[p1] > second[p2])
					flag = 2;
			if(flag == 1){
				a[i] = first[p1];
				p1 ++;
			}else{
				a[i] = second[p2];
				p2 ++;
			}
			
		}
		return a;
	}
