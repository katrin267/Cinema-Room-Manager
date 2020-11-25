import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 1; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }
        numbers[0] = scanner.nextInt();

        for (int num :
                numbers) {
            System.out.print(num + " ");
        }
    }
}