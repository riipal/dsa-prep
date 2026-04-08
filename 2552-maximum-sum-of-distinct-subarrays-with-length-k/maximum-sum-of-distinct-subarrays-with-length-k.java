class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        //Approach 02
        long sum = 0;
        long max = 0;
        int duplicate = 0;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < k; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], 0);
            }
            map.put(nums[i], map.get(nums[i]) + 1);

            sum += nums[i];

            if(map.get(nums[i]) > 1) {
                duplicate++;
            }
        }

        if(duplicate == 0) {
            max = Math.max(max, sum);
        }

        for(int i = k; i < nums.length; i++) {
            int numToAdd = nums[i];
            int numToRemove = nums[i-k];

            if(!map.containsKey(numToAdd)) {
                map.put(numToAdd, 0);
            }
            map.put(numToAdd, map.get(numToAdd) + 1);

            if(map.get(numToAdd) > 1) {
                duplicate++;
            }

            sum += numToAdd;

            if(map.get(numToRemove) > 1) {
                duplicate--;
            }

            map.put(numToRemove, map.get(numToRemove) - 1);
            sum -= numToRemove;

            if(duplicate == 0) {
                max = Math.max(max, sum);
            }
        }
        return max;




        // Approach 01 - O(n2) 
        // int max = 0;
        // int currentSum = 0;

        // for(int i = 0; i <= nums.length - k; i++) {
        //     Set<Integer> set = new HashSet<>();
        //     boolean isDuplicate = false;
            
        //     currentSum = 0;
        //     for(int j = 0; j <= i + k - 1; j++ ) {
        //         if(set.contains(nums[j])) {
        //             isDuplicate = true;
        //             break;
        //         }
        //         set.add(nums[j]); 
        //         currentSum += nums[j];               
        //     }

        //     if(!isDuplicate) {
        //         max = Math.max(max, currentSum);
        //     }
        // }
        // return max;
    }
}