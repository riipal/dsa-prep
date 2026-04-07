class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxWindow = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            // 1. Update frequency of the character entering the window
            int currCharIdx = s.charAt(right) - 'A';
            freq[currCharIdx]++;

            // 2. Update max frequency found in the current window
            maxFreq = Math.max(maxFreq, freq[currCharIdx]);

            // 3. If (window size - max frequency) > k, the window is invalid
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // 4. Update the result
            maxWindow = Math.max(maxWindow, right - left + 1);
        }
        return maxWindow;
    }
}