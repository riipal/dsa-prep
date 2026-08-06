class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int pos = nums.length - 1;

        int[] result = new int[nums.length];
        
        while(left <= right) {
            int leftSqr = nums[left]*nums[left];
            int rightSqr = nums[right]*nums[right];

            if(leftSqr > rightSqr) {
                result[pos] = leftSqr;
                left++;
            } else {
                result[pos] = rightSqr;
                right--;
            }
            pos--;
        }
        return result;
    }
}