package Model;

public class Game {
    private Player player;
    private Dice dice;

    public Game() {
        this.player = new Player();
        this.dice = new Dice();
    }
    public void start() {
        System.out.println("Welcome to the dice game!");
        while (player.continuePlaying()){
            int roll = dice.roll();
            int spaces = getSpaces(roll);
            System.out.println("You got a " + roll);
            if (roll == 6 && player.getPosition() < 4) {
                System.out.println("You can't move back any further");
                spaces = -player.getPosition();
            }
            player.move(spaces);
            System.out.println("Your new position is: " + player.getPosition());
            if(player.getPosition() == 7){
                System.out.println("Congratulations you have won!");
                break;
            }

        }
    }

    private int getSpaces(int roll) {
        switch (roll) {
            case 1:
                return 3;
            case 3:
                return 2;
            case 6:
                return -4;
            default:
                return roll;
        }
    }
}
