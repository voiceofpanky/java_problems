package leetcode;

public class BestTimeToBuy_SellStock_121 {


    public static void main (String[] arg){
        int[] prices ={7,1,5,3,6,4};
        //BestTimeToBuy_SellStock_121.maxProfit(prices);
        System.out.print("Max profit:"+BestTimeToBuy_SellStock_121.maxProfit(prices));
    }

    private static int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int profit=0;
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }
            profit= Math.max(profit,prices[i]-minPrice);
        }
        return profit;

    }
}
