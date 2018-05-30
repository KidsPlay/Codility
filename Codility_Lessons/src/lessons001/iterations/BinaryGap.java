package lessons001.iterations;

import static org.junit.Assert.*;

import org.junit.Test;

public class BinaryGap {

	public int solution(int N) {
        int maxGap = 0;
        int gap = 0;
        boolean started = false;
        
        int mok = N;
        
        while(mok > 0){
            int remain = mok % 2;
            mok /= 2;
            
            if(remain == 1){
                if(!started) started = true;
                else{
                    maxGap = Math.max(maxGap, gap);
                    gap = 0;
                }
            }else{            	
                if(started) gap++;
            }           
        }
        
        return maxGap;
    }
	
	@Test
	public void test() throws Exception {
		assertEquals(2, solution(1001));
		assertEquals(4, solution(529));
		assertEquals(1, solution(20));
		assertEquals(0, solution(15));
		assertEquals(0, solution(32));
		assertEquals(5, solution(1041));
		assertEquals(0, solution(1));
		assertEquals(0, solution(2147483647));
		
//		assertEquals(0, solution(0));
		
	}
}
