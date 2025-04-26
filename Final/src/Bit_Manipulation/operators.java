package Bit_Manipulation;
public class operators {

    //The compiler stores integers in the form of bits in the memory.
    //Out of the 32 bits, the leftmost bit is the sign bit, which is 0 for positive numbers and 1 for negative numbers.
    //The negative number is stored in 2's complement form.
    //First they take 1's complement of the number and then add 1 to it. This is the negative number form of the number.
    public static void main(String[] args) {
        // 1. The right shift operator (>>) shifts the bits of the number to the right by the number of positions specified in the right operand.
        int x  = 13>>1; // 13 is 1101 in binary. After right shift by 1, it becomes 0110 which is 6 in decimal
        System.out.println("The output of right shifht on thirteen is:"+x);
        //The right shift of x>>k is equivalent to x/(2^k)

        // 2. The left shift operator (<<) shifts the bits of the number to the left by the number of positions specified in the right operand.
        int y = 13<<1; // 13 is 1101 in binary. After left shift by 1, it becomes 11010 which is 26 in decimal
        System.out.println("The output of left shifht on thirteen is:"+y);
        //The left shift of x<<k is equivalent to x*(2^k)

        //3. The not operator (~) is a unary operator that flips the bits of the number.
        //if the number is negative then it stores its 2's complement form.
        //Else if the number is positive then it stores the number as it is.
        int z = ~13; // 13 is 1101 in binary. After flipping the bits, it becomes 0010 which is 2 in decimal
        System.out.println("The output of not operator on thirteen is:"+z);
    }
}
