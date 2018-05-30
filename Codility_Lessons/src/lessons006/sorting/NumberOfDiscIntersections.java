package lessons006.sorting;

import java.util.*;

public class NumberOfDiscIntersections {
	public int solution(int[] A) {
        Pair[] pairs = new Pair[A.length];
        
        for(int i = 0; i < A.length; i++){
            long radius = A[i];
            pairs[i] = new Pair(i-radius, i+radius);
        }
        
        Arrays.sort(pairs);
        
        for(Pair pair : pairs){
            System.out.println(pair);
        }
        System.out.println();
        
        int count = 0;
        
        coumputeBase:
        for(int i = 0; i < pairs.length -1; i++){
            Pair base = pairs[i];
            
            checkIntersect:
            for(int j = i+1; j < pairs.length; j++){
                if(base.isIntersect(pairs[j])){
                    count++;
                    if(count >= 10000000){
                        count = -1;
                        break coumputeBase;
                    }
                }else{
                    break checkIntersect;
                }
            }
        }
        
        return count;
    }
    
    class Pair implements Comparable<Pair>{
        private long begin;
        private long end;
        
        public Pair(long begin, long end){
            this.begin = begin;
            this.end = end;
        }
        
        public long getBegin(){
            return begin;
        }
        
        public long getEnd(){
            return end;
        }
        
        public boolean isIntersect(Pair pair){
            if(pair == null) return false;
            
            return  (pair.begin >= begin && pair.begin <= end) || 
                    (pair.end >= begin && pair.end <= end);
        }
        
        public int compareTo(Pair pair){
            if(begin <= pair.getBegin()){
                return -1;
//            }else if(begin == pair.getBegin()){
//                return 0;
            }else{
                return 1;
            }
        }
        
        public String toString(){
            return "begin = " + begin + "\tend = " + end;
        }
    }
    
    //=========
    
    public int solution_B(int[] A) {
        Pair[] pairs = new Pair[A.length];
        
        for(int i = 0; i < A.length; i++){
            long radius = A[i];
            pairs[i] = new Pair(i-radius, i+radius);
        }
        
        Arrays.sort(pairs);
        
        // for(Pair pair : pairs){
        //     System.out.println(pair);
        // }
        // System.out.println();
        
        int pairsLen = pairs.length;
        int count = 0;
               
        for(int i = 0; i < pairsLen -1; i++){
            Pair base = pairs[i];
            
            for(int j = i+1; j < pairsLen && base.isIntersect(pairs[j]); j++){
                count++;
                if(count > 10000000){
                    return -1;                   
                }
            }
        }
        
        return count;
    }
    
}
