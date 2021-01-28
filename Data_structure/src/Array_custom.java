@SuppressWarnings("unchecked")
public class Array_custom<T> {
	private T arr[];
	private int capacity;
	private int size;
	
	/******************************
	 * �̸�: Array������
	 * ���: ����ִ� ��� Ŭ������ �����.
	 * �ۼ���: ������
	 *****************************/
	public Array_custom() {
		this.arr = (T[]) new Object[0];
		this.size = 0;
		this.capacity = 0;
	}
	public Array_custom(int capacity) {
		this.arr = (T[]) new Object[capacity];
		this.size = 0;
		this.capacity = capacity;
	}
	public Array_custom(T[] arr) {
		this.arr = arr;
		this.size = 0;
		this.capacity = arr.length;
	}
	
	/******************************
	 * �̸�: Array �⺻ ����
	 * ���: Array ũ�� ��ȯ, ���� ä�� ���� ũ�� ��ȯ, ������� ����á���� Ȯ��
	 * �ۼ���: ������
	 *****************************/
	public int getSize() { return capacity; }
	public int getCursor() { return size; }
	public boolean isEmpty() {
		if( size == 0 ) { return true; }
		else { return false; }
	}
	public boolean isFull() {
		if( size == capacity ) { return true; }
		else { return false; }
	}
	
	/******************************
	 * �̸�: get�޼���
	 * ���: �ε����� �ش��ϴ� �� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public T get( int i ) {
		if( i > size ) { return null; }
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
			arr[size++] = value;
			return true;
		}
	}
	public boolean add(int key, T value) {
		if(key >= capacity) { return false; }
		else {
			arr[key] = value;
			if(key+1 > size) { size = key+1; }
			return true;
		}
	}
	
	/******************************
	 * �̸�: find�޼���
	 * ���: ã���� �ϴ� ���� ���� �ε��� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public int find(T value) {
		for(int i = 0; i < size; i++) {
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
			for(int i = key; i < size; i++) {
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
		else { return get(--size); }
	}
	public T pop(int key) {
		T value = get(key);
		for(int i = key; i < size; i++) {
			arr[i] = arr[i+1];
		}
		return value;
	}
	
	/******************************
	 * �̸�: toArray �޼���
	 * ���: �迭 �����͸� �Ű������� �޾� ���� ������ ����
	 * �ۼ���: ������
	 *****************************/
	public void toArray(T[] target) { for(int i = 0; i < size; i++) { target[i] = (T)arr[i]; } }
	public void toArray(T[] target, int end){ for(int i = 0; i < end; i++) { target[i] = (T)arr[i]; } }
	public void toArray(T[] target, int start,int end) { for(int i = start; i < end; i++) { target[i] = (T)arr[i]; } }
}
