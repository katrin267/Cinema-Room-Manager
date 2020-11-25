import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        int greaterThan = scanner.nextInt();

        int sum = 0;
        for (int num :
                numbers) {
            if (num > greaterThan) {
                sum += num;
            }
        }

        System.out.println(sum);
    }
}