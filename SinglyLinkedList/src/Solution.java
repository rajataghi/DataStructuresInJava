import java.util.HashMap;


class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] indices = new int[2];
        HashMap<Integer,Integer> val = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            val.put(nums[i],i);
        }
        for (Integer i : val.keySet()) {
            System.out.println("key: " + i + " value: " + val.get(i));
        }

        for(int i = 0;i<nums.length;i++){
            indices[0]=i;
            if(val.get(target-nums[i])!=null && val.get(target-nums[i])!=i){
                indices[1]=val.get(target-nums[i]);
                //System.out.println("I reached here" + indices[0]+ indices[1]);
                break;
            }
        }

        return indices;
    }

    public static void main(String[] args){
        int[] num = new int[3];
        num[0]=3;
        num[1] = 2;
        num[2] = 4;
        int[] ans = twoSum(num,6);
        //System.out.println(ans[0]+ " " + ans[1]);
    }
}
