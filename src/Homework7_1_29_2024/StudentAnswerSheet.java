package Homework7_1_29_2024;

import java.util.ArrayList;

public class StudentAnswerSheet {
    private ArrayList<String> answers;
    private String name;

    public StudentAnswerSheet(ArrayList<String> answers, String name) {
        this.answers = answers;
        this.name = name;
    }

    /**
     * Calculates the score of the student's answer sheet based on the provided key.
     * Each correct answer adds 1 point to the score, while each incorrect answer deducts 0.25 points.
     * 
     * @param key The answer key to compare the student's answers against.
     * @return The score of the student's answer sheet.
     */
    public double getScore(ArrayList<String> key) {
        double score = 0;
        for (int i = 0; i < key.size(); i++) {
            if(key.get(i) != "?"){
                System.out.println("ok");
            if (answers.get(i).equals(key.get(i))) {
                score++;
            } else if (!answers.get(i).equals("?")) {
                score -= 0.25;
            }
        }
    }
        return score;
    }

    public String getName() {
        return name;
    }
}
