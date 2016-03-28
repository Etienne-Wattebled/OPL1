// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Test {
    public static void main(java.lang.String[] args) {
        java.lang.String a;
        a = null;
        if ((a != null)) {
            java.lang.System.out.println(a.length());
        } 
        java.lang.String[] tab;
        tab = new java.lang.String[]{ "Bonjour" , "Bonsoir" };
        if ((tab != null)) {
            java.lang.System.out.println(tab.length);
        } 
        A objetA;
        objetA = new A(null);
        if ((objetA != null)) {
            objetA.getA();
        } 
        if ((a != null) && ((a.length()) == 0)) {
            java.lang.System.out.println("Bonjour");
        } 
        int b;
        if ((a != null)) {
            b = a.length();
        } 
        int c;
        c = 1 + 1;
        int d;
        if ((tab != null)) {
            d = tab.length;
        } 
        int e;
        e = 0;
        int i;
        if ((a != null)) {
            for (i = a.length() ; i > 0 ; i++) {
                java.lang.System.out.println(i);
            }
        } 
        if ((tab != null)) {
            for (java.lang.String s : tab) {
                java.lang.System.out.println(s);
            }
        } 
        if (tab == null) {
            java.lang.System.out.println("Bonjour");
        } 
        if ((0 >= 0) && (tab != null) && ((0 < (tab.length)))) {
            if ((tab != null) && ((tab[0]) == null)) {
                if ((2 >= 0) && (tab != null) && ((2 < (tab.length)))) {
                    if ((tab != null)) {
                        java.lang.System.out.println(tab[2]);
                    } 
                } 
            } 
        } 
        if ((2 >= 0) && (tab != null) && ((2 < (tab.length)))) {
            if ((tab != null) && ((tab[2]) == null)) {
                java.lang.System.out.println("Bonsoir");
            } 
        } 
        if ((2 >= 0) && (tab != null) && ((2 < (tab.length)))) {
            if ((tab != null) && (tab[2] != null)) {
                java.lang.System.out.println(tab[2].length());
            } 
        } 
        java.lang.Integer[] t;
        t = new java.lang.Integer[10];
        if ((2 >= 0) && (t != null) && ((2 < (t.length)))) {
            if ((t != null)) {
                java.lang.System.out.println(t[2]);
            } 
        } 
        java.lang.String[][] o;
        o = new java.lang.String[10][10];
        int k;
        k = 0;
        int l;
        l = 0;
        if ((1 >= 0) && (o != null) && ((1 < (o.length)))) {
            if ((3 >= 0) && (o != null) && (o[1] != null) && ((3 < (o[1].length)))) {
                if ((o != null)) {
                    java.lang.System.out.println(o[1][3]);
                } 
            } 
        } 
        if ((k >= 0) && (o != null) && ((k < (o.length)))) {
            if ((l >= 0) && (o != null) && (o[k] != null) && ((l < (o[k].length)))) {
                if ((o != null)) {
                    java.lang.System.out.println(o[k][l]);
                } 
            } 
        } 
    }

    public static int a() {
        return 5;
    }
}

