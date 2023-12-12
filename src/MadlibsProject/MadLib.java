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

    public static String addReplacements(String template, String[] placeholders, String[] replacements) {
        for (int i = 0; i < placeholders.length; i++) {
            template = template.replaceFirst("\\[" + placeholders[i] + "\\]", replacements[i]);
        }

        return capitalizeSentences(template);

    }

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