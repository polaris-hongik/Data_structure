public class Main {
	public static void main(String[] args) {
		Array<Integer> a = new Array<Integer>(10);
		for(int i = 0; i < 10; i++) {
			a.add(i);
		}
		for(int i = 0; i < 12; i++) {
			System.out.println(i + ":" + a.get(i));
		}
		
		Integer b[] = a.toArray();
		for(int i = 0; i < 10; i++) {
			System.out.println(i + ":" + b[i]);
		}
		
		a.pop();
		for(int i = 0; i < 12; i++) {
			System.out.println(i + ":" + a.get(i));
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(i + ":" + b[i]);
		}
	}
}
