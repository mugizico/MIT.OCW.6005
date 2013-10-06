package PS1;

import java.util.*;

public class AlphabetGenerator {

    /**
     * Given a numeric base, return a char[] that maps every digit that is
     * representable in that base to a lower-case char.
     *
     * This method will try to weight each character of the alphabet
     * proportional to their occurrence in words in a training set.
     *
     * This method should do the following to generate an alphabet: 
     * 1. Count the occurrence of each character a-z in trainingData. 
     * 2. Compute the probability of each character a-z by taking 
     *    (occurrence / total_num_characters). 
     * 3. The output generated in step (2) is a Probability Density Function of 
     *    the characters in the training set.  Convert this PDF into a 
     *    Cumulative Distribution Function for each character. 
     * 4. Multiply the CDF value of each character by the base we are
     *    converting into. 
     * 5. For each index 0 <= i < base, output[i] = (the first
     *    character whose CDF * base is > i)
     *
     * A concrete example: 
     * 0. Input = {"aaaaa..." (302 "a"s), 
     *             "bbbbb..." (500"b"s), 
     *             "ccccc..." (198 "c"s)},
     *             base = 93 
     * 1. Count    (a) = 302, Count(b) = 500, Count(c) = 193 
     * 2. Pr(a) = 302 / 1000 = .302, 
     *    Pr(b) = 500 / 1000 =.5, 
     *    Pr(c) = 198 / 1000 = .198 
     * 3. CDF(a) = .302, 
     *    CDF(b) = .802, 
     *    CDF(c) = 1
     * 4. CDF(a) * base = 28.086, 
     *    CDF(b) * base = 74.586, 
     *    CDF(c) * base = 93 
     * 5. Output = {"a", "a", ... (28 As, indexes 0-27),
     *              "b", "b", ... (47 Bs, indexes 28-74),
     *              "c", "c", ... (18 Cs, indexes 75-92)}
     *
     * The letters should occur in lexicographically ascending order in the
     * returned array. 
     *          - {"a", "b", "c", "c", "d"} is a valid output. 
     *          - {"b", "c", "c", "d", "a"} is not.
     *
     * If base >= 0, the returned array should have length equal to the size of
     * the base.
     *
     * If base < 0, return null.
     *
     * If a String of trainingData has any characters outside the range a-z,
     * ignore those characters and continue.
     *
     * @param base A numeric base to get an alphabet for.
     * @param trainingData The training data from which to generate frequency
     * counts. This array is not mutated.
     * @return A char[] that maps every digit of the base to a char that the
     * digit should be translated into.
     */
    public static char[] generateFrequencyAlphabet(int base, String[] trainingData) {
      char[] generatedAlphabet = null;
        int totalCount = 0;
        Map<Character, Integer> count = new TreeMap<Character, Integer>();
        Double[] PDF = null;
        Double[] CDF = null;
        
        if (base < 0) {
            return null;
        }
        
        if (base == 0){
            char[] emptyAlphabet = {};
            return emptyAlphabet;
        }

        // Break training data into words
        for (String words : trainingData) {

            //Break into letters/characters
            char[] letters = words.toCharArray();

            for (char letter : letters) {

                // Insert some handling for is character, and all lower case?
                // letter.isCharacter?
                // charcter.toLowerCase();   

                Integer frequency = count.get(letter);
                count.put(letter, (frequency == null) ? 1 : frequency + 1);
                totalCount++;
            }

        }

        
        

        // Calculate PDF using an array
        PDF = new Double[count.size()];
        int i = 0;

        Iterator<Integer> itr = count.values().iterator();
        while (itr.hasNext()) {     
            PDF[i] = itr.next() / (double) totalCount;
            i++;
        }
        
        // Convert PDF to CDF
        // set prior = 0
        // Loop through the array of PDF:
        //   CDF[i] = prior + PDF[i]
        //   prior = CDF[i]
        double prior = 0.00;
        CDF = new Double[count.size()];
        
        for (int j = 0 ; j <PDF.length; j++){
            CDF[j] = prior + PDF[j];
            prior = CDF[j];
        }
        
        
//         // Display all the PDF+CDF's
//        for (Double PDFValues : PDF){
//            System.out.println("PDF: " + PDFValues);
//        }
//        
//        for (Double CDFValues : CDF){
//            System.out.println("CDF: " + CDFValues);
//        }
//        
        
        
        // Generate the alphabet
        //get keys from Map (they are the letters)
        Character[] runes = count.keySet().toArray(new Character[0]);
        
        // Size the output appropriately
        generatedAlphabet = new char[base];
        
        // Multiply the CDF Value * base and create the alphabet
  
        // for all the letters output
        int prevLimit = 0;
        for (int k = 0; k < count.size() ; k++){
            
            
            // calcuate how many of each letter to create
            // as the array stop value (minus 1 for 0 based counting)
           
            double limit = (CDF[k] * base) -1;
            
           // System.out.println("prev-limit " + prevLimit );
           // System.out.println("limit " + limit );
            
            // creates the characters
            for (int m = prevLimit; m <= limit; m++){
             //  System.out.println(runes[k]);     
               
               generatedAlphabet[m] = runes[k]; 
            
            }
            
            prevLimit = (int) limit +1;
            
        }
        
        
        

        return generatedAlphabet;
    }
}