import java.util.Scanner;

public class NumberGame {
    int randomNum;
    NumberGame()
    {
        randomNum=(int)(Math.random()*(101));
//        System.out.println(randomNum);
    }
    int guess(int num)
    {
        return num-randomNum;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int finals = 0;
        boolean playGame=true;
        int roundsplayed=0;

        System.out.println("----------------Welcome to the world of of Guessing the Number-----------");
        System.out.println("---------So, the Rules of the game is:-------");
        System.out.println("1.You have only 10 chances to win the Game");
        System.out.println("2.The number is between 0-100");

        while(playGame) {
            int chances = 10;
            roundsplayed++;
            NumberGame game = new NumberGame();
            boolean won=false;
            for (int i = 0; i < chances; i++) {
                System.out.println("Enter your guess");
                int guess = sc.nextInt();
                int result = game.guess(guess);
                if (result == 0) {
                    System.out.println("Congrats!...You Won the Game");
                    won=true;
                    finals+=(chances-i);
                    break;
                } else if (result > 0) {
                    System.out.println("Your Guess is Too High...Please Guess Low");

                } else {
                    System.out.println("Your Guess is Too Low...Please Guess High");

                }
                System.out.println("Chances left:" + (chances - i - 1));
                if (i == chances - 1 && !won) {
                    System.out.println("Game over! You've used all your chances.");
                    System.out.println("The correct number was: " + game.randomNum);
                }

            }
            System.out.println("do you want to play again? (yes/no)");
            String response= sc.next();
            playGame=response.equalsIgnoreCase("yes");
        }
        System.out.println("Game Over!");
        System.out.println("Total Rounds Played: " + roundsplayed);
        System.out.println("Your Final Score: " + finals);
    }

}
