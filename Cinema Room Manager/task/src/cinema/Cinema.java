package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    final static Scanner scanner = new Scanner(System.in);
    final static String SOLD_SEAT = "B";
    static int rows;
    static int seats;
    static int numberOfSoldTickets = 0;
    static int currentIncome = 0;
    static boolean isExit;
    static String[][] seatsArray;

    public static void main(String[] args) {

        System.out.println("Enter the number of rows:");
        rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        seats = scanner.nextInt();

        fillSeatsArray();

        while (!isExit) {
            showMenu();
        }
//        calculateProfit();
    }


    public static void showMenu() {
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                printOutCinema();
                break;
            case 2:
                sellTicket();
                break;
            case 3:
                printStatistics();
                break;
            case 0:
                isExit = true;
                break;
            default:
                break;
        }
    }

    public static void printStatistics() {
        System.out.println();
        System.out.printf("Number of purchased tickets: %d %n", numberOfSoldTickets);
        System.out.printf("Percentage: %.2f%% %n", (float) numberOfSoldTickets * 100f /(rows * seats));
        System.out.printf("Current income: $%d %n", currentIncome);
        System.out.printf("Total income: $%d %n", calculateProfit());
    }


    public static void sellTicket() {
        boolean isInputCorrect = false;
        int rowNumber = 0;
        int seatNumber = 0;
        while (!isInputCorrect) {

            System.out.println("Enter a row number:");
            rowNumber = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber = scanner.nextInt();
            System.out.println();

            if (rowNumber > rows || rowNumber < 0 || seatNumber > seats || seatNumber < 0) {
                System.out.println("Wrong input!");
            } else if (seatsArray[rowNumber - 1][seatNumber - 1].equals(SOLD_SEAT)) {
                System.out.println("That ticket has already been purchased!");
            } else {
                isInputCorrect = true;
            }
        }

        int ticketPrice = calculateTicketPrice(rowNumber);
        System.out.println();
        System.out.printf("Ticket price: $%d", ticketPrice);

        addSeat(rowNumber, seatNumber);
        currentIncome += ticketPrice;
        numberOfSoldTickets++;
    }

    public static void fillSeatsArray() {
        seatsArray = new String[rows][seats];
        for (String[] row : seatsArray) {
            Arrays.fill(row, "S");
        }
    }

    public static void addSeat(int rowNumber, int seatNumber) {
        seatsArray[rowNumber - 1][seatNumber - 1] = SOLD_SEAT;
    }

    public static void printOutCinema() {
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= seatsArray[0].length; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        int rowNumToPrint = 1;

        for (String[] row :
                seatsArray) {
            System.out.print(rowNumToPrint + " ");
            for (String seat :
                    row) {
                System.out.print(seat + " ");
            }
            rowNumToPrint++;
            System.out.println();
        }
        System.out.println();
    }

    public static int calculateProfit() {
        int profit;

        int totalNumberOfSeats = rows * seats;

        if (totalNumberOfSeats < 60) {
            profit = 10 * totalNumberOfSeats;
        } else {
            int firstHalf = rows / 2;
            int secondHalf = rows - firstHalf;
            profit = firstHalf * seats * 10 + secondHalf * seats * 8;
        }
        return profit;
    }

    public static int calculateTicketPrice(int rowNumber) {
        if (rows * seats < 60 || rowNumber <= rows / 2) {
            return 10;
        } else {
            return 8;
        }
    }

}

