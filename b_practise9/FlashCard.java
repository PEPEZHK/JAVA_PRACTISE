public class FlashCard {
    private String question;
    private String answer;
    private int difficulty;

    public FlashCard(String question, String answer, int difficulty) {
        setQuestion(question);
        setAnswer(answer);
        setDifficulty(difficulty);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        if (difficulty >= 1 && difficulty <= 5) {
            this.difficulty = difficulty;
        } else {

        }
    }

    public void reverseCard() {
        String temp = answer;
        this.question = temp;
        this.answer = question;
    }

    public boolean equals(Object other) {
        if (other instanceof FlashCard) {
            FlashCard otheFlashCard = (FlashCard) other;
            return this.getQuestion().equals(otheFlashCard.question) & this.getAnswer().equals(otheFlashCard.answer);
        } else if (other instanceof String) {
            return this.getQuestion().equals(other);
        }
        return false;
    }

    public String toString() {
        return "" + question + "-" + answer + ":" + difficulty;
    }

    public void showFlashCardQuestion() {
        char c = '*';
        System.out.println("****************");
        System.out.println("*              *");
        System.out.println("*              *");
        System.out.println("*              *");
        System.out.printf("* %-7s %6c\n", question, c);
        System.out.println("*              *");
        System.out.println("*              *");
        System.out.println("*              *");
        System.out.println("****************");
    }

    public void showFlashCardAnswer() {
        char c = '*';
        System.out.println("****************");
        System.out.println("*              *");
        System.out.println("*              *");
        System.out.println("*              *");
        System.out.printf("* %-7s %6c\n", answer, c);
        System.out.println("*              *");
        System.out.println("*              *");
        System.out.println("*              *");
        System.out.println("****************");
    }
}
