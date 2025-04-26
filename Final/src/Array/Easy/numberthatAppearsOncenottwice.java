package Array.Easy;

public class numberthatAppearsOncenottwice {
//     Two important properties of XOR are the following:

// XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
// XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a.  ←Property 2

// Here all the numbers except the single number appear twice and so will form a pair. Now, if we perform XOR of all elements of the array, the XOR of each pair will result in 0 according to the XOR property 1. The result will be = 0 ^ (single number) = single number (according to property 2).

// So, if we perform the XOR of all the numbers of the array elements, we will be left with a single number.
public static int getSingleElement(int []arr) {
    //size of the array:
    int n = arr.length;

    // XOR all the elements:
    int xorr = 0;
    for (int i = 0; i < n; i++) {
        xorr = xorr ^ arr[i];
    }
    return xorr;
}//This is the optimal Approach 
//The better approach would be to use hashmap
//But always start from the brute force approach
}
