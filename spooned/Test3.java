// default package (CtPackage.TOP_LEVEL_PACKAGE_NAME in Spoon= unnamed package)



public class Test3 {
    public static void main(java.lang.String[] args) {
        C c1;
        c1 = new C();
        if ((c1 != null) && (c1.getC() != null) && (c1.getC().getC() != null)) {
            java.lang.System.out.println(c1.getC().getC().getC());
        } 
        if ((c1 != null) && (c1.getC() != null) && ((c1.getC().getC()) == c1)) {
        } 
        C[] tab;
        tab = new C[5];
        if ((0 >= 0) && (tab != null) && ((0 < (tab.length)))) {
            if ((tab != null) && (tab[0] != null) && (tab[0].getC() != null) && (tab[0].getC().getC() != null) && (tab[0].getC().getC().getS() != null)) {
                java.lang.System.out.println(tab[0].getC().getC().getS().length());
            } 
        } 
        if ((0 >= 0) && (tab != null) && ((0 < (tab.length)))) {
            if ((6 >= 0) && (tab != null) && (tab[0] != null) && (tab[0].getC() != null) && (tab[0].getC().getTab() != null) && ((6 < (tab[0].getC().getTab().length)))) {
                if ((tab != null) && (tab[0] != null) && (tab[0].getC() != null)) {
                    java.lang.System.out.println(tab[0].getC().getTab()[6].getC());
                } 
            } 
        } 
        if ((c1 != null) && (c1.c != null) && (c1.c.c != null) && (c1.c.c.c != null)) {
            if ((c1.c != null) && (c1.c.c != null) && (c1.c.c.c != null)) {
                if ((c1.c.c != null) && (c1.c.c.c != null)) {
                    if ((c1.c.c.c != null)) {
                        java.lang.System.out.println(c1.c.c.c.c);
                    } 
                } 
            } 
        } 
    }
}

