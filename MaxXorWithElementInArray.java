class Solution {

    node root = new node();

    public int[] maximizeXor(int[] nums, int[][] queries) {

        int[] arr = new int[queries.length];
        List<int[]> big = new ArrayList<>();

        for (int i = 0; i < queries.length; i++) {
            big.add(new int[]{queries[i][0], queries[i][1], i});
        }

        Collections.sort(big, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });

        Arrays.sort(nums);

        int i = 0;

        for (int[] query : big) {
            while (i < nums.length && nums[i] <= query[1]) {
                insert(nums[i]);
                i++;
            }

            if (i != 0) {
                arr[query[2]] = maxEle(query[0]);
            } else {
                arr[query[2]] = -1;
            }
        }

        return arr; // ✅ return int[]
    }

    void insert(int ele) {
        node curr = root;

        for (int i = 31; i >= 0; i--) {
            int bit = ((ele & (1 << i)) != 0) ? 1 : 0;
            if (!curr.contains(bit)) {
                curr.arr[bit] = new node();
            }
            curr = curr.arr[bit];
        }
    }

    int maxEle(int ele) {
        node curr = root;
        int ans = 0;

        for (int i = 31; i >= 0; i--) {
            int bit = ((ele & (1 << i)) != 0) ? 1 : 0;
            int want = 1 - bit;

            if (curr.contains(want)) {
                ans |= (1 << i);
                curr = curr.arr[want];
            } else {
                curr = curr.arr[bit];
            }
        }
        return ans;
    }
}

class node {
    node[] arr = new node[2];

    boolean contains(int x) {
        return arr[x] != null;
    }
}
