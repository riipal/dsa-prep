class Solution {
    public boolean isAnagram(String s, String t) {
        s = s.toLowerCase();
        t = t.toLowerCase();

        s = s.replace(" ", "");
        t = t.replace(" ", "");

        //Initialize the bucket
        int[] counts = new int[26];

        //Fill bucket
        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
        }

        //Empty bucket
        for(int i = 0; i < t.length(); i++) {
            counts[t.charAt(i) - 'a']--;
        }

        //Check if bucket is empty
        for(int count : counts) {
            if(count != 0) {
                return false;
            }
        }

        return true;


    }
}