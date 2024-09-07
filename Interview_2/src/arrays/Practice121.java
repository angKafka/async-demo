package arrays;

/*121. Best Time to Buy and Sell Stock*/
public class Practice121 {
    public static int[] price = {2,4,1};

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int stockPurchasedAtPrice = Integer.MAX_VALUE;

        //O(N)
        for (int i = 0; i < prices.length; i++) {
            //O(1)
            if(prices[i] < stockPurchasedAtPrice) {
                stockPurchasedAtPrice = prices[i];
            }else{
                maxProfit = Math.max(maxProfit, prices[i] - stockPurchasedAtPrice);
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(price));
    }
}
