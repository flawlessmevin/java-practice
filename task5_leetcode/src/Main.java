import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};

        int target = 9;

        int[] result = result(nums, target);

        System.out.println(Arrays.toString(result));
    }

    public static int[] result(int[] numbers, int target){
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int difference = target - numbers[i];
            if(map.containsKey(difference)){
                return new int[]{map.get(difference) + 1,i + 1};
            }
            map.put(numbers[i],i);
        }
        return new int[]{0,0};
    }



}
