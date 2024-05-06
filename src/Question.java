import java.util.Scanner;

public class Question {
    private final String question;
    private final String yes;
    private final String yesText;
    private final String yesModifier;
    private final String no;
    private final String noText;
    private final String noModifier;

    public Question (String[] question) {
        this.question = question[0];
        yes = question[2];
        yesModifier = question[1];
        no = question[5];
        noModifier = question[4];
        yesText = question[3];
        noText = question[6];
    }

    public boolean runQuestion() {
        Scanner console = new Scanner(System.in);
        System.out.printf(question);
        System.out.print("\nOption 1 or 2? (1/2): ");
        return console.nextInt() == 1;
    }

    public String getYes() {
        return yes;
    }

    public String getNo() {
        return no;
    }

    public String getYesText() {
        return yesText;
    }

    public String getNoText() {
        return noText;
    }

    public String getYesModifier() {
        return yesModifier;
    }

    public String getNoModifier() {
        return noModifier;
    }
}
