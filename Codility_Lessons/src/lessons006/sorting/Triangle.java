package lessons006.sorting;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class Triangle {
	
	/*
	 * 삼각형 조건이 존재하는지만 확인하면 된다.
	 * 정렬 후, 연속된 세 숫자에 대한 조건만 확인하면 된다.
	 * */
	public int solution_B(int[] A) {
		if(A == null || A.length < 3) {
			return 0;
		}
		
		/*
		 * ex)
		 * A = {5, 4, 3, 2, 1}
		 * arr = {1, 2, 3, 4, 5}		
		 * */
		int[] arr = Arrays.copyOf(A, A.length);
		Arrays.sort(arr);
		
		for(int i = 0; i < arr.length-2; i++) {
			//계산 결과가 int 범위를 벗어날 수 있기 때문에 long 타입 사용.
		    long p = arr[i+2];
		    long q = arr[i+1];
		    long r = arr[i];
			if( p < q + r &&
				p > q - r &&
				p > -q + r) {
				return 1;
			}
		}
		
		return 0;
	}
	
	@Test
	public void test_B() throws Exception {
		assertEquals(1, solution_B(new int[] {10, 2, 5, 1, 8, 20}));
		assertEquals(0, solution_B(new int[] {10, 50, 5, 1}));
//		assertEquals(1, solution_B(new int[] {}));
	}
	
	/*
	 * 삼각형의 조건이 되는 모든 경우의 수를 구하는 문제라면 이것이 정답일 수도 있다.
	 * 하지만, 여부만 판단하면 되기 때문에 아래처럼 모두 반복하는 것은 비효율적이다.
	 * */
	public int solution_A(int[] A) {
		
        int arrLen = A.length;
        
        for(int p = 0; p < arrLen-2; p++){
            for(int q = p+1; q < arrLen-1; q++){
                for(int r = q+1; r < arrLen; r++){
                    long pNum = A[p];
                    long qNum = A[q];
                    long rNum = A[r];
                    
                    if( pNum < qNum + rNum && 
                        pNum > qNum - rNum &&
                        pNum > rNum - qNum){
                            return 1;
                        }
                }
            }
        }
        
        return 0;
    }
	
	@Test
	public void test_A() throws Exception {
		assertEquals(1, solution_A(new int[] {10, 2, 5, 1, 8, 20}));
		assertEquals(0, solution_A(new int[] {10, 50, 5, 1}));
//		assertEquals(1, solution_B(new int[] {}));
	}
}
