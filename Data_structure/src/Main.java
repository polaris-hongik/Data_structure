public class Main {
	public static void main(String[] args) {
		
		Array_custom<Integer> a = new Array_custom<Integer>(10);		
		for(int i = 0; i < 10; i++) {
			a.add(i);
		}
		System.out.println("Array_custom a");
		for(int i = 0; i < 12; i++) {
			System.out.println(i + ":" + a.get(i));
		}
		
		Integer[] b= new Integer[10];
        a.toArray(b);
        System.out.println("array b");
		for(int i = 0; i < 10; i++) {
			System.out.println(i + ":" + b[i]);
		}
		
		a.pop();
		System.out.println("Array_custom after pop a");
		for(int i = 0; i < 10; i++) {
			System.out.println(i + ":" + a.get(i));
		}
		
		System.out.println("array b");
		for(int i = 0; i < 10; i++) {
			System.out.println(i + ":" + b[i]);
		}
	}
}
