public class Main {
	public static void main(String[] args) {
		Array a = new Array(10);
		for(int i = 0; i < 10; i++) {
			a.add(i);
		}
		for(int i = 0; i < 12; i++) {
			System.out.println(i + ":" + a.get(i));
		}
		
		int b[] = a.toArray();
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
