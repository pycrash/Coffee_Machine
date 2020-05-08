import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] nums = new int[length];
        int sum = 0;
        for (int i = 0; i < length; i++) {
            nums[i] = scanner.nextInt();
            sum += nums[i];
        }
        System.out.println(sum);
    }
}