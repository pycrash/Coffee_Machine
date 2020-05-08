public class Main {

    public static void main(String[] args) {
        Secret[] secret = Secret.values();
        int counter = 0;
        for (int i = 0; i < secret.length; i++) {
                 if (secret[i].toString().startsWith("STAR")) {
                     counter++;
             }
        }
        System.out.println(counter);

    }
}
