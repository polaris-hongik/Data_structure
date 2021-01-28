public class Main {
	public static void main(String[] args) {
		Vector_custom<Integer> a = new Vector_custom<Integer>();
		for(int i = 0; i <5000000; i++) {
			a.add(i);
		}
		Integer b[] = {1,2,3,4,5,6,7};
		System.out.println(a.pop());
		System.out.println(a.pop());
		System.out.println(a.pop());
	}
}
