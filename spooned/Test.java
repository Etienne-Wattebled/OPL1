// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Test {
    public static void main(java.lang.String[] args) {
        java.lang.String a;
        a = "Toto";
        if (a != null) {
            java.lang.System.out.println(a.length());
        } 
        java.lang.String[] tab;
        tab = new java.lang.String[]{ "Bonjour" , "Bonsoir" };
        if (tab != null) {
            java.lang.System.out.println(tab.length);
        } 
        A objetA;
        objetA = new A();
        if (objetA != null) {
            objetA.a();
        } 
        if ((a != null) && ((a.length()) == 0)) {
            java.lang.System.out.println("Bonjour");
        } 
        int b;
        b = a.length();
        int c;
        c = 1 + 1;
        int d;
        if (tab != null) {
            d = tab.length;
        } 
        int e;
        e = 0;
        int i;
        for (i = a.length() ; i > 0 ; i++) {
            java.lang.System.out.println(i);
        }
        if (tab != null) {
            for (java.lang.String s : tab) {
                if (s != null) {
                    java.lang.System.out.println(s);
                } 
            }
        } 
    }

    public static void a() {
    }
}

