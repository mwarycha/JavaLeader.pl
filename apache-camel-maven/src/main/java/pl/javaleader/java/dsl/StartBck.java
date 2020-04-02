package pl.javaleader.java.dsl;

public class StartBck {
    public static void main(String[] args) {
        try {
            CamelContextBck.createBck();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
