import java.util.*;

class Solution {
    class BIT {
        int n;
        int[] cnt;
        long[] sum;

        BIT(int n) {
            this.n = n;
            cnt = new int[n + 1];
            sum = new long[n + 1];
        }

        void add(int i, int c, long s) {
            while(i <= n) {
                cnt[i] += c;
                sum[i] += s;
                i += i & -i;
            }
        }

        int queryCount(int i) {
            int res = 0;
            while(i > 0) {
                res += cnt[i];
                i -= i & -i;
            }
            return res;
        }

        long querySum(int i) {
            long res = 0;
            while(i > 0) {
                res += sum[i];
                i -= i & -i;
            }
            return res;
        }

        int kth(int k) {
            int idx = 0;

            for(int bit = Integer.highestOneBit(n); bit > 0; bit >>= 1) {
                int next = idx + bit;

                if(next <= n && cnt[next] < k) {
                    idx = next;
                    k -= cnt[next];
                }
            }

            return idx + 1;
        }
    }

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int m = 0;
        for(int v : sorted) {
            if(m == 0 || sorted[m - 1] != v) {
                sorted[m++] = v;
            }
        }

        BIT bit = new BIT(m);
        long[] cost = new long[n - x + 1];

        long total = 0;

        for(int i = 0; i < n; i++) {
            int idx = Arrays.binarySearch(sorted, 0, m, nums[i]) + 1;

            bit.add(idx, 1, nums[i]);
            total += nums[i];

            if(i >= x) {
                int old = nums[i - x];
                int oldIdx = Arrays.binarySearch(sorted, 0, m, old) + 1;

                bit.add(oldIdx, -1, -old);
                total -= old;
            }

            if(i >= x - 1) {
                int medianIdx = bit.kth((x + 1) / 2);
                long median = sorted[medianIdx - 1];

                long leftCount = bit.queryCount(medianIdx);
                long leftSum = bit.querySum(medianIdx);

                cost[i - x + 1] =
                    median * leftCount - leftSum
                    + (total - leftSum)
                    - median * (x - leftCount);
            }
        }

        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        long[] curr = new long[n + 1];
        for(int j = 1; j <= k; j++) {
            Arrays.fill(curr, INF);
            for(int i = 1; i <= n; i++) {
                curr[i] = curr[i - 1];
                if(i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }
            long[] temp = prev;
            prev = curr;
            curr = temp;
        }
        return prev[n];
    }
}
