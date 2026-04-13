class Solution {
    public int maxProfit(int[] prices) {
        /**
        //Approach 02 - Min so far + Max difference
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {

            // Step 1: Track minimum price
            if (price < minPrice) {
                minPrice = price;
            }

            // Step 2: Calculate profit
            int profit = price - minPrice;

            // Step 3: Update max profit
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }

        return maxProfit;
         */

        //Approach - Two Pointer
        // O(n) 
        // O(1)
        int left = 0;   // buy pointer
        int right = 1;  // sell pointer
        int maxProfit = 0;

        while (right < prices.length) {

            // profitable case
            if (prices[right] > prices[left]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } 
            // found smaller price → better buy day
            else {
                left = right;
            }

            right++;
        }

        return maxProfit;
        
    }
}