import java.util.Scanner;

public class TicTacToe {
    // Print Method
    static void printtile(String[] til) {
        for (int i = 0; i < 9; i++) {
            System.out.print(" " + til[i]);
            if (i != 2 && i != 5 && i != 8) {
                System.out.print(" |");
            }
            if ((i + 1) % 3 == 0) {
                System.out.println();
                if (i < 7)
                    System.out.println("-----------");
            }
        }
    }

    // Check Tiles for Winner
    static int chkwin(String[] t) {
        if (t[0] == "O" && t[1] == "O" && t[2] == "O" || t[3] == "O" && t[4] == "O" && t[5] == "O"
                || t[6] == "O" && t[7] == "O" && t[8] == "O" || t[0] == "O" && t[3] == "O" && t[6] == "O"
                || t[1] == "O" && t[4] == "O" && t[7] == "O" || t[2] == "O" && t[5] == "O" && t[8] == "O"
                || t[0] == "O" && t[4] == "O" && t[8] == "O" || t[6] == "O" && t[4] == "O" && t[2] == "O") {
            return 0;
        } else if (t[0] == "X" && t[1] == "X" && t[2] == "X" || t[3] == "X" && t[4] == "X" && t[5] == "X"
                || t[6] == "X" && t[7] == "X" && t[8] == "X" || t[0] == "X" && t[3] == "X" && t[6] == "X"
                || t[1] == "X" && t[4] == "X" && t[7] == "X" || t[2] == "X" && t[5] == "X" && t[8] == "X"
                || t[0] == "X" && t[4] == "X" && t[8] == "X" || t[6] == "X" && t[4] == "X" && t[2] == "X") {
            return 1;
        } else {
            return 2;
        }
    }

    // Main Method
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int i = 0;
            int tileno;
            String[] tile = { "1", "2", "3", "4", "5", "6", "7", "8", "9" };
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            printtile(tile);
            while (i < 9) {
                if (i % 2 != 0) {
                    new ProcessBuilder("cmd", "/c", "color 0C").inheritIO().start().waitFor();
                    System.out.print("X's Turn\nEnter tile number(1-9): ");
                    tileno = sc.nextInt();
                    if (tileno <= 9 && tile[tileno - 1] != "X" && tile[tileno - 1] != "O") {
                        tile[tileno - 1] = "X";
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        printtile(tile);
                        if (chkwin(tile) == 1) {
                            System.out.println("X won!");
                            return;
                        } else if (i == 8) {
                            System.out.println("Draw");
                        }
                        i++;
                    } else {
                        System.out.println("Enter a valid tile number!");
                    }
                } else {
                    new ProcessBuilder("cmd", "/c", "color 09").inheritIO().start().waitFor();
                    System.out.print("O's Turn\nEnter tile number(1-9): ");
                    tileno = sc.nextInt();
                    if (tileno <= 9 && tile[tileno - 1] != "O" && tile[tileno - 1] != "X") {
                        tile[tileno - 1] = "O";
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                        printtile(tile);
                        if (chkwin(tile) == 0) {
                            System.out.println("O won!");
                            return;
                        } else if (i == 8) {
                            System.out.println("Draw");
                        }
                        i++;
                    } else {
                        System.out.println("Enter a valid tile number!");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
