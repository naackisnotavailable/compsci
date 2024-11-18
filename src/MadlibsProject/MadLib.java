package MadlibsProject;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MadLib {
    public static void main(String[] args) {
        MadLibFileReader mlr = new MadLibFileReader();
        String template = mlr.getMadLibTemplate();
        Scanner input = new Scanner(System.in);
        String replace = "";

        System.out.println("hola, welcome to madlibs");
        String[] parts = getPlaceHolders(template);
        String[] responses = getReplacements(parts);
        System.out.println(addReplacements(template, parts, responses));

    }

    /**
     * Returns the number of placeholders in the given string.
     *
     * @param str the string to count placeholders in
     * @return the number of placeholders in the string
     */
    public static int getPlaceHolderCount(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (char x : chars) {
            if (x == '[') {
                count += 1;
            }
        }
        return count;
    }

    /**
     * Retrieves the placeholders from the given string.
     *
     * @param str the string containing placeholders
     * @return an array of strings representing the placeholders
     */
    public static String[] getPlaceHolders(String str) {
        String[] split1 = str.split("\\[");
        String[] result = new String[getPlaceHolderCount(str)];
        for (int i = 0; i < getPlaceHolderCount(str); i++) {
            String x = split1[i + 1];
            String[] split2 = x.split("]");
            result[i] = split2[0];
        }
        return result;

    }

    /**
     * Takes an array of prompts and prompts the user to enter corresponding values.
     * If the prompt starts with a vowel, it asks for an "an" value, otherwise it asks for an "a" value.
     * Returns an array of user responses.
     *
     * @param prompts the array of prompts to display to the user
     * @return an array of user responses
     */
    public static String[] getReplacements(String[] prompts) {
        Scanner scanner = new Scanner(System.in);
        String[] response = new String[prompts.length];
        for (int i = 0; i < prompts.length; i++) {
            String p = prompts[i];
            if (p.startsWith("A") || p.startsWith("E") || p.startsWith("I") || p.startsWith("O") || p.startsWith("U")) {
                System.out.println("Enter an " + p + ": ");
            } else {
                System.out.println("Enter a " + p + ": ");
            }
            response[i] = scanner.nextLine();
        }
        return response;
    }

    /**
     * Replaces the placeholders in the given template string with the corresponding replacements.
     * 
     * @param template      the string containing placeholders to be replaced
     * @param placeholders  an array of strings representing the placeholders
     * @param replacements  an array of strings representing the replacements for the placeholders
     * @return              the modified template string with placeholders replaced by their respective replacements
     */
    public static String addReplacements(String template, String[] placeholders, String[] replacements) {
        for (int i = 0; i < placeholders.length; i++) {
            template = template.replaceFirst("\\[" + placeholders[i] + "\\]", replacements[i]);
        }

        return capitalizeSentences(template);

    }

    /**
     * Capitalizes the sentences in the given input string.
     *
     * @param input the string to capitalize sentences in
     * @return the input string with capitalized sentences
     */
    public static String capitalizeSentences(String input) {
        StringBuilder result = new StringBuilder();
        Pattern pattern = Pattern.compile("(^|[.!?]\\s*)([a-z])"); //really confusing regex, checks for start or after sentence ending punctuation + space, then grabs letter
        Matcher matcher = pattern.matcher(input);

        while(matcher.find()){
            matcher.appendReplacement(result, matcher.group().toUpperCase());
        }
        matcher.appendTail(result);
        return result.toString();
    }
}