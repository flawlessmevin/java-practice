import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;

        int[] result = result(nums, target);

        System.out.println(Arrays.toString(result));

    }

    public static int[] result(int[] numbers, int target){
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i+1, j+1};
                }
            }
        }
        return new int[]{0,0};
    }


}
