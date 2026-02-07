class Solution {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap();
        for(int i=0; i< nums.length; i++) {
            int complement = target - nums[i];

            if(map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }
}


// Map<Integer, Integer> complements = new HashMap();
        // for(int i=0; i< nums.length; i++) {
        //     Integer complementIndex = complements.get(nums[i]);
        //     if(complementIndex != null) {
        //         return new int[]{i, complementIndex};
        //     }
        //     complements.put(target - nums[i], i);
        // }
        // return nums;