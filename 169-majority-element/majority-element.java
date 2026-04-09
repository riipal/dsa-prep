class Solution {
    public int majorityElement(int[] nums) {
        // Approach 01 
        // Time O(n)
        // Space O(n)
        Map<Integer, Integer> map = new HashMap<>();

        for(int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > nums.length / 2) {
                return num;
            }
        }
        return -1;


        // Approach 02
        // O(n)
        // O(1)
        
        /*
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
        */
    }
}