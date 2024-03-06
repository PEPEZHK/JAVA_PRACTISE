
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FlashCardApp {

    public static ArrayList<FlashCard> readCards(String filename) {

        String line;
        String[] data;

        // creates an empty list to store FlashCards
        ArrayList<FlashCard> cardList = new ArrayList<FlashCard>();

        // create a File object representing file to read
        File inFile = new File(filename);

        // try the following
        try {
            // create Scanner that reads from file with given name
            Scanner file = new Scanner(inFile);

            // while file contains more data
            while (file.hasNextLine()) {
                // read the next line from the file
                line = file.nextLine();

                // split the line into tokens (hint: String split() method )
                data = line.split("\\s+");
                // create a FlashCard object using the line tokens - don't forget convert
                // difficulty to int
                String question = data[0];
                String answer = data[1];
                int difficulty = Integer.parseInt(data[2]);
                FlashCard card = new FlashCard(question, answer, difficulty);
                // add the card to the list
                cardList.add(card);
            }
            // close the file
            file.close();
        } catch (FileNotFoundException f) {
            System.out.println("file cannot be opened");
        }
        // return the ArrayList containing FlashCards from the file
        return cardList;
    }

    public static void bubbleSort(ArrayList<FlashCard> cardList) {
        boolean sorted = false;
        for (int j = 0; j < cardList.size() - 1 && !sorted; j++) {
            sorted = true;
            for (int k = 0; k < cardList.size() - j - 1; k++) {
                if (cardList.get(k).getQuestion().compareToIgnoreCase(cardList.get(k + 1).getQuestion()) > 0) {
                    sorted = false;
                    FlashCard temp = new FlashCard(cardList.get(k).getQuestion(), cardList.get(k).getAnswer(),
                            cardList.get(k).getDifficulty());

                    cardList.set(k, cardList.get(k + 1));
                    cardList.set(k + 1, temp);
                }
            }
        }
    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.print("Enter the number of flash cards to generate: ");
        int n = in.nextInt();

        System.out.println("Let's play!!");

        ArrayList<FlashCard> flashCards = readCards("turkish_english_words.txt");
        ArrayList<String> repeat = new ArrayList<String>();

        Random ran = new Random();

        ArrayList<FlashCard> cards = new ArrayList<FlashCard>();
        while (cards.size() < n) {
            FlashCard card = flashCards.get(ran.nextInt(flashCards.size()));

            if (!cards.contains(card)) {
                cards.add(card);
            }
        }

        bubbleSort(flashCards);
        ArrayList<String> wrongAnswers = new ArrayList<String>();
        int score = 0;
        for (FlashCard card : cards) {
            Scanner input = new Scanner(System.in);
            String answer;
            card.showFlashCardQuestion();
            System.out.print("Enter your guess: ");
            answer = input.nextLine();
            if (answer.equals(card.getAnswer())) {
                score++;
                System.out.println("Correst!!");
            } else {
                System.out.println("Wrong answer!!\nLet us see the correct answer: ");
                card.showFlashCardAnswer();
                wrongAnswers.add(card.getQuestion() + "-" + card.getAnswer() + ":" + card.getDifficulty());
                repeat.add(card.getQuestion());
            }
        }
        System.out.println("Your score: " + score + "/" + n);
        System.out.println("Words you need to review: ");
        for (String line : wrongAnswers) {
            System.out.println(line);
        }

        System.out.print("Would yu like to repeat a particular flashcard(enter the question or enter no to exit): ");
        String input = in.nextLine();

        do {

            input = in.nextLine();

            Scanner inpt = new Scanner(System.in);
            String answer1;
            if (searchByQuestion(input, cards) != null && !input.equalsIgnoreCase("no")) {
                searchByQuestion(input, cards).showFlashCardQuestion();
                System.out.print("Enter your guess: ");
                answer1 = inpt.nextLine();

                if (answer1.equals(searchByQuestion(input, cards).getAnswer())) {

                    System.out.println("Correst!!");
                    System.out.print(
                            "Would yu like to repeat a particular flashcard(enter the question or enter no to exit): ");
                } else {
                    System.out.println("Wrong answer!!\nLet us see the correct answer: ");
                    searchByQuestion(input, cards).showFlashCardAnswer();
                    System.out.print(
                            "Would yu like to repeat a particular flashcard(enter the question or enter no to exit): ");
                }
            } else if (!input.equalsIgnoreCase("no") && searchByQuestion(input, cards) == null) {
                System.out.println("There is no such word");
                System.out.print(
                        "Would yu like to repeat a particular flashcard(enter the question or enter no to exit): ");
            }

        } while (!input.equalsIgnoreCase("no"));
        in.close();

    }

    public static FlashCard searchByQuestion(String toRepeat, ArrayList<FlashCard> cardList) {
        boolean found = false;
        for (int i = 0; i < cardList.size() && !found; i++) {
            if (cardList.get(i).getQuestion().equals(toRepeat)) {
                found = true;
                return cardList.get(i);
            }
        }
        return null;
    }

}
