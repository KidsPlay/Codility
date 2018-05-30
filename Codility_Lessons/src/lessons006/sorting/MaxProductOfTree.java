package lessons006.sorting;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class MaxProductOfTree {
	
	public int solution(int[] A) {
        Arrays.sort(A);
        
        // for(int num : A){
        //     System.out.println(num + "\t");
        // }
        
        int countOfPositive = 0;
        int countOfNegative = 0;
        
        for(int num : A){
            if(num > 0){
                countOfPositive++;
            }else{
                countOfNegative++;
            }
        }
        
//        for(int num : A){
//            System.out.print(num + ", ");
//        }
//        System.out.println();
//        System.out.println("countOfPositive = "+countOfPositive);
//        System.out.println("countOfNegative = "+countOfNegative);
        
        /*
         * 세 수의 곱셈결과 중 가장 큰 수 구하기.
         * 두가지 경우의 수만 고민하면 될 듯 하다.
         * 음수 2개 이상이고, 양수 1개 이상이면, (제일작은)음수 2 X (제일큰)양수 1 을 곱한 결과가 최대값 후보 1.
         * 나머지 경우에는 모두 제일 큰 수 3개를 곱한 결과가 최대값 후보 2.
         * 후보 1,2를 비교해서 더 큰 수가 최대값이다. 
         * */
        
        int lastIndexOfArr = A.length -1;
        int max = Integer.MIN_VALUE;        
        
        if(countOfNegative >= 2 && countOfPositive >= 1){
            int tempResult = A[0] * A[1] * A[lastIndexOfArr];
            max = Math.max(max, tempResult);       
        }
        
        int tempResult = A[lastIndexOfArr] * A[lastIndexOfArr - 1] * A[lastIndexOfArr - 2];
        max = Math.max(max, tempResult);       
        
        return max;
    }
	
	@Test
	public void test() throws Exception {
		assertEquals(60, solution(new int[] {-3, 1, 2, -2, 5, 6}));
		assertEquals(120, solution(new int[] {6, 5, 4, 3, 2, 1, 0}));
		assertEquals(-6, solution(new int[] {-1, -2, -3, -4, -5, -6}));
		assertEquals(0, solution(new int[] {0, -1, -2, -3, -4, -5, -6}));
		assertEquals(0, solution(new int[] {-6, 0, 1, 2}));
	}
}
