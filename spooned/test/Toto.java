package test;


public class Toto {
    public static void main(java.lang.String[] args) {
        if(args == null ) throw new IllegalArgumentException("[Spoon inserted check] null passed as parameter");;
        java.lang.String a = null;
        if (a.equals("lol")) {
            java.lang.System.out.println("Mdr");
        } 
        a = "Toto";
        java.lang.System.out.println(a);
    }
}

