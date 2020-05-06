/**
Hi everyone!
The solution parses an input string and returns the integer result. The problem can be broken into three steps:

1) Remove spaces at the start of the string.
2) Find the sign of the number.
3) Parse the number, and return of input is huge.

We initialise the sign as positive, and the result to be zero. These are the default return values.
Step 1. 
Lines 16-18 remove all spaces at the start of the string. 

Step 2. 
After this, we set the sign to -1 or +1 if we encounter a - or + respectively. If we get another symbol, we head to line 28.

Step 3. 
While we are parsing digits, add the current digit to the right of the result. 
This is equivalent to multiplying the number by 10 and adding the digit to the result.
Continue doing this till you hit a non-digit character, or your result exceeds 2^32. 
If the result exceeds 2^32, return the extreme value in the integer range as shown in line 40.
Else, return the result.
*/

class Solution {
    public int myAtoi(String str) {
        long result = 0;
        int sign = 1;
        int index = 0;
        while(index < str.length() && str.charAt(index) == ' ') {
            index++;
        }
        if(index < str.length()) {
            if(str.charAt(index) == '-') {
                sign = -1;
                index++;
            } else if(str.charAt(index) == '+') {
                index++;
            }
            while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
                result = result * 10 + str.charAt(index) - '0';
                if(result > Integer.MAX_VALUE) {
                    return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                index++;
            }
        }
        return sign * (int)result;
    }
}
