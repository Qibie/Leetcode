class Palindrome {
	public boolean isPalindrome(int x) {
        if(x < 0 || (x%10 == 0 && x != 0)) {
        	return false;
        }
        int revertedNumber = 0;
        int temp = x;
        while(temp > 0) {
            revertedNumber = revertedNumber * 10 + temp % 10;
            temp /= 10;
        }
        return x == revertedNumber;
    }
}