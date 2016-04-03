// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class C {
    public C c;

    private java.lang.String s;

    private C[] tab;

    public C() {
        this.c = null;
    }

    public C(C c) {
        this.c = c;
    }

    public C getC() {
        return c.getC().getC();
    }

    public java.lang.String getS() {
        return this.s;
    }

    public C[] getTab() {
        return tab;
    }

    public java.util.LinkedList<C> getAllC() {
        return null;
    }
}

