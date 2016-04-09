import java.util.LinkedList;



public class Test4 {
	public static void main(String args[]) {
		C c1 = new C();
		new C(c1.getC());
		C c2 = new C(c1.getC());
		toto(new LinkedList<C>(c1.getAllC()));
	}
	public static void toto(LinkedList<C> list) {
		
	}
}
