@SuppressWarnings("unchecked")
public class Vector_custom<T> {
	T vec[];
	private int capacity;
	private int size;
	
	/******************************
	 * �̸�: Vector������
	 * ���: ����ִ� ��� Ŭ������ �����.
	 * �ۼ���: ������
	 *****************************/
	public Vector_custom() {
		this.vec = (T[]) new Object[0];
		this.size = 0;
		this.capacity = 0;
	}
	public Vector_custom(int capacity) {
		this.vec = (T[]) new Object[capacity];
		this.size = 0;
		this.capacity = capacity;
	}
	public Vector_custom(T[] arr) {
		this.vec = arr;
		this.size = 0;
		this.capacity = vec.length;
	}
	
	/******************************
	 * �̸�: Vector �⺻ ����
	 * ���: Vector ũ�� ��ȯ, ���� ä�� ���� ũ�� ��ȯ, ������� ����á���� Ȯ��
	 * �ۼ���: ������
	 *****************************/
	public int getCapacity() { return capacity; }
	public int getSize() { return size; }
	public boolean isEmpty() {
		if( size == 0 ) { return true; }
		else { return false; }
	}
	public boolean isFull() {
		if( size == capacity ) { return true; }
		else { return false; }
	}
	
	/******************************
	 * �̸�: grow�޼���
	 * ���: ������ ũ�⸦ Ű��� �Լ�
	 * �ۼ���: ������
	 *****************************/
	private void grow() {
	    T[] temp=(T[]) new Object[capacity];
	    capacity++;
	    toArray(temp);
	    vec = (T[]) new Object[capacity];
	    for(int i = 0; i < size; i++) { vec[i] = (T)temp[i]; }
	}
	private void grow(int x) {
	    T[] temp=(T[]) new Object[capacity];
	    capacity += x;
	    toArray(temp);
	    vec = (T[]) new Object[capacity];
	    for(int i = 0; i < size; i++) { vec[i] = (T)temp[i]; }
	}
	
	/******************************
	 * �̸�: get�޼���
	 * ���: �ε����� �ش��ϴ� �� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public T get( int i ) {
		if( i > size ) { return null; }
		else { return vec[i]; }
	}
	
	/******************************
	 * �̸�: add�޼���
	 * ���: ���ϴ� ��ġ�� ���ϴ� �� ����
	 * �ۼ���: ������
	 *****************************/
	public void add(T value) {
		if( isFull() )
			grow();
		vec[size++] = value;
	}
	public void add(int key, T value) {
		if(key >= capacity)
			grow(key-capacity+1);
		vec[key] = value;
		if(key+1 > size) { size = key+1; }
	}
	public void add(T[] arr) {
		if(size+arr.length > capacity)
			grow(size+arr.length-capacity);
		for(int i = size; i < capacity; i++) { vec[i] = arr[i-size]; }
		size += arr.length;
	}
	
	/******************************
	 * �̸�: find�޼���
	 * ���: ã���� �ϴ� ���� ���� �ε��� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public int find(T value) {
		for(int i = 0; i < size; i++) {
			if( vec[i] == value ) { return i; }
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
				vec[i] = vec[i+1];
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
		return get(--size);
	}
	public T pop(int key) {
		T value = get(key);
		for(int i = key; i < size; i++) {
			vec[i] = vec[i+1];
		}
		return value;
	}
	
	/******************************
	 * �̸�: toArray �޼���
	 * ���: �迭 �����͸� �Ű������� �޾� ���� ������ ����
	 * �ۼ���: ������
	 *****************************/
	public void toArray(T[] target) { for(int i = 0; i < size; i++) { target[i] = (T)vec[i]; } }
	public void toArray(T[] target, int end){ for(int i = 0; i < end; i++) { target[i] = (T)vec[i]; } }
	public void toArray(T[] target, int start,int end) { for(int i = start; i < end; i++) { target[i] = (T)vec[i]; } }
}
