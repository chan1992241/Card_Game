import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        CardGame cardGame = new CardGame();
        boolean play = true;
        Scanner input = new Scanner(System.in);
        while (play){
            System.out.println("Card Game \n Player Options");
            System.out.println("1. Start Game \n  \n2. Exit Game");
            System.out.print("Please provide your option : ");
            while (!input.hasNextInt()) {
                input.next(); // What happens if you use nextLine() instead?
            }
            int resp = input.nextInt(); // if there is another number  
            if (resp == 1){
                System.out.println("Provide the Number of Players( should be greater than 1 and less than 4) : ");
                int numberOfPlayer = input.nextInt();
                while (numberOfPlayer < 2 || numberOfPlayer > 4){
                    System.out.println("Number of player should be between 4 and 2");
                    numberOfPlayer = input.nextInt();
                }
                cardGame.playGame(numberOfPlayer);
                cardGame.displayWinner(); 
            }else if (resp == 2){
                play = false;
                break;
            }else{
                System.out.println("Wrong command, should be 1 or 2");
            }
        }
        input.close();
    }
}
