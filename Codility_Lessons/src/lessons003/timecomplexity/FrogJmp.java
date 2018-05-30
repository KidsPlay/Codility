package lessons003.timecomplexity;

import static org.junit.Assert.*;

import org.junit.Test;

public class FrogJmp {

	public int solution(int X, int Y, int D) {
        int mok = (Y - X) / D;
        int remain = (Y - X) % D;
        
        return remain == 0 ? mok : mok + 1;
    }
	
	@Test
	public void test() throws Exception {
		assertEquals(3, solution(10, 85, 30));
		assertEquals(999999999, solution(1, 1000000000, 1));
	}
	
}
