@SuppressWarnings("unchecked")
public class Array_custom<T> {
	T arr[];
	private int size;
	private int cursor;
	
	/******************************
	 * �̸�: Array������
	 * ���: ����ִ� ��� Ŭ������ �����.
	 * �ۼ���: ������
	 *****************************/
	public Array_custom() {
		this.arr = (T[]) new Object[0];
		this.cursor = -1;
		this.size = 0;
	}
	public Array_custom(int size) {
		this.arr = (T[]) new Object[size];
		this.cursor = -1;
		this.size = size;
	}
	public Array_custom(T[] arr) {
		this.arr = arr;
		this.cursor = -1;
		this.size = arr.length;
	}
	
	/******************************
	 * �̸�: Array �⺻ ����
	 * ���: Array ũ�� ��ȯ, ���� ä�� ���� ũ�� ��ȯ, ������� ����á���� Ȯ��
	 * �ۼ���: ������
	 *****************************/
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
	
	/******************************
	 * �̸�: get�޼���
	 * ���: �ε����� �ش��ϴ� �� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public T get( int i ) {
		if( i > cursor ) { return null; }
		else { return arr[i]; }
		
	}
	
	/******************************
	 * �̸�: add�޼���
	 * ���: ���ϴ� ��ġ�� ���ϴ� �� ����
	 * �ۼ���: ������
	 *****************************/
	public boolean add(T value) {
		if( isFull() ) { return false; }
		else {
			arr[++cursor] = value;
			return true;
		}
	}
	public boolean add(int key, T value) {
		if(key >= size) { return false; }
		else {
			arr[key] = value;
			if(key > cursor) { cursor = key; }
			return true;
		}
	}
	
	/******************************
	 * �̸�: find�޼���
	 * ���: ã���� �ϴ� ���� ���� �ε��� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public int find(T value) {
		for(int i = 0; i <= cursor; i++) {
			if( arr[i] == value ) { return i; }
		}
		return -1;
	}
	
	/******************************
	 * �̸�: remove �޼���
	 * ���: Ư�� ��(1��)�� ����
	 * �ۼ���: ������
	 *****************************/
	public boolean remove(T value) {
		int key = find(value);
		if( key > 0 ) {
			for(int i = key; i > cursor; i++) {
				arr[i] = arr[i+1];
			}
			return true;
		} else { return false; }
	}
	
	/******************************
	 * �̸�: pop �޼���
	 * ���: Ư�� �ε����� ��ȯ �� ���� 
	 * �ۼ���: ������
	 *****************************/
	public T pop() {
		if( isEmpty() ) { return null; }
		else { return get(cursor--); }
	}
	public T pop(int key) {
		T value = get(key);
		for(int i = key; i <= cursor; i++) {
			arr[i] = arr[i+1];
		}
		return value;
	}
	
	/******************************
	 * �̸�: toArray �޼���
	 * ���: �迭 �ڷ��� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public void toArray(T[] target) { for(int i = 0; i < cursor+1; i++) { target[i] = (T)arr[i]; } }
	public void toArray(T[] target, int end){ for(int i = 0; i < end; i++) { target[i] = (T)arr[i]; } }
	public void toArray(T[] target, int start,int end) { for(int i = start; i < end; i++) { target[i] = (T)arr[i]; } }
}
