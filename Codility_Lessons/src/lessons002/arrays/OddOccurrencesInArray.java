package lessons002.arrays;

import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class OddOccurrencesInArray {
	public int solution(int[] A) {
        Set<Integer> hm = new HashSet<Integer>();
        
        for(int num : A){
            if(hm.contains(num)){
                hm.remove(num);
            }else{
                hm.add(num);
            }
        }
                
        return hm.iterator().next();        
    }
	
	@Test
	public void test() throws Exception {
		assertEquals(7, solution(new int[] {9, 3, 9, 3, 9, 7, 9}));
	}
}
