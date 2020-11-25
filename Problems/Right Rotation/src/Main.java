import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] line = scanner.nextLine().split(" ");
        int lineLength = line.length;

        int shift = scanner.nextInt() % lineLength;
        if (shift == 0) {
            System.out.println(String.join(" ", line));
            return;
        }

        String[] shiftedLine = new String[lineLength];
        System.arraycopy(line, 0, shiftedLine, shift, lineLength - shift);
        System.arraycopy(line, lineLength - shift, shiftedLine, 0, shift);

        System.out.println(String.join(" ", shiftedLine));

    }
}