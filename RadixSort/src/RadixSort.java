
import java.util.ArrayList;


public class RadixSort {

    public static void main(String[] args) {
        int[] nums = new int[1000000];
        
        // Fills nums with  1 mil random numbers
        for (int i = 0; i < nums.length; i++){
            nums[i] = (int)(Math.random() * 1000000);
        }
        
        // Calls the sort
        radixSort(nums);

        // Displays the nums
        for (int j = 0; j < nums.length; j++){
            if (j % 10 == 9){
                System.out.println(nums[j]);
            } else {
                System.out.print(nums[j] + " ");
            }
        }
    }
    
    
    
    // Sorts a given array with a radix sort
    public static void radixSort(int[] nums){
        // Runs the sort 10 times to sort numbers up to 9 digits in length
        for (int m = 1; m < 10; m++){
            // Creates buckets [0 - 9]
            int length = nums.length;
            ArrayList[] bucket = new ArrayList[10];
            
            // Continues to create buckets if needed and adds numbers into appropriate ones
            for (int i = 0; i < length; i++){
                int key = getKey(nums[i], m);

                if (bucket[key] == null){
                    bucket[key] = new ArrayList<>();
                }

                bucket[key].add(nums[i]);
            }
            
            // Empties buckets back into list
            int k = 0;
            for (int i = 0; i < bucket.length; i++){
                if (bucket[i] != null){
                    for (int j = 0; j < bucket[i].size(); j++){
                        nums[k++] = (int)bucket[i].get(j);
                    }
                }
            }
        }
        
    }
    
    
    
    // Gets the "key" of the number (Which bucket it should be sorted into)
    public static int getKey(int n, int t){
        if (t != 1){
            return (int)( (n % ((int)Math.pow(10, t))) / ( (int)(Math.pow(10, t - 1)) ) );
        } else {
            return n % 10;
        }
    }
    
}
