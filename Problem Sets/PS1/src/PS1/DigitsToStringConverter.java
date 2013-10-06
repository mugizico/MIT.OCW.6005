package PS1;

public class DigitsToStringConverter {

    /**
     * Given a list of digits, a base, and an mapping of digits of that base to
     * chars, convert the list of digits into a character string by applying the
     * mapping to each digit in the input.
     *
     * If digits[i] >= base or digits[i] < 0 
     * for any i, consider the input invalid, 
     *   and return null. 
     * 
     * If alphabet.length != base, consider the input invalid, 
     *   and return null.
     *
     * @param digits A list of digits to encode. This object is not mutated.
     * @param base The base the digits are encoded in.
     * @param alphabet The mapping of digits to chars. This object is not
     * mutated.
     * @return A String encoding the input digits with alphabet.
     */
    public static String convertDigitsToString(int[] digits, int base, char[] alphabet) {
    
        String ConvertedDigetsOutput = "";

        if (alphabet.length != base) {
            return null;
        }

        // loop through the random digits input, can be any length
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] < 0 || digits[i] >= base) {
                return null;
            } else {
                // for the current digit, look up it's index in alphabet, and return the output
                ConvertedDigetsOutput = ConvertedDigetsOutput + alphabet[digits[i]];
            }
        }

        return ConvertedDigetsOutput;
    }
}
