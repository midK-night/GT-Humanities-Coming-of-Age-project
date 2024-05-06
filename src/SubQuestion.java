import java.util.Scanner;

public class SubQuestion {
    private final String question;
    private final String identifier;
    private final String yes;
    private final String yesModifier;
    private final String yesText;
    private final String no;
    private final String noModifier;
    private final String noText;

    public SubQuestion(String[] question) {
        identifier = question[0];
        this.question = question[1];
        yesModifier = question[2];
        yes = question[3];
        yesText = question[4];
        noModifier = question[5];
        no = question[6];
        noText = question[7];
    }

    public boolean runQuestion() {
        Scanner console = new Scanner(System.in);
        System.out.printf(question);
        System.out.print("\nOption 1 or 2? (1/2): ");
        return console.nextInt() == 1;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getYes() {
        return yes;
    }

    public String getNo() {
        return no;
    }

    public String getYesModifier() {
        return yesModifier;
    }

    public String getNoModifier() {
        return noModifier;
    }

    public String getYesText() {
        return yesText;
    }

    public String getNoText() {
        return noText;
    }
}
