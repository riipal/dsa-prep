class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int ns = s.length(), np = p.length();
        if (ns < np) return result;

        int[] pCount = new int[26];
        int[] sCount = new int[26];

        // Fill pCount and the first window of sCount
        for (int i = 0; i < np; i++) {
            pCount[p.charAt(i) - 'a']++;
            sCount[s.charAt(i) - 'a']++;
        }

        // Check the first window
        if (Arrays.equals(pCount, sCount)) {
            result.add(0);
        }

        // Slide the window
        for (int i = 0; i < ns - np; i++) {
            // Remove character at 'i' (left side of window)
            sCount[s.charAt(i) - 'a']--;
            // Add character at 'i + np' (right side of window)
            sCount[s.charAt(i + np) - 'a']++;

            // If the maps match, the start of this window (i + 1) is an anagram
            if (Arrays.equals(pCount, sCount)) {
                result.add(i + 1);
            }
        }

        return result;
    }
}