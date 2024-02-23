import java.util.Arrays;

public class _189_RotateArray_2 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        rotate(array, 3);
        Arrays.stream(array).forEach(System.out::print);
    }

    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            int newIndex = (i + k) % nums.length;
            result[newIndex] = nums[i];
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
    }
}

