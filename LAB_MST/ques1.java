package LAB_MST;

import java.util.Arrays;

public class ques1 {
    public static int solve(int arr[][]){
        Arrays.sort(arr, (a, b)-> (b[1]-b[0])-(a[1]-a[0]));

        int ans = 0;
        int curr = 0;

        for(int i=0;i<arr.length;i++){
            int act = arr[i][0];
            int min = arr[i][1];

            if(curr<min){
                ans += (min-curr);
                curr = min;
            }
            curr -= act;
        }

        return ans;
    }
}
