import java.util.LinkedList;


public class C {
	public C c;
	private String s;
	private C tab[];
	
	public C() {
		this.c = null;
	}
	public C(C c) {
		this.c = c;
	}
	public C getC() {
		return c.getC().getC();
	}
	public String getS() {
		return this.s;
	}
	public C[] getTab() {
		return tab;
	}
	public LinkedList<C> getAllC() {
		return null;
	}
}
