
public class Test3 {
	public static void main(String args[]) {
		C c1 = new C();
		System.out.println(c1.getC().getC().getC());
		if (c1.getC().getC() == c1) {
			
		}
		C[] tab = new C[5];
		System.out.println(tab[0].getC().getC().getS().length());
		System.out.println(tab[0].getC().getTab()[6].getC());
		System.out.println(c1.c.c.c.c);
	}
}
