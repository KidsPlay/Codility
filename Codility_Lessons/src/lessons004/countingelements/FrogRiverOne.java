package lessons004.countingelements;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class FrogRiverOne {
	
	public int solution(int X, int[] A) {        
        Set<Integer> hs = new HashSet<>();
        for(int i = 1; i <= X; i++){
            hs.add(i);
        }
        
        int arrLen = A.length;
        for(int i = 0; i < arrLen; i++){
            if(hs.contains(A[i])){
                hs.remove(A[i]);
            }
            
            if(hs.size() == 0){
                return i;
            }
        }
        
        return -1;
    }
	
	@Test
	public void test() throws Exception {
		assertEquals(0, solution(1, new int[] {1}));
		assertEquals(-1, solution(2, new int[] {1}));
		assertEquals(0, solution(1, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
		assertEquals(4, solution(2, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
		assertEquals(4, solution(3, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
		assertEquals(4, solution(4, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
		assertEquals(6, solution(5, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
		assertEquals(-1, solution(6, new int[] {1, 3, 1, 4, 2, 3, 5, 4}));
	}
	
}
