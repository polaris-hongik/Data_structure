@SuppressWarnings("unchecked")
public class Vector_custom<T> {
	Array_custom<T[]> vec = new Array_custom<T[]>(100000);
	private int capacity;
	private int chunk;
	private int size;
	
	/******************************
	 * 이름: Vector생성자
	 * 기능: 비어있는 어레이 클래스를 Array_custom클래스에 만든다.
	 * 작성자: 박찬솔
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
	 * 이름: Vector 기본 연산
	 * 기능: Vector 크기 반환, 값을 채운 공간 크기 반환, 비었는지 가득찼는지 확인
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
	 * 기능: 벡터의 크기를 키우는 함수
	 * 작성자: 박찬솔
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
	 * 이름: get메서드
	 * 기능: 인덱스에 해당하는 값 반환
	 * 작성자: 박찬솔
	 *****************************/
	public T get( int i ) {
		if( i > size ) { return null; }
		else { return vec.get(i/chunk)[i%chunk]; }
	}
	
	/******************************
	 * 이름: add메서드
	 * 기능: 원하는 위치에 원하는 값 대입
	 * 작성자: 박찬솔
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
	 * 이름: find메서드
	 * 기능: 찾고자 하는 값에 대한 인덱스 반환
	 * 작성자: 박찬솔
	 *****************************/
	public int find(T value) {
		for(int i = 0; i < size; i++) {
			if( vec.get(i/chunk)[i%chunk] == value ) { return i; }
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
				vec.get(i/chunk)[i%chunk] = vec.get(i/chunk)[i%chunk];
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
	 * 이름: toArray 메서드
	 * 기능: 배열 포인터를 매개변수로 받아 직접 데이터 대입
	 * 작성자: 박찬솔
	 *****************************/
	public void toArray(T[] target) { for(int i = 0; i < size; i++) { target[i] = (T)vec.get(i/chunk)[i%chunk]; } }
	public void toArray(T[] target, int end){ for(int i = 0; i < end; i++) { target[i] = (T)vec.get(i/chunk)[i%chunk]; } }
	public void toArray(T[] target, int start,int end) { for(int i = start; i < end; i++) { target[i] = (T)vec.get(i/chunk)[i%chunk]; } }
}
