import java.util.*;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int k = k1 + k2;
        int maxDiff = 0;
        int[] freq = new int[100001]; 

        
        for (int i = 0; i < n; i++) {
            int d = Math.abs(nums1[i] - nums2[i]);
            freq[d]++;
            maxDiff = Math.max(maxDiff, d);
        }

        
        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (freq[i] == 0) continue;
            int move = Math.min(k, freq[i]);
            freq[i] -= move;
            freq[i - 1] += move;
            k -= move;
        }

        
        long result = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (freq[i] > 0) {
                result += (long) i * i * freq[i];
            }
        }

        return result;
    }
}
