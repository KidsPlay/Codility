package lessons005.prefixsum;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
 public int[] solution(String S, int[] P, int[] Q) {
     int strLength = S.length();
     
     //이중배열에 각 문자열이 속한 index를 기록한다.
     int sArr[][] = new int[4][strLength];
     for(int i = 0; i < strLength; i++){
         int row = 0;
         int col = i;
         
         switch(S.charAt(i)){
             case 'A':
                 row = 0;
                 break;
             case 'C':
                 row = 1;
                 break;
             case 'G':
                 row = 2;
                 break;
             case 'T':
                 row = 3;
                 break;
             default:
                 //입력변수 오류.
                 break;
         }
         
         sArr[row][col] = 1;
     }
     
     //추구 범위값 계산을 위한 누적 배열로 변경.
     for(int row = 0; row < 4; row++){
         for(int col = 1; col < strLength; col++){
             sArr[row][col] += sArr[row][col-1];
         }
     }
     
     //logging을 위한 코드.
     // for(int i = 0; i < sArr.length; i++){
     //     for(int j = 0; j < strLength; j++){
     //         System.out.print(sArr[i][j]);
     //     }
     //     System.out.println();
     // }
     
     
     int queryCount = P.length;
     int[] result = new int[queryCount];
     
     for(int i = 0; i < queryCount; i++){
         int p = P[i];
         int q = Q[i];
         
         for(int row = 0; row < 4; row++){
             int resultByCal = (sArr[row][q]) - (p != 0 ? sArr[row][p-1] : 0);
             if(resultByCal > 0){
                 result[i] = row + 1;
                 break;
             }
         }
     }
     
     return result;
 }
}

