class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] response = new int[nums.length];
        int left = 0;
        int right = nums.length - 1;
        int position = nums.length - 1;

        while(left <= right) {
            if(Math.abs(nums[left]) > Math.abs(nums[right])) {
                response[position] = nums[left] * nums[left];
                left++;
            } else {
                response[position] = nums[right] * nums[right];
                right--;
            }
            position--;
        }
        return response;
    }
}