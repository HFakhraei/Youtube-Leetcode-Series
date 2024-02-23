import java.util.Arrays;

public class _189_RotateArray_3 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        rotate(array, 3);
        Arrays.stream(array).forEach(System.out::print);
    }

    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length -1);
    }

    private static void reverse(int[] nums, int from, int to) {
        int swap = nums[from];
        while (from < to) {
            swap = nums[from];
            nums[from] = nums[to];
            nums[to] = swap;
            from++;
            to--;
        }
    }
}

