package Bit_Manipulation;

public class swap2Numbers {
    //Here the swappping is done using XOR operation
    //Let there be two numbers a and b
    // a = a^b
    // b = a^b = (a^b)^b = a (XOR with same number gives 0 and XOR with 0 gives the number itself)
    // a = a^b = (a^b)^a = b (XOR with same number gives 0 and XOR with 0 gives the number itself)

    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println("Before Swapping: a = " + a + " b = " + b);
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("After Swapping: a = " + a + " b = " + b);
    }
}
