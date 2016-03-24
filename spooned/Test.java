// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Test {
    public static void main(java.lang.String[] args) {
        java.lang.String a = "Toto";
        if (a != null) {
            java.lang.System.out.println(a.length());
        } 
        java.lang.String[] tab = new java.lang.String[]{ "Bonjour" , "Bonsoir" };
        if (tab != null) {
            java.lang.System.out.println(tab.length);
        } 
        A objetA = new A();
        if (objetA != null) {
            objetA.a();
        } 
        if ((a != null) && ((a.length()) == 0)) {
            java.lang.System.out.println("Bonjour");
        } 
        if (a != null) {
            int b = a.length();
        } 
        int c = 1 + 1;
        if (tab != null) {
            int d = tab.length;
        } 
    }

    public static void a() {
    }
}

