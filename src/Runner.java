import java.util.*;
public class Runner {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("What difficulty would you like to play? (easy mode - 1/hard mode - 2) >>> ");
        int dif = console.nextInt();
        Player p = new Player(dif);
        System.out.println("Current social skills is " + p.getSkills());
        System.out.println();
        p.play(new QuestionBank(p), new SubQuestionBank(p));


    }
}