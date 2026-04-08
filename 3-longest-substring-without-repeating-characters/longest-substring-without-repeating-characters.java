class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        //Approach 01
        int n = s.length();
        int maxLength = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int left = 0, right = 0; right < n; right++) {
            char curr = s.charAt(right);
            if(map.containsKey(curr)) {
                left = Math.max(map.get(curr)+1, left);
            }
            // Update the last seen index of the character
            map.put(curr, right);

            // Calculate current window size and update max
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;


        //Approach 02
        /** int max = 0;
        int i = 0;
        int j = 0;

        Set<Character> set = new HashSet<>();
        while(j < s.length()) {
            char c = s.charAt(j);
            
            while(set.contains(c)) {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(c);
            max = Math.max(max, j - i + 1);
            j++;
        }
        return max;*/
    }
}