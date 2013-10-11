public class Solution{
    public int candy(int[] ratings){
        int n = ratings.length;
        int[] candies = new int[n];
        candies[0] = 1;
        int min = 1;
        int sum = 1;
        for (int i = 1; i < n ; i ++){
            candies[i] = candies[i - 1];
            if (ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
            if (ratings[i] < ratings[i-1])
                candies[i] = candies[i-1] - 1;
            if (min > candies[i])
            a    min = candies[i];
            sum += candies[i];
        }
        sum -= n * min;
        return sum;
    }
}
