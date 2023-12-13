public class Unique {

    public static void main(String[] args) {
        int[] ints1 = { 8, 4, 2, 6, 3, 7, 5, 8, 9, 15 };
        int[] ints2 = { 8, 4, 2, 6, 3, 7, 5, 9, 15 };
        System.out.println("true: " + occurs(8, ints1, 1));
        System.out.println("false: " + occurs(8, ints2, 1));
        System.out.println("false: " + unique(ints1));
        System.out.println("true: " + unique(ints2));
    }

    // Returns true if x occurs in the range [i, nums.length - 1] in nums;
    // false otherwise. That is, if x occurs in nums between i and
    // nums.length - 1 inclusive. This method must be recursive.
    public static boolean occurs(int x, int[] nums, int i) {
        // Fill this in
        if (x == nums[i]) {
            return true;
        } else {
            if (i < nums.length - 1 && occurs(x, nums, i + 1)) {
                return true;
            } else {
                return false;
            }
        }
    }

    // Return true if the elements in nums are unique, i.e., if there are
    // no duplicates; false otherwise.
    public static boolean unique(int[] nums) {
        // Fill this in
        boolean isUnique = true;
        for (int i = 0; i < nums.length; i++) {
            isUnique = isUnique && isUnique(nums, nums[i], i);
        }
        return isUnique;
    }
    
    // Note that unique itself may not be recursive, but you would find it helpful to define an auxiliary function that
    // is recursive. If you write such an auxiliary function, make it recursive.
    public static boolean isUnique(int[] array, int num, int index) {
        for (int i = 0; i < array.length; i++) {
            if (i != index && array[i] == num) {
                return false;
            }
        }
        return true;
    }
}