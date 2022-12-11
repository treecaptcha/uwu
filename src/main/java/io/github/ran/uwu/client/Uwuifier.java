package io.github.ran.uwu.client;

import java.util.Random;



/**
 * This class either contains the best code or the worst code ever written
 * @author Ran
 * https://github.com/Ran-helo/uwu
 */
public class Uwuifier {
    /**
     * This uwuifier makes no guarantee that every input has the same output.
     * Consider using uwuifySame to get the same output on each input.
     * @param stringToUwuify - the string to be uwuified
     * @return - the uwuified string
     */
    public static String uwuify(String stringToUwuify) {
        Random rand = new Random();
        return stringToUwuify.toLowerCase().replaceAll("[rl]","w").replaceAll("n([aeiou])", "ny$1").replaceAll("ove", "uve").replaceAll("uck", "uwq").replaceFirst("i", "i-i").replaceFirst("(?s)(.*)" + "i-i-i", "$1" + "i-i") + ((rand.nextInt(10)) <= 2 ? " >-<" : "") + ((rand.nextInt(10)) <= 1 ? " uwu" : "");
    }


    public static String uwuifyName(String stringToUwuify) {
        return stringToUwuify.toLowerCase().replaceAll("[rl]","w").replaceAll("n([aeiou])", "ny$1").replaceAll("ove", "uve").replaceAll("uck", "uwq").replaceFirst("i", "i-i").replaceFirst("(?s)(.*)" + "i-i-i", "$1" + "i-i");
    }

    private static long stringToSeed(String stringToSeed) {
        long seed = 0;
        for(int i = 0; i < stringToSeed.length(); i++) {
            seed = (seed * 31) + stringToSeed.charAt(i);
        }
        return seed;
    }
}
