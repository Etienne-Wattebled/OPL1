// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class A extends B {
    public A(A a) {
        super(a.getA());
    }

    public int getA() {
        return a;
    }
}

