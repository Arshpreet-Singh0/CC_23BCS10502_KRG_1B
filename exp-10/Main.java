package exp-10;

import java.util.*;

public class Main {

    static class Pair {
        int val, idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Pair[] arr = new Pair[n];
        Pair[] temp = new Pair[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Pair(nums[i], i);
        }

        mergeSort(arr, temp, 0, n - 1, ans);

        List<Integer> result = new ArrayList<>();
        for (int x : ans) result.add(x);
        return result;
    }

    static void mergeSort(Pair[] arr, Pair[] temp, int left, int right, int[] ans) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;

        mergeSort(arr, temp, left, mid, ans);
        mergeSort(arr, temp, mid + 1, right, ans);

        merge(arr, temp, left, mid, right, ans);
    }

    static void merge(Pair[] arr, Pair[] temp, int left, int mid, int right, int[] ans) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int rightCount = 0;

        while (i <= mid && j <= right) {
            if (arr[j].val < arr[i].val) {
                temp[k++] = arr[j++];
                rightCount++;
            } else {
                ans[arr[i].idx] += rightCount;
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            ans[arr[i].idx] += rightCount;
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (int p = left; p <= right; p++) {
            arr[p] = temp[p];
        }
    }

    public static void main(String[] args) {
        int[] nums = {5, 2, 6, 1};

        List<Integer> ans = countSmaller(nums);

        System.out.println(ans);
    }
}