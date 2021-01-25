public class Array {
	private int arr[];
	private int size;
	private int cursor;
	
	public Array() {
		this.arr = new int[100];
		this.cursor = -1;
		this.size = 100;
	}
	public Array(int size) {
		this.arr = new int[size];
		this.cursor = -1;
		this.size = size;
	}
	
	public int getSize() { return size; }
	public int getCursor() { return cursor; }
	public boolean isEmpty() {
		if( cursor == -1 ) { return true; }
		else { return false; }
	}
	public boolean isFull() {
		if( cursor == size-1 ) { return true; }
		else { return false; }
	}
	
	public int get( int i ) {
		if( i > cursor ) { return -2147483648; }
		else { return arr[i]; }
		
	}
	
	public boolean add(int value) {
		if( isFull() ) { return false; }
		else {
			arr[++cursor] = value;
			return true;
		}
	}
	public boolean add(int key, int value) {
		if(key >= size) { return false; }
		else {
			arr[key] = value;
			if(key > cursor) { cursor = key; }
			return true;
		}
	}
	
	public int find(int value) {
		for(int i = 0; i <= cursor; i++) {
			if( arr[i] == value ) { return i; }
		}
		return -1;
	}
	
	public boolean remove(int value) {
		int key = find(value);
		if( key > 0 ) {
			for(int i = key; i > cursor; i++) {
				arr[i] = arr[i+1];
			}
			return true;
		} else { return false; }
	}
	
	public int pop() {
		if( isEmpty() ) { return -2147483648; }
		else { return get(cursor--); }
	}
	public int pop(int key) {
		int value = get(key);
		for(int i = key; i <= cursor; i++) {
			arr[i] = arr[i+1];
		}
		return value;
	}
	
	public int[] toArray() {
		return arr;
	}
	public int[] toArray(int end) {
		int[] result = new int[end];
		for(int i = 0; i < end; i++) {
			result[i] = arr[i];
		}
		return result;
	}
	public int[] toArray(int start,int end) {
		int[] result = new int[end-start];
		for(int i = start; i < end; i++) {
			result[i-start] = arr[i];
		}
		return result;
	}
}
