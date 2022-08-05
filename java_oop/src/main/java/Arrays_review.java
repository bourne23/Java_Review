import java.util.Arrays;

public class Arrays_review {

    // instantiate, declare, assign
    public static int[] numbers = {11, 22, 35, 56, 87};
    public static int[] nums;
    public static char[] chars = {'O', 'L', 'E', 'S', 'S', 'Y', 'A'};


    public static void main(String[] args) {
        nums = new int[5];
        nums[0] = 56;
        nums[1] = 87;
        nums[2] = 22;
        nums[3] = 35;
        nums[4] = 11;
        System.out.println("nums[0] = " + nums[0]);

        getArraysUtilMethods();
        loopArrays();

        // MultiDArray
        multidimensionalArrays();

    }


    public static void getArraysUtilMethods() {

        System.out.println("Arrays.toString(numbers) = " + Arrays.toString(numbers));
        System.out.println("Arrays.toString(nums) = " + Arrays.toString(nums));
// sort
        Arrays.sort(numbers);
        Arrays.sort(nums);
        System.out.println("Arrays.sort(nums) = " + Arrays.toString(nums));

// equals (array1, array2)
        System.out.println("Arrays.equals(numbers, nums) = " + Arrays.equals(numbers, nums));

        // copyOf(array, newLength)
        int[] numsMore = Arrays.copyOf(nums, 7);
        System.out.println("Arrays.copyOf(nums, 7) >> numsMore = " + Arrays.toString(numsMore));
        int[] numsLess = Arrays.copyOf(nums, 3);
        System.out.println("Arrays.copyOf(nums, 3) >> numsLess = " + Arrays.toString(numsLess));

// copyOfRange(array, begIndex, endIndex)  -- end index excluded

        System.out.println("Arrays.toString(chars) = " + Arrays.toString(chars));
        char[] chars2 = Arrays.copyOfRange(chars, 1, 5);
        System.out.println("Arrays.copyOfRange(chars, 1, 5) >> chars2 = " + Arrays.toString(chars2));

    }

    public static void loopArrays() {

        //for loop
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + " is " + numbers[i]);
        }

        // for each
        for (int each : nums) {
            System.out.println("each double = " + each * 2);
        }
    }

    public static void multidimensionalArrays() {

        int[][] arr2D = {{1, 2}, {3, 4, 5, 6, 7}, {0, 9, 8}};
        //           index [0]         [1]           [2]

        //   array2D[0] returns the 1DArray at index 0 = {1,2}
        //   array2D[2][1] returns element at index 1 from array at index 2 = 0
        System.out.println("Arrays.deepToString(arr2D) " + Arrays.deepToString(arr2D));

        //store existing arrays into 2D

        int[][] myArray2D = new int[3][];     // 3- is how many 1DArray are present in 2DArray
        myArray2D[0] = numbers;
        myArray2D[1] = nums;
        myArray2D[2] = new int[]{55, 6, 90, 43};

        System.out.println("Arrays.deepToString(myArray2D) " + Arrays.deepToString(myArray2D));
        System.out.println("Arrays.toString(myArray2D[0]) = " + Arrays.toString(myArray2D[0]));
        System.out.println("Arrays.toString(myArray2D[1]) = " + Arrays.toString(myArray2D[1]));
        System.out.println("Arrays.toString(myArray2D[2]) = " + Arrays.toString(myArray2D[2]));

        System.out.println("myArray2D[2][0] = " + myArray2D[2][0]);

        String [][] groups = {{"Olga", "Anna"}, {"Peter", "Alex", "Vladimir"}, {"OLessya", "Victoria"}};
        System.out.println(Arrays.toString(groups[2]));
        System.out.println(groups[2][1]);
        System.out.println(Arrays.deepToString(groups));
    }

}
