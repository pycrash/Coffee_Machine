import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        String num = scanner.nextLine();
        int rotation = scanner.nextInt();
        int[] numbers = convertStringToIntArray(num);
        reverseAndPrintArray(numbers, rotation);

    }
    private static void reverseAndPrintArray(int[] numbers, int rotation) {
        int[] newArray = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            newArray[(i + rotation) % numbers.length] = numbers[i];
        }
        for (int elements : newArray) {
            System.out.print(elements + " ");
        }
    }
    private static int[] convertStringToIntArray(String input) {
        String[] stringArray = input.split(" ");
        int[] numbers = new int[stringArray.length];
        int j = 0;
        for (String elements : stringArray) {
            numbers[j] = Integer.parseInt(elements);
            j++;
        }
        return numbers;
    }
}