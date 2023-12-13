public class Recursion {

    public static void main(String[] args) {
        System.out.println("gcd(36, 20) = " + gcd(36, 20));
        System.out.println("gcd(34, 0) = " + gcd(34, 0));
        System.out.println("gcd(3346, 468) = " + gcd(3346, 468));

        System.out.println("f(2) = " + f(2));
        System.out.println("f(3) = " + f(3));
        System.out.println("f(10) = " + f(10));

        printBackward("Java Fun!");
        System.out.println("before printString");
        printString("Java Fun!");
        System.out.println("after printString");
        String reversed = reverseString("Java Fun!");
        System.out.println(reversed);
    }

    // Your code goes here

    // Write a recursive method called gcd that takes two integer parameters and
    // that uses Euclid’s Algorithm to
    // compute and return the greatest common divisor of the two numbers. In your
    // main call gcd as follows:
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    // Write a recursive method called f that takes an int as a parameter and that
    // computes and returns the value
    // of the given function. In your main call f as follows:
    public static int f(int n) {
        if (n < 3) {
            return n;
        } else {
            return (3 * f(n - 1)) + (2 * f(n - 2)) + f(n - 3);
        }
    }

    // First, write a recursive
    // method called printBackward that takes a String as a parameter and that
    // prints the characters of the String
    // backwards (one character per line). It should be a void method. In your main
    // call printBackward as follows:
    public static void printBackward(String str) {
        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.println(str.toCharArray()[i]);
        }
    }

    // Write a recursive method called printString that does the same thing as
    // printBackward
    // but that prints the String in the same order of characters in the String
    // given as the argument (one
    // character per line). In your main call printString as follows:
    public static void printString(String str) {
        for (char s : str.toCharArray()) {
            System.out.println(s);
        }
    }

    // Write a recursive method called reverseString that takes a String as a
    // parameter and that
    // returns a new String as a return value. The new String should contain the
    // same characters as the
    // parameter, but in reverse order. For example, the output of the following
    // code
    public static String reverseString(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = str.length() - 1; i >= 0; i--) {
            sb.append(str.toCharArray()[i]);
        }
        return sb.toString();
    }
}