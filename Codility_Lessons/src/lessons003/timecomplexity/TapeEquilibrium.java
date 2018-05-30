package lessons003.timecomplexity;

import static org.junit.Assert.*;

import org.junit.Test;

public class TapeEquilibrium {
	public int solution(int[] A) {
        if(A.length < 2){
            return 0;
        }
        
        int sumT = 0;
        for(int num : A){
            sumT += num;
        }
        
        int sumL = 0, sumR = 0;
        int difMin = Integer.MAX_VALUE;
        int repeatCount = A.length - 1;
        for(int i = 0; i < repeatCount; i++){
            sumL += A[i];
            sumR = sumT - sumL;
            difMin = Math.min(difMin, Math.abs(sumL-sumR));
        }
        
        return difMin;
    }
	
	@Test
	public void test() throws Exception {
		assertEquals(1, solution(new int[] {3, 1, 2, 4, 3}));
		assertEquals(1, solution(new int[] {-3, -1, -2, -4, -3}));
		assertEquals(0, solution(new int[] {}));
		assertEquals(0, solution(new int[] {1}));
		assertEquals(1, solution(new int[] {1, 2}));
	}
}
