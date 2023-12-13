/*
 * See java.lang.String on the Java Documentation website.
 *
 *   As you browse, you see several methods with the same name,
 *   e.g., 'substring'.  Compare their parameter lists.  Two methods
 *   with the same name but with different parameter lists are 
 *   considered two different functions as you should know by now.
 *   They are said to have different 'signatures' or 'prototypes'.
 *   Or, their function (method) names are said to be 'overloaded'.
 */

/* Problem Description:
 * 
 * This program converts a sentence into a Pig-Latin form.
 * Converting a sentence (string) to Pig-Latin could be done as follows:
 * 1. Consider one word at a time in the given sentence.
 * 2. If a word (string) begins with a vowel, add "way" to the end
 *    of the word.  For example, Pig-Latin for "apple" is "appleway".
 * 3. Otherwise, find the first occurrence of a vowel, move all
 *    the characters before the vowel to the end of the word,
 *    and add "ay" at the end.  For example, Pig-Latin for "strong" is
 *    "ongstray" since the characters "str" occur before the
 *    first vowel.
 * 4. If there is no vowel in the word, it returns the same.
 * 5. Assume that vowels are a, e, i, o, and u, only lower-case!
 */

/* Note that getting the right answer is important, but what is more
 * important is understanding the process that you will go through 
 * to get to the resulting program.
 *
 * 1. Understand the problem, acquiring domain knowledge - Pig-Latin
 *    in this case.
 * 2. Come up with a high level design.
 *    . Representing the sentence as a string
 *    . Being able to extract a word out of the sentence at a time
 *    . Being able to convert one word to Pig-Latin at a time
 *    . Being able to put converted words together
 *    . Then handle the result in the form asked for
 * 3. As you refine your design, understand what is already
 *    available to you and what gets put on the "wish" list.
 *    . Available: split, length, chatAt, indexOf, substring, +, etc.
 *                 from the java.lang.String class.
 *    . Wish list:
 *      - Finding the first vowel in a string (word)
 *      - Extracting one word at a time from a sentence of words
 *
 *    As you design your program (top-down in this case), you will end
 *    up with a program with holes (functions that have not yet been 
 *    implemented).  These holes will be completed bottom-up as described
 *    in the next step.
 * 4. Start implementing bottom-up doing unit-testing on the funtions
 *    (methods) that you implement.  By unit-testing I mean that you
 *    implement one function and write a piece of code to test the
 *    implementation considering various cases in which the function
 *    might be used.  As you proceed with implementation, you will end
 *    up implementing all those things in the "wish" list.
 *    For example, you can implement the function that finds the first
 *    vowel in a string.  By the time you implement this function, the
 *    signature of the funtion was already decided because during the
 *    top-down design, you already assumed a function that finds the
 *    first vowel existed with a specific signature.  At this point you
 *    are just implementing that function and furthermore test it to see
 *    if it actually works.  To test this function, you may want to write
 *    a few test calls in main rather than calling it from the other
 *    function in your top-down design that expects this function because
 *    the other function may not be complete enough to test this function
 *    yet.
 * 5. After you complete all the things in the wish list, do the overall
 *    testing with the complete implementation.
 */

/* I will give you a skeleton of the program and you will complete it.
 *
 * The purpose of this exercise is
 * (1) to learn how to use some functions dealing with strings,
 * (2) to learn how to handle complexity in designing a program, and
 * (3) to learn how to test your implementation.
 */

public class Pig {

    /* This is a test.  Remember incremental development?  Comment out
     * pigifyWord and pigifySentence and the calls to them initially and
     * make sure firstVowel works correctly first.  After that uncomment 
     * pigifyWord and the calls to it and make sure that works correctly
     * next.  Finally, uncomment pigifySentence and the calls to it and
     * test the whole thing.
     *
     * Try to add other test calls as well.
     */
    public static void main (String[] args) {
	System.out.println(firstVowel("this"));
	System.out.println(firstVowel("ftp"));
	System.out.println();

	System.out.println(pigifyWord("apple"));
	System.out.println(pigifyWord("strong"));
	System.out.println();

	System.out.println("Here is \n an \t example sentence with a newline character and a tab character in it");
	System.out.println();

	System.out.println(pigifySentence("It is sunny today."));
	System.out.println(pigifySentence("This is a sentence."));
	System.out.println(pigifySentence("Here is\nanother \t one"));
    }

    
    /* Purpose: Converts a sentence (a string containing words separated
     *          by white spaces) into Pig Latin.
     * Ex: pigifySentence("This is a sentence.")
     *          = isThay isway away entence.say
     *     pigifySentence("Here is\nanother \t one")
     *          = ereHay isway anotherway oneway
     * Note: \t is a tab character and \n is a newline character.
     *     You can use "[\t\n]" when you call the split function to
     *     use those characters as delimiters.
     */
    public static String pigifySentence (String sent) {
        // Hints: Learn how to use the split function defined in the String
        //        class.  Use pigifyWord below by putting it in
        //        your 'wish list'.

        // Complete this function.

        if (sent == null) return null;

        String returnSentence = "";
        String[] sents = sent.split("[ \t\n]+");
        for (String s : sents) {
            returnSentence += pigifyWord(s) + " ";
        }
        if (returnSentence.length() > 0) returnSentence = returnSentence.substring(0, returnSentence.length() - 1);
        return returnSentence;
    }


    /* Purpose: Converts a word into Pig Latin.
     * Ex: pigifyWord("apple") = "appleway"
     *     pigifyWord("strong") = "ongstray"
     */
    public static String pigifyWord (String word) {
        // Hints: Learn how to use the substring functions in the String
        //        class.  There are two versions of substring in that class.
        //        You will find both of them useful here.
        //        Use firstVowel below by putting it in your 'wish list'.

        // Complete this function.

        if (word == null) return null;

        int firstVowel = firstVowel(word);
        if (firstVowel == -1) {
            return word;
        } else if (firstVowel == 0) {
            return word + "way";
        } else {
            return word.substring(firstVowel) + word.substring(0, firstVowel) + "ay";
        }
    }


    /* Purpose: Returns the index of the first vowel in word,
     *          or -1 if there is no vowel.
     * Ex: firstVowel("apple") = 0
     *     firstVowel("computer") = 1
     *     firstVowel("ftp") = -1
     */
    public static int firstVowel (String word) {
        // Hints: Learn how to use indexOf and charAt functions in the
        //        String class.

        // Complete this function.

        if (word == null) return -1;

        char[] vowelArr = {'a', 'e', 'i', 'o', 'u'};

        int vowelIndex = -1;
        for (char v : vowelArr) {
            vowelIndex = word.indexOf(v);
            if (vowelIndex > -1) {
                break;
            }
        }
        return vowelIndex;
    }

}
