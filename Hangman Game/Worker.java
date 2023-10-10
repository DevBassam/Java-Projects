import java.util.*;

public class Worker {
    private final Scanner input = new Scanner(System.in);
    private final Data data = new Data();
    private char playerChoice;
    private String theSecretWord = "";
    private String[] theSecretChars;
    private char playerGuess;
    private String guessedChars = "";

    protected void startTheGame(){
        // 1 - Show game Intro.
        greeting();

        do {
            // 2 - get player's choice and check if it's valid or not.
            playerChoice = getPlayerChoice();
            while (!isPlayerChoiceValid(playerChoice)){
                System.out.println("Enter 1, 2 or 3");
                playerChoice = getPlayerChoice();
            }

            // 3 - call the function depend on the player choice.
            switch (playerChoice){
                case '1' -> play();
                case '2' -> showDashboard();
                case '3' -> exit();
            }
        }while (!data.isExit);
    }

    private void greeting(){
        System.out.println();
        System.out.println("..... H A N G M A N .....");
        System.out.println("Hangman is a word-guessing game.");
        System.out.println("You can choose from 3 different levels");
        System.out.println("But, You have only 4 Attempts to get the word.");
    }

    private char getPlayerChoice(){
        System.out.println();
        System.out.println("Wanna..!?");
        System.out.println("\t 1- Play");
        System.out.println("\t 2- Show Dashboard");
        System.out.println("\t 3- Exit");
        System.out.print("Your choice: ");
        return input.next().charAt(0);
    }

    public boolean isPlayerChoiceValid(char choice){
        return Character.isDigit(choice) && Character.getNumericValue(choice) > 0 && Character.getNumericValue(choice) < 4;
    }

    private void play(){
        guessedChars = "";
        data.numberOfGames++;

        // - get player's choice and check if it's valid or not
        playerChoice = getPlayerLevel();
        while (!isPlayerChoiceValid(playerChoice)){
            System.out.println("Enter 1, 2 or 3");
            playerChoice = getPlayerLevel();
        }

        // - Pick the secret word randomly.
        pickTheSecretWord(playerChoice);
        //  - Adjust the progress variables.
        initializeProgress(theSecretWord);

        while (!isNoAttempts()) {
            // - Show the player progress so far.
            showProgress();

            // - Check if the word guessed or not.
            if (isWordGuessed()){
                winnerWinner();
                data.numberOfWinGames++;
                break;
            }

            // Player Input Validation.
            while (true){
                // - Take a guess from the player.
                getPlayerGuess();
                // - check if the input valid or not.
                if(!isPlayerInputValid(playerGuess)) continue;
                // - check if the input repeated or not.
                if (!isPlayerGuessNotRepeated(playerGuess)){
                    System.out.println("Repeated input..guess anther one.");
                    continue;
                }
                break;
            }
            guessedChars += playerGuess;

            // check Player Input Correction.
            if (isPlayerGuessCorrect(playerGuess)){
                System.out.println("...Correct Guess...");
                addGuessedCharToProgress(playerGuess);
            }
            else {
                data.numberOfAttempts--;
                System.out.println("...Wrong Guess...");
            }
        }
        if (isNoAttempts()) {
            loser();
            data.numberOfLoseGames++;
        }
    }

    private char getPlayerLevel(){
        System.out.println();
        System.out.println("Choose your game Level:");
        System.out.println("\t 1- Newbie");
        System.out.println("\t 2- Normal");
        System.out.println("\t 3- Expert");
        System.out.print("Your choice: ");
        return input.next().charAt(0);
    }

    private void pickTheSecretWord(char level){
        String [] words = new String[10];

        switch (level) {
            case '1' -> words = data.easyWords;
            case '2' -> words = data.mediumWords;
            case '3' -> words = data.hardWords;
        }
        theSecretWord =  words[(int) (Math.random() * 10)].toLowerCase();
    }

    private void initializeProgress(String secretWord){
        data.numberOfMissingChars = secretWord.length();
        theSecretChars = new String[secretWord.length()];
        Arrays.fill(theSecretChars, "_");
    }

    private void showProgress(){
        System.out.println("\t-Attempts: "+data.numberOfAttempts);
        System.out.println("\t-Missing Characters: "+data.numberOfMissingChars);
        System.out.println("\t-The Secret Word: "+String.join(" ", theSecretChars));
    }

    private void getPlayerGuess(){
        System.out.print("Enter an English Character: ");
        playerGuess =  input.next().charAt(0);
    }

    private boolean isPlayerInputValid(char playerGuess){
        return Character.isLetter(playerGuess);
    }

    private boolean isPlayerGuessNotRepeated(char playerGuess){
        return !guessedChars.contains((playerGuess + "").toLowerCase());
    }

    private boolean isPlayerGuessCorrect(char playerGuess){
        return theSecretWord.contains((playerGuess + "").toLowerCase());
    }

    private void addGuessedCharToProgress(char playerGuess){
        for (int i = 0; i < theSecretWord.length(); i++){
            if (playerGuess == theSecretWord.charAt(i)){
                theSecretChars[i] = playerGuess + "";
                data.numberOfMissingChars --;
            }
        }
    }

    private boolean isNoAttempts(){
        return data.numberOfAttempts == 0;
    }

    private boolean isWordGuessed(){
        return String.join("",theSecretChars).equalsIgnoreCase(theSecretWord);
    }

    private void winnerWinner() {
        System.out.println();
        System.out.println("...... Congratulations ......");
        System.out.println("You guessed the secret word correctly");
        System.out.println("The Secret Word was: "+theSecretWord.toUpperCase());
    }

    private void loser(){
        System.out.println();
        System.out.println("...... G A M E  O V E R ......");
        System.out.println("Sorry you didn't guess the secret word");
        System.out.println("But, You can try again as many as you want.");
        System.out.println("Good luck.");
    }

    private void showDashboard(){
        System.out.println();
        System.out.println("... Player Statistics ...");
        System.out.println("\t - Games : "+data.numberOfGames);
        System.out.println("\t - Win Games : "+data.numberOfWinGames);
        System.out.println("\t - Lose Games : "+data.numberOfLoseGames);
        System.out.println();
    }

    private void exit(){
        data.isExit = true;
        System.out.println(" ");
        System.out.println("It's been a pleasure to play with you.");
        System.out.println("\t..... Thanks .....");
    }
}
