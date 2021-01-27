public class Main {
	public static void main(String[] args) {
		Vector_custom<Integer> a = new Vector_custom<Integer>();
		a.add(3);
		a.add(4);
		Integer c[] = {1,2,3,4,5,9};
		a.add(c);
		System.out.println(a.pop());
		
		Array_custom<Integer> b = new Array_custom<Integer>(1);
		b.add(3);
		System.out.println(b.pop());
	}
}
