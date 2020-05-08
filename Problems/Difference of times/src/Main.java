import java.util.Scanner;

class Main {
    final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int a1 = scanner.nextInt();
        int b1 = scanner.nextInt();
        int c1 = scanner.nextInt();

        int a2 = scanner.nextInt();
        int b2 = scanner.nextInt();
        int c2 = scanner.nextInt();

        int seconds1 = a1 * 60 * 60 + b1 * 60 + c1;
        int seconds2 = a2 * 60 * 60 + b2 * 60 + c2;

        System.out.println(seconds2 - seconds1);


    }
}