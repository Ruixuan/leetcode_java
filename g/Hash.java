import java.util.ArrayList;

public class Hash<T,E> {
	private class Entry{
		T key;
		E val;
		public Entry(T key, E val){
			this.key = key;
			this.val = val;
		}
	 	
	}
	private ArrayList<Entry>[] slots;
	private int size;
	 
	public Hash(int size){
		slots = new ArrayList[size];
		this.size = size;
		for(int i = 0; i < size; i ++)
			slots[i] = null;			
	}
	
	private int look_up(ArrayList<Entry> slot, T key){
		for(int i = 0; i < slot.size(); i ++)
			if(slot.get(i).key.equals(key))
				return i;
		return -1;
	}
	public void put(T key, E val){
		int hash_val = key.hashCode();
		if(slots[hash_val % size] == null)
			slots[hash_val % size] = new ArrayList<Entry>();
				
		ArrayList<Entry> slot = slots[hash_val % size];	
		Entry one_entry = new Entry(key, val);
		int val_index = look_up(slot, key);
	 
		if (val_index == -1)
			slot.add(one_entry);
		else
			slot.set(val_index, one_entry);
	}
	
	public E get(T key){
		//System.out.println(key);
		int hash_val;
		hash_val = key.hashCode();
		
		ArrayList<Entry> slot = slots[hash_val % size];
		if(slot == null){
			System.out.println("NOT FOUND");
			return null;
		}
		 		 
		int val_index = look_up(slot, key);
		
		if (val_index == -1)
			return null;
		else
			return slot.get(val_index).val;
	}
}
