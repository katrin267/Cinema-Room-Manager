import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = scanner.nextInt();
        }

        int prod = 0;
        for (int i = 1; i < numbers.length; i++) {
            int prodAdj = numbers[i - 1] * numbers[i];
            if (prod < prodAdj) {
                prod = prodAdj;
            }
        }

        System.out.println(prod);
    }
}