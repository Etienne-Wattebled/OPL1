
public class Test {
	public static void main(String args[]) {
		String a = null;
		System.out.println(a.length());
		String tab[] = {"Bonjour", "Bonsoir"};
		System.out.println(tab.length);
		A objetA = new A(null);
		objetA.getA();
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
		if (tab == null) {
			System.out.println("Bonjour");
		}
		if (tab[0] == null) {
			System.out.println(tab[2]);
		}
		if (tab[2] == null) {
			System.out.println("Bonsoir");
		}
		System.out.println(tab[2].length());
		Integer t[] = new Integer[10];
		System.out.println(t[2]);
		String o[][] = new String[10][10];
		int k =0;
		int l = 0;
		System.out.println(o[1][3]);
		System.out.println(o[k][l]);
	}
	public static int a() {
		return 5;
	}
}
