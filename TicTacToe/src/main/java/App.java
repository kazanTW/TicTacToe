import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        System.out.println("Tic Tac Toe [ver. 0.0.1-20221115]");
        System.out.println("2022 Kazan Studio.");
        System.out.println("---------------------------------");

        Plate plate = new Plate();
        Scanner scannerO = new Scanner(System.in);
        Scanner scannerX = new Scanner(System.in);
        int positionO, positionX;

        while (!plate.isFull()) {
            System.out.println("\nPlease choose a position(1 - 9): \n");
            plate.printPlate();

            if (plate.isFull()) {
                switch (plate.checkPlate()) {
                    case 0 -> System.out.println("Draw.\nGame over.");
                    case 1 -> System.out.println("O wins!\nGame over.");
                    case -1 -> System.out.println("X wins!\nGame over.");
                }
            } else {
                System.out.print("O-> ");
                positionO = scannerO.nextInt() - 1;
                if ((positionO <= 8) && (positionO >= 0)) plate.setPlate('O', positionO);
                else System.out.println("Position invalid. Please enter number between 1-9.");
            }

            if (plate.isFull()) {
                switch (plate.checkPlate()) {
                    case 0 -> System.out.println("Draw.\nGame over.");
                    case 1 -> System.out.println("O wins!\nGame over.");
                    case -1 -> System.out.println("X wins!\nGame over.");
                }
            } else {
                System.out.print("X-> ");
                positionX = scannerX.nextInt() - 1;
                if ((positionX <= 8) && (positionX >= 0)) plate.setPlate('X', positionX);
                else System.out.println("Position invalid. Please enter number between 1-9.");
            }
        }
    }
}