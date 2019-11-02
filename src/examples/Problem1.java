package examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * We're given a string with a bunch of names that we want to tidy up.
 * The goal of this program is to do the following:
 * - 1. Not everything in the string is a name and those need to be removed,
 *      to keep it simple we'll consider anything 1 character long, to be not a name.
 * - 2. None of the names are capitalized, they should be. ("dan" -> "Dan")
 * - 3. Comma separate the names to make it nicer to read.
 */
public class Problem1 {
    public static void main(String[] args) {
        // This is our string that we wish to clean up.
        String badNames = "dan % tom dave kelly 1 jim james bob nick z kyle max";

        // This is what our solution should return as an answer
        String answer = "Dan, Tom, Dave, Kelly, Jim, James, Bob, Nick, Kyle, Max";

        System.out.println(solve(badNames));
        System.out.println(solveFunctionally(badNames));
    }

    // Non-functional Java solution
    static String solve(String badNames) {
        // First split up our string into an array of words.
        String[] splitString = badNames.split(" ");

        // Need a variable to keep track of our current answer
        String result = "";

        // Loop through each word 1 by 1
        for (int i = 0; i < splitString.length; i++) {
            // Determine if the word is a name (it's greater than one character)
            if (splitString[i].length() > 1) {
                // Capitalize the word
                String capitalizedName = splitString[i].substring(0, 1).toUpperCase() + splitString[i].substring(1);
                // Add the comma separator
                result += capitalizedName + ", ";
            }
        }
        // Return our current result, minus the extra ", " at the end
        return result.substring(0, result.length() - ", ".length());
    }

    // Functional Java solution
    static String solveFunctionally(String badNames) {
        // Turn out string into a list of words.
        List<String> splitNames = Arrays.asList(badNames.split(" "));

        // Get the stream so that we can use Java's functional features
        return splitNames.stream()
                // Filter out everything that isn't a name
                .filter(s -> s.length() > 1)
                // Capitalize the first letter of everything left over
                .map(s -> s.substring(0, 1).toUpperCase() + s.substring(1))
                // Piece all the names back together what a ", " in between them.
                .collect(Collectors.joining(", "));
    }
}
