import java.util.Arrays;

class _128_LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        int result = longestConsecutive(nums);
        System.out.println(result);
    }
    public static int longestConsecutive(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        Arrays.sort(nums);

        int result = 1;
        int pointer = 0;
        int skip = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i-1] == 1) {
                if (i - pointer - skip + 1 > result)
                    result++;
            } else if (nums[i] - nums[i-1] == 0) {
                skip++;
            } else {
                pointer = i;
                skip = 0;
            }
        }
        return result;
    }

}

