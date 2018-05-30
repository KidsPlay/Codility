package lessons006.sorting;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class Distinct {
	/**
	 * 정렬을 이용 한 알고리즘.
	 * 시간복잡도 = O(Nlog(N))
	 * 공간복잡도 = O(N)
	 * @param A
	 * @return Count of distinct number. 
	 */
	public int solution_B(int[] A) {
        if(A == null) return 0;
        
        if(A.length < 2){
            return A.length;
        }
        
        /* 원본을 변경하는 것은 좋지 않기에 복사한 후 사용한다. */
        int[] arr = Arrays.copyOf(A, A.length);
        Arrays.sort(arr);
        
        int currentNum = Integer.MAX_VALUE;
        int countOfDistinctNum = 0;
        for(int num : arr) {
        		if(currentNum != num) {
        			countOfDistinctNum++;
        		}
        		currentNum = num;
        }
        
        return countOfDistinctNum;
    }
	
	@Test
	public void testSolution_B() throws Exception {
		assertEquals(3,  solution_B(new int[] {2, 1, 1, 2, 3, 1}));
		assertEquals(6,  solution_B(new int[] {1, 2, 3, 4, 5, 6}));
		assertEquals(3,  solution_B(new int[] {3, 3, 2, 2, 2, 1}));
		assertEquals(3,  solution_B(new int[] {3, 3, 2, 1, 1, 1}));
		assertEquals(3,  solution_B(new int[] {-2, -1, -1, -2, -3, -1}));
		assertEquals(6,  solution_B(new int[] {-2, -1, 0, 1, 2, 3, 0, 0}));
	}
	
	/**
	 * 정렬을 사용하지 않는 방법.
	 * @param A
	 * @return
	 */
	public int solution_A(int[] A) {
		if(A == null || A.length == 0){
            return 0;
        }
        
        Set<Integer> set = new HashSet<>();
        for(int num : A){
            set.add(num);
        }
        
        return set.size();
    }
	
	@Test
	public void testSolution_A() throws Exception {
		assertEquals(3,  solution_A(new int[] {2, 1, 1, 2, 3, 1}));
		assertEquals(6,  solution_A(new int[] {1, 2, 3, 4, 5, 6}));
		assertEquals(3,  solution_A(new int[] {3, 3, 2, 2, 2, 1}));
		assertEquals(3,  solution_A(new int[] {3, 3, 2, 1, 1, 1}));
		assertEquals(3,  solution_A(new int[] {-2, -1, -1, -2, -3, -1}));
		assertEquals(6,  solution_A(new int[] {-2, -1, 0, 1, 2, 3, 0, 0}));
	}
}
