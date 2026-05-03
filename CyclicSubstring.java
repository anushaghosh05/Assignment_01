import java.util.Scanner;

public class CyclicSubstring {
    public static void main(String[] args) {
        // Try-with-resources ensures the Scanner is closed properly
        try (Scanner sc = new Scanner(System.in)) {
            if (!sc.hasNext()) return;
            String s = sc.next();
            int n = s.length();
            
            // Logic: Concatenate string to itself to simulate circularity
            String doubled = s + s;
            int left = 0, maxSum = 0, currentSum = 0;
            int[] freq = new int[26];

            for (int right = 0; right < doubled.length(); right++) {
                int charIdx = doubled.charAt(right) - 'a';
                int charVal = charIdx + 1; // a=1, b=2...

                // Shrink window if duplicate found OR window length > original N
                while (freq[charIdx] > 0 || (right - left + 1) > n) {
                    int leftCharIdx = doubled.charAt(left) - 'a';
                    freq[leftCharIdx]--;
                    currentSum -= (leftCharIdx + 1);
                    left++;
                }

                freq[charIdx]++;
                currentSum += charVal;
                maxSum = Math.max(maxSum, currentSum);
            }
            System.out.println(maxSum);
        }
    }
}