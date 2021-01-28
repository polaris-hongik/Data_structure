public class Main {
	public static void main(String[] args) {
		Stack_custom<Integer> a = new Stack_custom<Integer>();
		for(int i = 0; i <500000; i++) {
			a.push(i);
		}
		Integer b[] = {1,2,3,4,5,6,7};
		System.out.println(a.pop());
		System.out.println(a.peek());
		System.out.println(a.pop());
	}
}
