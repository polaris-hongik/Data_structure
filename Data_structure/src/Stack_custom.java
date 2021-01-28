@SuppressWarnings("unchecked")
public class Stack_custom<T> {
	Array_custom<T[]> stack = new Array_custom<T[]>(100000);
	private int capacity;
	private int chunk;
	private int size;
	
	/******************************
	 * 이름: Stack 생성자
	 * 기능: 비어있는 배열을 Array_custom클래스에 만든다.
	 * 작성자: 박찬솔
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
	 * 이름: Stack 기본 연산
	 * 기능: Stack 크기 반환, 값을 채운 공간 크기 반환, 비었는지 가득찼는지 확인
	 * 작성자: 박찬솔
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
	 * 이름: grow메서드
	 * 기능: Stack 의 크기를 키우는 함수
	 * 작성자: 박찬솔
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
	 * 이름: get메서드
	 * 기능: 인덱스에 해당하는 값 반환
	 * 작성자: 박찬솔
	 *****************************/
	private T get( int i ) {
		if( i > size ) { return null; }
		else { return stack.get(i/chunk)[i%chunk]; }
	}
	
	/******************************
	 * 이름: add메서드
	 * 기능: 원하는 위치에 원하는 배열 대입
	 * 작성자: 박찬솔
	 *****************************/
	private void add(T[] arr) {
		if(size+arr.length > capacity)
			grow((size+arr.length-capacity)/chunk);
		for(int i = 0; i < arr.length; i++) { stack.get((i+size)/chunk)[(i+size)%chunk] = arr[i]; }
		size += arr.length;
	}
	
	/******************************
	 * 이름: push메서드
	 * 기능: 스택 맨 끝에 원하는 값 대입
	 * 작성자: 박찬솔
	 *****************************/
	public void push(T value) {
		if( isFull() )
			grow();
		stack.get(size/chunk)[size%chunk] = value;
		size++;
	}
	
	/******************************
	 * 이름: search메서드
	 * 기능: 찾고자 하는 값에 대한 인덱스 반환
	 * 작성자: 박찬솔
	 *****************************/
	public int search(T value) {
		for(int i = 0; i < size; i++) {
			if( stack.get(i/chunk)[i%chunk] == value ) { return size-i; }
		}
		return -1;
	}
	
	/******************************
	 * 이름: peek 메서드
	 * 기능: 맨 마지막 인덱스를 반환
	 * 작성자: 박찬솔
	 *****************************/
	public T peek() {
		if( isEmpty() ) { return null; }
		return get(size-1);
	}
	
	/******************************
	 * 이름: pop 메서드
	 * 기능: 맨 마지막 인덱스를 반환 및 삭제 
	 * 작성자: 박찬솔
	 *****************************/
	public T pop() {
		if( isEmpty() ) { return null; }
		return get(--size);
	}
	
	/******************************
	 * 이름: toArray 메서드
	 * 기능: 배열 포인터를 매개변수로 받아 직접 데이터 대입
	 * 작성자: 박찬솔
	 *****************************/
	public void toArray(T[] target) { for(int i = 0; i < size; i++) { target[i] = (T)stack.get(i/chunk)[i%chunk]; } }
	public void toArray(T[] target, int end){ for(int i = 0; i < end; i++) { target[i] = (T)stack.get(i/chunk)[i%chunk]; } }
	public void toArray(T[] target, int start,int end) { for(int i = start; i < end; i++) { target[i] = (T)stack.get(i/chunk)[i%chunk]; } }
}
