class Solution {
    public int findDuplicate(int[] nums) {
        //Approach 01
        
        /*Set<Integer> set = new HashSet<>();
        for(int i=0; i<=nums.length - 1; i++) {
            if(set.contains(nums[i])) {
                return nums[i];
            }
            set.add(nums[i]);
        }
        return -1;*/

        //Approach 02
        int slow = 0;
        int fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

            if(slow == fast) {
                break;
            }
        } while(slow != fast);

        int n1=0;
        int n2= slow;

        while(n1 != n2) {
            n1 = nums[n1];
            n2 = nums[n2];
        }

        return n1;
        
    }
}