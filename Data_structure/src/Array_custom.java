@SuppressWarnings("unchecked")
public class Array_custom<T> {
	private T arr[];
	private int capacity;
	private int size;
	
	/******************************
	 * 이름: Array생성자
	 * 기능: 비어있는 어레이 클래스를 만든다.
	 * 작성자: 박찬솔
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
	 * 이름: Array 기본 연산
	 * 기능: Array 크기 반환, 값을 채운 공간 크기 반환, 비었는지 가득찼는지 확인
	 * 작성자: 박찬솔
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
	 * 이름: get메서드
	 * 기능: 인덱스에 해당하는 값 반환
	 * 작성자: 박찬솔
	 *****************************/
	public T get( int i ) {
		if( i > size ) { return null; }
		else { return arr[i]; }
		
	}
	
	/******************************
	 * 이름: add메서드
	 * 기능: 원하는 위치에 원하는 값 대입
	 * 작성자: 박찬솔
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
	 * 이름: find메서드
	 * 기능: 찾고자 하는 값에 대한 인덱스 반환
	 * 작성자: 박찬솔
	 *****************************/
	public int find(T value) {
		for(int i = 0; i < size; i++) {
			if( arr[i] == value ) { return i; }
		}
		return -1;
	}
	
	/******************************
	 * 이름: remove 메서드
	 * 기능: 특정 값(1개)을 삭제
	 * 작성자: 박찬솔
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
	 * 이름: pop 메서드
	 * 기능: 특정 인덱스를 반환 및 삭제 
	 * 작성자: 박찬솔
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
	 * 이름: toArray 메서드
	 * 기능: 배열 포인터를 매개변수로 받아 직접 데이터 대입
	 * 작성자: 박찬솔
	 *****************************/
	public void toArray(T[] target) { for(int i = 0; i < size; i++) { target[i] = (T)arr[i]; } }
	public void toArray(T[] target, int end){ for(int i = 0; i < end; i++) { target[i] = (T)arr[i]; } }
	public void toArray(T[] target, int start,int end) { for(int i = start; i < end; i++) { target[i] = (T)arr[i]; } }
}
