package Homework7_1_29_2024;

import java.util.ArrayList;

public class TestResults {
    private ArrayList<StudentAnswerSheet> sheets;

    public TestResults(ArrayList<StudentAnswerSheet> sheets) {
        this.sheets = sheets;
    }

    /**
     * Returns the name of the student with the highest score.
     * 
     * @param key the ArrayList of correct answers
     * @return the name of the student with the highest score
     */
    public String highestScoringStudent(ArrayList<String> key) {
        double maxCorrect = 0;
        String name = "";
        for (StudentAnswerSheet sheet : sheets) {
            double correct = sheet.getScore(key);
            if (correct > maxCorrect) {
                maxCorrect = correct;
                name = sheet.getName();
            }
        }
        return name;
    }
    
}
