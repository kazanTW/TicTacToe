public class Plate {
    private final Character[] plate;

    public Plate() {
        this.plate = new Character[9];
        for (int i = 0; i < 9; i++) {
            plate[i] = ' ';
        }
    }

    public void printPlate() {
        System.out.println(" " + plate[0].toString() + " | " + plate[1].toString() + " | " + plate[2].toString());
        System.out.println("-----------");
        System.out.println(" " + plate[3].toString() + " | " + plate[4].toString() + " | " + plate[5].toString());
        System.out.println("-----------");
        System.out.println(" " + plate[6].toString() + " | " + plate[7].toString() + " | " + plate[8].toString());
        System.out.println();
    }

    public boolean isFull() {
        int flag = 1;
        for (char position : plate) {
            if (position == ' ') {
                flag = 0;
                break;
            }
        }
        return (flag == 1);
    }

    public int checkPlate() {
        int result = 0;
        if (((plate[0] == plate[1]) && (plate[0] == plate[2])) || ((plate[0] == plate[3]) && (plate[0] == plate[6])) || ((plate[0] == plate[4]) && (plate[0] == plate[8]))) {
              if (plate[0] == 'O') result = 1;
              else if (plate[0] == 'X') result = -1;
        } else if ((plate[1] == plate[4]) && (plate[1]) == plate[7]) {
              if (plate[1] == 'O') result = 1;
              else if (plate[1] == 'X') result = -1;
        } else if (((plate[2] == plate[5]) && (plate[2]) == plate[8]) || ((plate[2] == plate[4]) && (plate[2] == plate[6]))) {
              if (plate[2] == 'O') result = 1;
              else if (plate[2] == 'X') result = -1;
        } else if ((plate[3] == plate[4]) && (plate[3] == plate[5])) {
              if (plate[3] == 'O') result = 1;
              else if (plate[3] == 'X') result = -1;
        } else if ((plate[6] == plate[7]) && (plate[6] == plate[8])) {
            if (plate[6] == 'O') result = 1;
            else if (plate[6] == 'X') result = -1;
        }
        return result;
    }

    public void setPlate(char player, int position) {
        if (!isFull()) {
            plate[position] = player;
            System.out.println();
            printPlate();

        } else {
            switch (checkPlate()) {
                case 0 -> System.out.println("Draw.\nGame over.");
                case 1 -> System.out.println("O wins!\nGame over.");
                case -1 -> System.out.println("X wins!\nGame over.");
            }
        }
    }
}
