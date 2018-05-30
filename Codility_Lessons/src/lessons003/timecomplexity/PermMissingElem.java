package lessons003.timecomplexity;

import static org.junit.Assert.*;

import org.junit.Test;

public class PermMissingElem {
	public int solution(int[] A) {
        int sumA = sum1ToN(A.length + 1);
        int sumB = sum(A);
        
        return sumA - sumB;
    }
    
    private int sum1ToN(int N){
        if(N <= 0){
            throw new IllegalArgumentException();
        }
        
        int sum = 0;
        for(int i = 1; i <= N; i++){
            sum += i;
        }
        
        return sum;
    }
    
    private int sum(int[] A){
        int sum = 0;
        for(int num : A){
            sum += num;
        }
        
        return sum;
    }
    
    @Test
	public void test() throws Exception {
		assertEquals(4, solution(new int[] {2, 3, 1, 5}));
		assertEquals(1, solution(new int[] {}));
	}
}
