class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = 0;
        double sum = 0;

        for(int i = 0; i < k; i++) {
            sum += nums[i];
        }

        max = sum;

        for(int i=k; i < nums.length; i++) {
            sum += nums[i];
            sum -= nums[i - k];
            max = Math.max(max, sum);
        }

        return max/k;
    }
}