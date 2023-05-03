package algorithm.leetcode;

public class MedianSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {1,3}, nums2 = {2};
        System.out.print(findMedianSortedArrays(nums1, nums2));

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int n = n1 + n2;
        int[] merged = new int[n];

        int i=0, j=0, k=0;

        while (i<=n1 && j<=n2) {
            if (i == n1) {
                while(j < n2) {
                    merged[k++] = nums2[j++];
                }
                break;
            } else if (j == n2) {
                while (i < n1) {
                    merged[k++] = nums1[i++];
                }
                break;
            }

            if (nums1[i] < nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        if (n % 2 == 0)
            return (float)(merged[n/2-1] + merged[n/2])/2;
        else
            return merged[n/2];
    }
}