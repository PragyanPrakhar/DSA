import java.util.*;

class Solution {
    static List<Integer> balanced = new ArrayList<>();

    static {
        // Precompute all balanced numbers up to 10^6
        generateBalancedNumbers(0, new int[10]);
        Collections.sort(balanced);
        System.out.println(balanced);
    }

    public int nextBeautifulNumber(int n) {
        int left = 0, right = balanced.size() - 1, ans = -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (balanced.get(mid) > n) {
                ans = balanced.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    // Recursively build balanced numbers
    private static void generateBalancedNumbers(int num, int[] freq) {
        if (num > 10_000_000)
            return;

        if (num != 0 && isBalanced(freq)) {
            balanced.add(num);
        }

        // int start = (num == 0 ? 1 : 0); // avoid leading zero recursion
        for (int d = 1; d <= 9; d++) {
            freq[d]++;
            generateBalancedNumbers(num * 10 + d, freq);
            freq[d]--;
        }
    }

    private static boolean isBalanced(int[] freq) {
        for (int d = 1; d <= 9; d++) {
            if (freq[d] > 0 && freq[d] != d)
                return false;
        }
        return true;
    }
}


// [1, 22, 122, 212, 221, 333, 1333, 3133, 3313, 3331, 4444, 14444, 22333, 23233, 23323, 23332, 32233, 32323, 32332, 33223, 33232, 33322, 41444, 44144, 44414, 44441, 55555, 122333, 123233, 123323, 123332, 132233, 132323, 132332, 133223, 133232, 133322, 155555, 212333, 213233, 213323, 213332, 221333, 223133, 223313, 223331, 224444, 231233, 231323, 231332, 232133, 232313, 232331, 233123, 233132, 233213, 233231, 233312, 233321, 242444, 244244, 244424, 244442, 312233, 312323, 312332, 313223, 313232, 313322, 321233, 321323, 321332, 322133, 322313, 322331, 323123, 323132, 323213, 323231, 323312, 323321, 331223, 331232, 331322, 332123, 332132, 332213, 332231, 332312, 332321, 333122, 333212, 333221, 422444, 424244, 424424, 424442, 442244, 442424, 442442, 444224, 444242, 444422, 515555, 551555, 555155, 555515, 555551, 666666]
