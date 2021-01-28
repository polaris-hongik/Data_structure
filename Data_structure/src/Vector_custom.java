@SuppressWarnings("unchecked")
public class Vector_custom<T> {
	Array_custom<T[]> vec = new Array_custom<T[]>(100000);
	private int capacity;
	private int chunk;
	private int size;
	
	/******************************
	 * �̸�: Vector������
	 * ���: ����ִ� ��� Ŭ������ Array_customŬ������ �����.
	 * �ۼ���: ������
	 *****************************/
	public Vector_custom() {
		this.chunk = 100000;
		this.vec.add((T[]) new Object[chunk]);
		this.size = 0;
		this.capacity = 0;
	}
	public Vector_custom(int chunk) {
		this.chunk = chunk;
		this.vec.add((T[]) new Object[chunk]);
		this.size = 0;
	}
	public Vector_custom(T[] arr) {
		this.chunk = 100000;
		this.vec.add((T[]) new Object[chunk]);
		this.capacity = 0;
		this.size = 0;
		add(arr);
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
		if( size >= capacity ) { return true; }
		else { return false; }
	}
	
	/******************************
	 * �̸�: grow�޼���
	 * ���: ������ ũ�⸦ Ű��� �Լ�
	 * �ۼ���: ������
	 *****************************/
	private void grow() {
	    capacity+=chunk;
	    vec.add((T[]) new Object[chunk]);
	}
	private void grow(int i) {
	    capacity+=(chunk*i);
	    for(int j = 0; j < i; j++) {
		    vec.add((T[]) new Object[chunk]);
	    }
	}
	
	/******************************
	 * �̸�: get�޼���
	 * ���: �ε����� �ش��ϴ� �� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public T get( int i ) {
		if( i > size ) { return null; }
		else { return vec.get(i/chunk)[i%chunk]; }
	}
	
	/******************************
	 * �̸�: add�޼���
	 * ���: ���ϴ� ��ġ�� ���ϴ� �� ����
	 * �ۼ���: ������
	 *****************************/
	public void add(T value) {
		if( isFull() )
			grow();
		vec.get(size/chunk)[size%chunk] = value;
		size++;
	}
	public void add(int key, T value) {
		if(key >= capacity)
			grow((key-capacity)/chunk);
		vec.get(size/chunk)[size%chunk] = value;
		if(key+1 > size) { size = key+1; }
	}
	public void add(T[] arr) {
		if(size+arr.length > capacity)
			grow((size+arr.length-capacity)/chunk);
		for(int i = 0; i < arr.length; i++) { vec.get((i+size)/chunk)[(i+size)%chunk] = arr[i]; }
		size += arr.length;
	}
	
	/******************************
	 * �̸�: find�޼���
	 * ���: ã���� �ϴ� ���� ���� �ε��� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public int find(T value) {
		for(int i = 0; i < size; i++) {
			if( vec.get(i/chunk)[i%chunk] == value ) { return i; }
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
				vec.get(i/chunk)[i%chunk] = vec.get(i/chunk)[i%chunk];
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
			vec.get(i/chunk)[i%chunk] = vec.get(i/chunk)[i%chunk];
		}
		return value;
	}
	
	/******************************
	 * �̸�: toArray �޼���
	 * ���: �迭 �����͸� �Ű������� �޾� ���� ������ ����
	 * �ۼ���: ������
	 *****************************/
	public void toArray(T[] target) { for(int i = 0; i < size; i++) { target[i] = (T)vec.get(i/chunk)[i%chunk]; } }
	public void toArray(T[] target, int end){ for(int i = 0; i < end; i++) { target[i] = (T)vec.get(i/chunk)[i%chunk]; } }
	public void toArray(T[] target, int start,int end) { for(int i = start; i < end; i++) { target[i] = (T)vec.get(i/chunk)[i%chunk]; } }
}
