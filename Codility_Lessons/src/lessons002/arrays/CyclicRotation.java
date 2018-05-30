package lessons002.arrays;

import static org.junit.Assert.*;

import org.junit.Test;

public class CyclicRotation {
	public int[] solution(int[] A, int K) {
        int aLen = A.length;
        
        if(aLen == K) return A;
        
        int[] r = new int[aLen];
        for(int i = 0; i < aLen; i++){
            r[(i+K) % aLen] = A[i];
        }
        
        return r;
    }
	
	@Test
	public void test() throws Exception {
		assertArrayEquals(new int[] {9, 7, 6, 3, 8}, solution(new int[] {3, 8, 9, 7, 6}, 3));
		assertArrayEquals(new int[] {0, 0, 0}, solution(new int[] {0, 0, 0}, 1));
		assertArrayEquals(new int[] {1, 2, 3, 4}, solution(new int[] {1, 2, 3, 4}, 4));
//		assertEquals(new int[] {}, solution(new int[] {}, 3));
//		assertEquals(new int[] {}, solution(new int[] {}, 3));
//		assertEquals(new int[] {}, solution(new int[] {}, 3));
//		
//		assertEquals(new int[] {}, solution(new int[] {}, 3));
	}
}
