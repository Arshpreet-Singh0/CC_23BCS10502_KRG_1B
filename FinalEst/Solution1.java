package FinalEst;

public class Solution1 {
    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(arr);

        System.out.println(st.query(0, 0, arr.length-1, 2, 4));

    }
}

class SegmentTree{
    int seg[];

    public SegmentTree(int arr[]){
        seg = new int[4*arr.length];
        build(arr, 0, 0, arr.length-1);
    }

    void build(int[] arr, int idx, int left, int right) {
        if (left == right) {
            seg[idx] = arr[left];
            return;
        }

        int mid = left + (right - left)/2;

        build(arr, 2 * idx + 1, left, mid);
        build(arr, 2 * idx + 2, mid + 1, right);

        seg[idx] = seg[2 * idx + 1] + seg[2 * idx + 2];
    }
    public void update(int idx, int left, int right, int index, int value){
        if(left==right){
            seg[idx] = value;
            return;
        }

        int mid = left + (right - left)/2;

        if(idx<=mid){
            update(2*idx+1, left, mid, index, value);
        }
        else{
            update(2*idx+2, mid+1, right, index, value);
        }
        seg[idx] = seg[2*idx+1] + seg[2*idx+2];
    }

    int query(int idx, int left, int right, int l, int r) {
        if (r < left || right < l){
              return 0;
        }

        if (l <= left && right <= r){
            return seg[idx];
        }

        int mid = left + (right - left)/2;

        int leftSum = query(2 * idx + 1, left, mid, l, r);
        int rightSum = query(2 * idx + 2, mid + 1, right, l, r);

        return leftSum + rightSum;
    }

}
