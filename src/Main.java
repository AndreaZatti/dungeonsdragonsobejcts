import java.util.Scanner;

/**
 * Created by sara on 07/06/2017.
 */
public class Main {

    public static void main(String[] args) {


        System.out.println("Hello. Do you want to play Dungeons and Dragons and Objects? (Y/N)");

        Scanner scan = new Scanner(System.in);
        String input = scan.next();

        if (input.equalsIgnoreCase("y")) {
            //Iniziamo a giocare
            Game game = new Game();
            game.startPlaying();

        } else if (input.equalsIgnoreCase("n")) {
            System.out.println("Oh no :(");
        }
    }
}
