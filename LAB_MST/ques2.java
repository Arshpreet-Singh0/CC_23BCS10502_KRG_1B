package LAB_MST;

public class ques2 {
     public static int solve(String arr[]){
        int bitmask[] = new int[arr.length];

        int i=0;

        for(String s : arr){
            for(int j=0;j<s.length();j++){
                bitmask[i] |= (1<<(int)(s.charAt(j)-'a'));
            }
            i++;
        }

        int ans = 0;

        for(i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
                if((bitmask[i]&bitmask[j])==0){
                    ans = Math.max(ans, arr[i].length()*arr[j].length());
                }
            }
        }
        return ans;
    }
}
