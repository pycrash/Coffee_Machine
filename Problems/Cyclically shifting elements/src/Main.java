import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int length = scanner.nextInt();
        int[] nums = new int[length];

        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                nums[0] = scanner.nextInt();
            } else {
                nums[i + 1] = scanner.nextInt();
            }
        }
        for (int i : nums) {
        System.out.print(i + " ");
        }

    }
}