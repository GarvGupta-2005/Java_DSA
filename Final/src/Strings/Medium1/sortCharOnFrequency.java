package Strings.Medium1;

public class sortCharOnFrequency {
    // //This is the brute force approach where we build an char array to store each element and then store their value and frequency and then we xompare them on the basid of theri frequenct and then add them to our reultant string
    public static int[] toCharArray(String S) {
        int[] result = new int[256]; // Array to store frequencies for all ASCII characters
        for (int i = 0; i < S.length(); i++) {
            result[S.charAt(i)]++; // Increment the frequency of the current character
        }
        return result;
    }

    public static String frequencySort(String s) {
        int[] charArray = toCharArray(s); // Step 1: Count character frequencies
        StringBuilder result = new StringBuilder();

        // Step 2: Create an array of pairs (frequency, character)
        int[][] frequencyArray = new int[256][2];
        for (int i = 0; i < 256; i++) {
            frequencyArray[i][0] = charArray[i]; // Frequency
            frequencyArray[i][1] = i;           // ASCII value of character
        }

        // Step 3: Sort the frequency array based on frequency in descending order
        java.util.Arrays.sort(frequencyArray, (a, b) -> b[0] - a[0]);

        // Step 4: Build the result string
        for (int i = 0; i < 256; i++) {
            int freq = frequencyArray[i][0];
            char c = (char) frequencyArray[i][1];
            while (freq > 0) {
                result.append(c);
                freq--;
            }
        }

        return result.toString();
    }
}
