package lessons005.prefixsum;

public class MinAvgTwoSlice {

	/**
	 * 100% 정답.
	 * @param A
	 * @return
	 */
	public int solution(int[] A) {
        int arrLength = A.length;
        double[] sumArr = new double[arrLength-1];
        double[] avgArr = new double[arrLength-1];
                        
        /*
         * 2개씩 더한 sum, avg 값을 담고있는 배열을 만든다.
         * */
        for(int i = 0; i < arrLength - 1; i++){
            sumArr[i] = A[i] + A[i+1];
            avgArr[i] = sumArr[i] / 2d;
        }
        
//        System.out.print("sumArr = ");
//        for(double num : sumArr){
//            System.out.print(num + ", ");
//        }
//        System.out.println();
//        
//        System.out.print("avgArr = ");
//        for(double num : avgArr){
//            System.out.print(num + ", ");
//        }
//        System.out.println();
        
        /*
         * 핵심이다.
         * [4, 2, 2] 인 경우, 먼저 [4, 2]의 평균은 3이다.
         * 이 때 그 다음수가 평균보다 작으면 평균을 낮추기 때문에 합하여 계산할 필요가 있고, 아니면 계산할 필요가 없다.
         * 이 경우 평균인 3보다 다음수인 2가 더 작으므로, 2를 합해서 평균을 다시 계산하면 [4, 2, 2]의 평균은 2.6이 된다.
         * 
         * 반면에 [4, 2, 3] 인 경우에는 [4, 2]의 평균인 3보다 그 다음수인 3인 작지 않으므로 다음수를 계산할 필요가 없다.
         * */
        for(int i = 0; i < avgArr.length; i++){
            for(int j = i+2; j < arrLength; j++){
                if(A[j] < avgArr[i]){
                    sumArr[i] += A[j];
                    avgArr[i] = sumArr[i] / (j - i + 1);
                }else{
                    break;
                }
            }
        }
        
//        System.out.print("sumArr = ");
//        for(double num : sumArr){
//            System.out.print(num + ", ");
//        }
//        System.out.println();
//        
//        System.out.print("avgArr = ");
//        for(double num : avgArr){
//            System.out.print(num + ", ");
//        }
//        System.out.println();
        
        /*
         * 평균을 구해놓은 배열에서 최소값과 index 만 찾으면 끝.
         * */
        int minIndex = 0;
        double minAvg = Double.MAX_VALUE;
        for(int i = 0; i < avgArr.length; i++){
            if(avgArr[i] < minAvg){
                minIndex = i;
                minAvg = avgArr[i];
            }
        }

        return minIndex;
    }
	
	/**
	 * 정답은 맞지만, 퍼퍼먼스가 O(N)이 나오지 않는 해답.
	 * @param A
	 * @return
	 */
	public int solutionB(int[] A) {

		double minAvg = Double.MAX_VALUE;
        int minIndex = 0;
        
        int arrLength = A.length;
        int countP = arrLength - 1;
        int countQ = arrLength;
        for(int p = 0; p < countP; p++){
            
            double sum = A[p];
            double avg = Double.MAX_VALUE;
            
            for(int q = p+1; q < countQ; q++){
                sum += A[q];     
                double tempAvg = sum / (q - p + 1);
                if(tempAvg < avg){
                    avg = tempAvg;
                }
                System.out.println("p = " + p + "\t/q = " + q + "\tsum = " + sum + "\tavg = " + avg);    
            }
            
            if(avg < minAvg){
                minIndex = p;
                minAvg = avg;
            }
            
            System.out.println("minAvg = " + minAvg + "\tminIndex = " + minIndex);
            System.out.println("=============================");
            
            // System.out.println("minSum = " + minSum + "\ttemp = " + temp + "\tminIndex = " + minIndex);
        }
        
        return minIndex;
        
    }
	
}
