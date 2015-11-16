// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Test {
    public static void main(java.lang.String[] args) {
        boolean bool1 = true;
        java.lang.Boolean bool2 = false;
        int a = 0;
        java.util.Scanner sc = new java.util.Scanner(java.lang.System.in);
        if (sc != null) {
            java.lang.System.out.println("Lol");
        } 
        int b = sc.nextInt();
        if (b >= 8) {
            b = b + 1;
        } 
        java.lang.System.out.println(b);
        java.lang.Integer c = null;
        java.lang.System.out.println(c);
        java.lang.String s = null;
        java.lang.System.out.println(s);
        s = "Toto";
        java.lang.System.out.println(s.compareTo("Mdr"));
        java.lang.System.out.println(s);
        int[] tab = new int[10];
        java.lang.System.out.println(tab.length);
        for (int i = 0 ; i <= (tab.length) ; i++) {
            tab[i] = i;
        }
        for (int i : tab) {
            java.lang.System.out.println(i);
        }
        tab = null;
        java.lang.System.out.println(tab[0]);
    }
}

