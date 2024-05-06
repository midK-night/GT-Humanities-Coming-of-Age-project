import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class SubQuestionBank {
    private final ArrayList<SubQuestion> questions;

    public SubQuestionBank(Player p) {
        questions = new ArrayList<>();
        try {
            String fileName = "src/subquestion";
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
                questions.add(new SubQuestion(lineValues));
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Answer runQuestion(int n) {
        SubQuestion main = questions.get(n);
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

    public int getQuestion (String id) {
        int ans = -1;
        for (int i = 0; i < questions.size(); i++) {
            if (questions.get(i).getIdentifier().equalsIgnoreCase(id)) {
                ans = i;
            }
        }
        return ans;
    }
}
