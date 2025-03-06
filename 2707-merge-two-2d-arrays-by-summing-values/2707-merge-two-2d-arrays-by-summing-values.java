import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int n1 = nums1.length, n2 = nums2.length;
        int ptr1 = 0, ptr2 = 0;
        List<int[]> mergedArray = new ArrayList<>();

        while (ptr1 < n1 && ptr2 < n2) {
            if (nums1[ptr1][0] == nums2[ptr2][0]) {
                mergedArray.add(new int[]{nums1[ptr1][0], nums1[ptr1][1] + nums2[ptr2][1]});
                ptr1++;
                ptr2++;
            } else if (nums1[ptr1][0] < nums2[ptr2][0]) {
                mergedArray.add(nums1[ptr1]);
                ptr1++;
            } else {
                mergedArray.add(nums2[ptr2]);
                ptr2++;
            }
        }

        while (ptr1 < n1) {
            mergedArray.add(nums1[ptr1]);
            ptr1++;
        }

        while (ptr2 < n2) {
            mergedArray.add(nums2[ptr2]);
            ptr2++;
        }

        int[][] result = new int[mergedArray.size()][2];
        for (int i = 0; i < mergedArray.size(); i++) {
            result[i] = mergedArray.get(i);
        }

        return result;
    }
}
