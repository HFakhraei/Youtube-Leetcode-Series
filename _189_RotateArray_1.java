import java.util.Arrays;

public class _189_RotateArray_1 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        rotate(array, 3);
        Arrays.stream(array).forEach(System.out::print);
    }

    public static void rotate(int[] nums, int k) {
        for(int i = 0; i < k; i++) {
            rotateOneStepToRight(nums);
        }
    }

    private static void rotateOneStepToRight(int[] nums) {
        int last = nums[nums.length - 1];
        for(int i = nums.length - 2; i >= 0; i--) {
            nums[i + 1] = nums[i];
        }
        nums[0] = last;
    }
}

