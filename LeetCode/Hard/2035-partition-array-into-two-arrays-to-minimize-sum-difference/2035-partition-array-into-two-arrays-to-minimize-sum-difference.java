class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int half = n / 2;
        int total = 0;
        for (int x : nums) {
            total += x;
        }
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        for (int i = 0; i <= half; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }
        for (int mask = 0; mask < (1 << half); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < half; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[i];
                    count++;
                }
            }

            left.get(count).add(sum);
        }

        int rightSize = n - half;

        for (int mask = 0; mask < (1 << rightSize); mask++) {
            int sum = 0;
            int count = 0;
            for (int i = 0; i < rightSize; i++) {
                if ((mask & (1 << i)) != 0) {
                    sum += nums[half + i];
                    count++;
                }
            }
            right.get(count).add(sum);
        }

        for (int i = 0; i <= half; i++) {
            Collections.sort(right.get(i));
        }

        int ans = Integer.MAX_VALUE;

        for (int count = 0; count <= half; count++) {

            int need = half - count;

            for (int sum1 : left.get(count)) {

                int target = total / 2 - sum1;

                List<Integer> list = right.get(need);

                int idx = Collections.binarySearch(list, target);

                if (idx < 0) {
                    idx = -idx - 1;
                }

                if (idx < list.size()) {
                    int sum2 = list.get(idx);
                    int selected = sum1 + sum2;

                    ans = Math.min(ans,
                            Math.abs(total - 2 * selected));
                }
                if (idx > 0) {
                    int sum2 = list.get(idx - 1);
                    int selected = sum1 + sum2;

                    ans = Math.min(ans,
                            Math.abs(total - 2 * selected));
                }
            }
        }
        return ans;
    }
}