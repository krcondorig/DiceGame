package Model;

import java.util.Scanner;


public class Player {
    private int position;

    public Player() {
        this.position = 0;
    }

    public void move(int spaces) {
        int newPosition = this.position + spaces;
        if (newPosition > 7) {
            newPosition = this.position - (newPosition - 7);
            System.out.println("The sum of your current position and the spaces to move forward exceeds 7. You will move back " + (this.position - newPosition) + " spaces.");
        } else if (newPosition < 0) {
            newPosition = 0;
        }
        int movedSpaces = newPosition - this.position;
        this.position = newPosition;
        System.out.println("You have moved " + movedSpaces + " spaces");
    }

    public boolean continuePlaying() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Would you like to keep playing?");
        System.out.println("1. Continue");
        System.out.println("2. Finish");
        try {
            int answer = scanner.nextInt();
            switch (answer) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.out.println("Invalid option, select 1 or 2");
                    return continuePlaying();
            }

        } catch (Exception e) {
            System.out.println("Invalid option, select 1 or 2");
            scanner.nextLine();
            return continuePlaying();
        }



    }

    public int getPosition() {
        return this.position;
    }
}
