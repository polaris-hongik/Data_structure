@SuppressWarnings("unchecked")
public class Stack_custom<T> {
	Array_custom<T[]> stack = new Array_custom<T[]>(100000);
	private int capacity;
	private int chunk;
	private int size;
	
	/******************************
	 * �̸�: Stack ������
	 * ���: ����ִ� �迭�� Array_customŬ������ �����.
	 * �ۼ���: ������
	 *****************************/
	public Stack_custom() {
		this.chunk = 100000;
		this.stack.add((T[]) new Object[chunk]);
		this.size = 0;
		this.capacity = 0;
	}
	public Stack_custom(int chunk) {
		this.chunk = chunk;
		this.stack.add((T[]) new Object[chunk]);
		this.size = 0;
	}
	public Stack_custom(T[] arr) {
		this.chunk = 100000;
		this.stack.add((T[]) new Object[chunk]);
		this.capacity = 0;
		this.size = 0;
		add(arr);
	}
	/******************************
	 * �̸�: Stack �⺻ ����
	 * ���: Stack ũ�� ��ȯ, ���� ä�� ���� ũ�� ��ȯ, ������� ����á���� Ȯ��
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
	 * ���: Stack �� ũ�⸦ Ű��� �Լ�
	 * �ۼ���: ������
	 *****************************/
	private void grow() {
	    capacity+=chunk;
	    stack.add((T[]) new Object[chunk]);
	}
	private void grow(int i) {
	    capacity+=(chunk*i);
	    for(int j = 0; j < i; j++) {
		    stack.add((T[]) new Object[chunk]);
	    }
	}
	
	/******************************
	 * �̸�: get�޼���
	 * ���: �ε����� �ش��ϴ� �� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	private T get( int i ) {
		if( i > size ) { return null; }
		else { return stack.get(i/chunk)[i%chunk]; }
	}
	
	/******************************
	 * �̸�: add�޼���
	 * ���: ���ϴ� ��ġ�� ���ϴ� �迭 ����
	 * �ۼ���: ������
	 *****************************/
	private void add(T[] arr) {
		if(size+arr.length > capacity)
			grow((size+arr.length-capacity)/chunk);
		for(int i = 0; i < arr.length; i++) { stack.get((i+size)/chunk)[(i+size)%chunk] = arr[i]; }
		size += arr.length;
	}
	
	/******************************
	 * �̸�: push�޼���
	 * ���: ���� �� ���� ���ϴ� �� ����
	 * �ۼ���: ������
	 *****************************/
	public void push(T value) {
		if( isFull() )
			grow();
		stack.get(size/chunk)[size%chunk] = value;
		size++;
	}
	
	/******************************
	 * �̸�: search�޼���
	 * ���: ã���� �ϴ� ���� ���� �ε��� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public int search(T value) {
		for(int i = 0; i < size; i++) {
			if( stack.get(i/chunk)[i%chunk] == value ) { return size-i; }
		}
		return -1;
	}
	
	/******************************
	 * �̸�: peek �޼���
	 * ���: �� ������ �ε����� ��ȯ
	 * �ۼ���: ������
	 *****************************/
	public T peek() {
		if( isEmpty() ) { return null; }
		return get(size-1);
	}
	
	/******************************
	 * �̸�: pop �޼���
	 * ���: �� ������ �ε����� ��ȯ �� ���� 
	 * �ۼ���: ������
	 *****************************/
	public T pop() {
		if( isEmpty() ) { return null; }
		return get(--size);
	}
	
	/******************************
	 * �̸�: toArray �޼���
	 * ���: �迭 �����͸� �Ű������� �޾� ���� ������ ����
	 * �ۼ���: ������
	 *****************************/
	public void toArray(T[] target) { for(int i = 0; i < size; i++) { target[i] = (T)stack.get(i/chunk)[i%chunk]; } }
	public void toArray(T[] target, int end){ for(int i = 0; i < end; i++) { target[i] = (T)stack.get(i/chunk)[i%chunk]; } }
	public void toArray(T[] target, int start,int end) { for(int i = start; i < end; i++) { target[i] = (T)stack.get(i/chunk)[i%chunk]; } }
}
