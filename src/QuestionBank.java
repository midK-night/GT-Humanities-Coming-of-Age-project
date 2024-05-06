import java.io.*;
import java.util.*;

public class QuestionBank {
    private final ArrayList<Question> questions;

    public QuestionBank(Player p) {
        questions = new ArrayList<>();
        try {
            String fileName = "src/question";
            if (p.getDifficulty() == 1) {
                fileName += "1";
            } else {
                fileName += "2";
            }
            fileName += ".txt";
            Scanner fileReader = new Scanner(new File(fileName));
            String[] lineValues;
            String line;
            while (fileReader.hasNextLine()) {
                line = fileReader.nextLine();
                lineValues = line.split("_");
                questions.add(new Question(lineValues));
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Answer runQuestion(int n) {
        Question main = questions.get(n);
        boolean yes = main.runQuestion();
        String mod, result, text;
        if (yes) {
            mod = main.getYesModifier();
            result = main.getYes();
            text = main.getYesText();
        } else {
            mod = main.getNoModifier();
            result = main.getNo();
            text = main.getNoText();
        }
        return new Answer(mod, result, text);
    }

    public int getQuestionAmount() {
        return questions.size();
    }
}
