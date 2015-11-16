import java.util.Scanner;

public class Test {
	public static void main(String args[]) {
		boolean bool1 = true;
		Boolean bool2 = false;
		int a = 0;
		Scanner sc = new Scanner(System.in);
		if (sc != null) {
			System.out.println("Lol");
		}
		int b = sc.nextInt();
		if (b >= 8) {
			b = b + 1;
		}
		System.out.println(b);
		Integer c = null;
		System.out.println(c);
		String s = null;
		System.out.println(s);
		s = "Toto";
		System.out.println(s.compareTo("Mdr"));
		System.out.println(s);
		int tab[] = new int[10];
		System.out.println(tab.length);
		for (int i = 0; i <= tab.length;i++) {
			tab[i] = i;
		}
		for (int i: tab) {
			System.out.println(i);
		}
		tab = null;
		System.out.println(tab[0]);
	}
}
