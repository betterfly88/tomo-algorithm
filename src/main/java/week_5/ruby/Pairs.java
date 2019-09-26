package week_5.ruby;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

/***
 * k만큼 차이나는 arr 내의 조합 찾기
 * @author ruby
 */
public class Pairs {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
    	Arrays.sort(arr);
    	
    	int count = 0;
    	for(int i=0; i<arr.length - 1; i++) {
    		for(int j=i+1; j<arr.length; j++) {
    			int diff = arr[j] - arr[i];
        		if ( diff < k ) {
        			continue;
        		} else if ( diff == k ) {
        			count++;
        		} else {
        			break;
        		}
    		}
    	}
    	
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
