public class Solution {
    public int sumBitDifferences(int[] nums) {
        // code here
        int freq[] = new int[32];

        for(int num : nums){
            for(int i=0;i<=31;i++){
                if((num & (1<<i))!=0) freq[i]++;
            }
        }
        int ans = 0;
        int n = nums.length;

        for(int i=0;i<=31;i++){
            ans += Math.max(0, freq[i]*(n-freq[i]));
        }
        return ans*2;
    }
}