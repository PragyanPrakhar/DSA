
class Solution {

    public int[] constructDistancedSequence(int n) {

        int[] path = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];

        recurr(path, used, 0, n);

        return path;
    }

    private boolean recurr(int[] path, boolean[] used,
                           int idx, int n) {

        if (idx == path.length) {
            return true;
        }

        // Already filled by an earlier choice
        if (path[idx] != 0) {
            return recurr(path, used, idx + 1, n);
        }

        for (int num = n; num >= 1; num--) {

            if (used[num]) continue;

            if (num == 1) {

                path[idx] = 1;
                used[1] = true;

                if (recurr(path, used, idx + 1, n)) {
                    return true;
                }

                path[idx] = 0;
                used[1] = false;

            } else {

                int secondIdx = idx + num;

                if (secondIdx >= path.length ||
                    path[secondIdx] != 0) {
                    continue;
                }

                path[idx] = num;
                path[secondIdx] = num;
                used[num] = true;

                if (recurr(path, used, idx + 1, n)) {
                    return true;
                }

                path[idx] = 0;
                path[secondIdx] = 0;
                used[num] = false;
            }
        }

        return false;
    }
}
