/**
 * 
 */
package github.com.ErnestL1n;

/**
 * @author https://github.com/ErnestL1n
 *
 */
//Leetcode.1534
public class Count_Good_Triplets {

	/**
	 * @param args
	 */
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int cnt = 0;
        int n = arr.length;
        for(int i = 0; i < n -2; i++) {
            for(int j = i + 1; j < n - 1; j++) {
                if(Math.abs(arr[i] - arr[j]) <= a) { // check if satisfy then loop for k
                    for(int k = j + 1; k < n; k++) {
                        if(Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c)
                            cnt++;
                    }
                }
            }
        }
        
        return cnt;
    }
	public static void main(String[] args) {

	}

}
