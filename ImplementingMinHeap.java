class Solution {

    ArrayList<Integer> nums;

    Solution() {
        nums = new ArrayList<>();
    }

    public void initializeHeap() {
        nums.clear();
    }

    public void insert(int key) {
        nums.add(key);
        heapifyUp(nums.size() - 1);
    }

    public void changeKey(int index, int newVal) {
        int oldVal = nums.get(index);
        nums.set(index, newVal);

        if (newVal < oldVal) {
            heapifyUp(index);
        } else {
            heapifyDown(index);
        }
    }

    public int extractMin() {
        if (nums.size() == 0) return -1;

        int min = nums.get(0);
        int last = nums.get(nums.size() - 1);

        nums.set(0, last);
        nums.remove(nums.size() - 1);

        heapifyDown(0);
        return min;
    }

    public boolean isEmpty() {
        return nums.isEmpty();
    }

    public int getMin() {
        return nums.get(0);
    }

    public int heapSize() {
        return nums.size();
    }

    /* -------- heap helpers -------- */

    private void heapifyUp(int idx) {
        int parent = (idx - 1) / 2;

        if (idx > 0 && nums.get(parent) > nums.get(idx)) {
            swap(parent, idx);
            heapifyUp(parent);
        }
    }

    private void heapifyDown(int idx) {
        int smallest = idx;
        int left = 2 * idx + 1;
        int right = 2 * idx + 2;

        if (left < nums.size() && nums.get(left) < nums.get(smallest))
            smallest = left;

        if (right < nums.size() && nums.get(right) < nums.get(smallest))
            smallest = right;

        if (smallest != idx) {
            swap(idx, smallest);
            heapifyDown(smallest);
        }
    }

    private void swap(int i, int j) {
        int temp = nums.get(i);
        nums.set(i, nums.get(j));
        nums.set(j, temp);
    }
}
