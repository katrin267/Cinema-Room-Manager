import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        int maxRow = 0;
        int maxColumn = 0;
        int max = 0;


        int[][] numbers = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                numbers[i][j] = scanner.nextInt();
                if (i == 0 && j == 0) {
                    max = numbers[i][j];
                }
                if (numbers[i][j] > max) {
                    max = numbers[i][j];
                    maxRow = i;
                    maxColumn = j;
                }
            }
        }

        System.out.println(maxRow + " " + maxColumn);
    }
}