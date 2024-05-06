public class Player {
    static int socialSkills;
    static int difficulty;

    public Player(int d) {
        difficulty = d;
        if (d == 1) {
            socialSkills = 5;
        } else {
            socialSkills = 0;
        }
    }

    public void play(QuestionBank main, SubQuestionBank sub) {
        for (int i = 0; i < main.getQuestionAmount(); i++) {
            Answer ans = main.runQuestion(i);
            processQuestion(ans, sub);
        }

        if (socialSkills > 0) {
            System.out.println("You passed with a social skills level of " + socialSkills);
        } else {
            System.out.println("You failed with a social skills level of " + socialSkills);
        }
    }

    public void processQuestion(Answer ans, SubQuestionBank sub) {
        if (ans.getMod().equalsIgnoreCase("value")) {
            updateSkills(Integer.parseInt(ans.getValue()));
            System.out.printf(ans.getText());
            System.out.println();
            System.out.println("Current social skills level: " + socialSkills);
        } else {
            String identifier = ans.getValue();
            System.out.printf(ans.getText());
            System.out.println();
            int questionNum = sub.getQuestion(identifier);
            Answer temp = sub.runQuestion(questionNum);
            processQuestion(temp, sub);
        }
        System.out.println();
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getSkills() {
        return socialSkills;
    }

    public void updateSkills(int n) {
        socialSkills += n;
    }
}