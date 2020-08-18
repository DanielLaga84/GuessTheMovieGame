
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {

        new Game();
        System.out.println("THANKS FOR PLAYING, HOPE IT WAS FUN!");
        System.out.println("IF YOU WANT TO PLAY AGAIN PRESS ENTER: ");
        System.out.println("TYPE quit to exit.");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String continuePlay = null;

        try {
            continuePlay = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // continue if press enter
        assert continuePlay != null;
        if (continuePlay.length() == 0) {
            new Game();
        }

        // made quit command after game
        String input = null;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Type QUIT to exit: ");
        input = keyboard.nextLine();
        if (input.equals("quit")) {
        //close the program
        }
        Reverser(input, (input.length() - 1));
       System.exit(0);
    }
        public static void Reverser(String str, int size) {
        if (size >= 0) {
        Reverser(str, size - 1);
        }
}
}
