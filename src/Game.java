import java.util.Scanner;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Game {
    private ArrayList<String> list;
    private Scanner scanner;
    private String randomFilm;
    private String tryToGuess;
    private int guess = 11;
    private static char userTurn;
    private StringBuilder result;
    private ArrayList<Character> LetterArray = new ArrayList<>();

    //File scanner and check what is on the list. Wanted to do it with java.Random but somehow it did not print results.
    Game() {
        try {
            File file = new File("src/movies.txt");
            scanner = new Scanner(file);
            list = new ArrayList<>();
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            } // Made catch with exeption
        } catch (FileNotFoundException exception) {
            System.out.println("There is mo such a file, check THIS!");
        }
        int randomIndex = (int) (Math.random() * list.size());
        randomFilm = list.get(randomIndex).toUpperCase();

        tryToGuess = randomFilm.replaceAll("[a-zA-Z]", "*").trim();
        System.out.println(randomFilm);
        System.out.println(tryToGuess);

        Winner();
    }
    //Searching for Winner
    private void Winner(){
        while (!HasWon(tryToGuess) && guess > 1) {
            guess--;
            System.out.println("Type one letter : ");
            System.out.println("You have " + guess + " guesses left: ");

            scanner = new Scanner(System.in);
            userTurn = scanner.next().toUpperCase().charAt(0);

            if (checkIfWon(userTurn)) {
                result = new StringBuilder(tryToGuess);

                //check if the ArrayList contains user input already,
                //so does not add to the userTurn.
                if (LetterArray.contains(userTurn)) {
                    System.out.println("YOU ALREADY GUESSED THIS LETTER!");
                } else {
                    //add all the user input to an ArrayList.
                    LetterArray.add(userTurn);
                }

                for (int j = 0; j < randomFilm.length(); j++) {

                    //checking if letter in the film at 'j' position and if it is equals.
                    if (randomFilm.charAt(j) == userTurn) {

                        //set the input to the particular index in tryToGuess.
                        result.setCharAt(j, userTurn);
                        tryToGuess = result.toString();
                    }
                }
                if (userTurn >= '0' && userTurn <= '9') {
                    System.out.println("THIS IS DIGIT");
                }
                if (HasWon(tryToGuess))
                    System.out.println("Congratulations, you won! " + "The movie is: " + randomFilm);
                else if (guess == 1)
                    System.out.println("You loose, " + "the movie was: " + randomFilm);
                else
                    System.out.println("You are guessing: " + tryToGuess);

            } else {
                System.out.println("The movie does not contain : " + userTurn);
            }
        }
    }


    // userTurn check the character that user entered;


    private boolean checkIfWon(char userTurn) {
        return randomFilm.indexOf(userTurn) > -1;
    }

     //  tryToGuess check the string that user guessing and if there is no *. Win condition is no * in guessing time.

    private boolean HasWon(String tryToGuess) {
        return !tryToGuess.contains("*");


    }
    }

