import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, Integer> minCol = new HashMap<>();
        Map<Integer, Integer> maxCol = new HashMap<>();

        Map<Integer, Integer> minRow = new HashMap<>();
        Map<Integer, Integer> maxRow = new HashMap<>();

        for (int[] b : buildings) {
            int r = b[0], c = b[1];

            minCol.put(r, Math.min(minCol.getOrDefault(r, c), c));
            maxCol.put(r, Math.max(maxCol.getOrDefault(r, c), c));

            minRow.put(c, Math.min(minRow.getOrDefault(c, r), r));
            maxRow.put(c, Math.max(maxRow.getOrDefault(c, r), r));
        }

        int ans = 0;

        for (int[] b : buildings) {
            int r = b[0], c = b[1];

            boolean left  = c > minCol.get(r);
            boolean right = c < maxCol.get(r);
            boolean up    = r > minRow.get(c);
            boolean down  = r < maxRow.get(c);

            if (left && right && up && down) {
                ans++;
            }
        }

        return ans;
    }
}
