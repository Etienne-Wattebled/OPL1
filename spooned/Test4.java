// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Test4 {
    public static void main(java.lang.String[] args) {
        C c1;
        c1 = new C();
        if ((c1 != null)) {
            new C(c1.getC());
        } 
        C c2;
        if ((c1 != null)) {
            c2 = new C(c1.getC());
        } 
        if ((c1 != null)) {
            Test4.toto(new java.util.LinkedList<C>(c1.getAllC()));
        } 
    }

    public static void toto(java.util.LinkedList<C> list) {
    }
}

