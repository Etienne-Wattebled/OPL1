
public class Test {
	public static void main(String args[]) {
		String a = "Toto";
		System.out.println(a.length());
		String tab[] = {"Bonjour", "Bonsoir"};
		System.out.println(tab.length);
		A objetA = new A();
		objetA.a();
		if (a.length() == 0) {
			System.out.println("Bonjour");
		}
		int b = a.length();
		int c = 1+1;
		int d = tab.length;
		int e;
		e = 0;
		for (int i = a.length();i>0;i++) {
			System.out.println(i);
		}
		for (String s : tab) {
			System.out.println(s);
		}
	}
	public static void a() {
		
	}
}
