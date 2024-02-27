class _209_MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        int result = minSubArrayLen(7, nums);
        System.out.println(result);
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        int sum = nums[0];
        int result = 0;
        while (start <= end) {
            if (nums[start] == target)
                return 1;

            if (sum >= target) {
                if (result == 0 || end - start < result) {
                    result = end - start + 1;
                }
                sum -= nums[start];
                start++;
            } else if (sum < target) {
                if (end < nums.length - 1) {
                    end++;
                    sum += nums[end];
                } else {
                    sum -= nums[start];
                    start++;
                }
            }
        }
        return result;
    }
}

