class Solution {
    
    int[][] matrix;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        
        this.matrix = new int[rows][columns];
        int[] answer = new int[queries.length];
        
        //기본 배열을 선언합니다
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                matrix[i][j] = i*columns+j+1;
            }
        }
        
        //queries의 개수만큼 반복합니다
        for(int i=0;i<queries.length;i++){
            answer[i] = rotate(queries[i]);
        }
        
        return answer;
    }
    
    public int rotate(int[] query){
        //좌표값을 받아와 배열의 좌표값으로 변환합니다
        int x1 = query[0]-1; 
        int y1 = query[1]-1;
        int x2 = query[2]-1;
        int y2 = query[3]-1;
        
        //시작위치의 값을 최솟값으로 저장해줍니다
        int tmp = this.matrix[x1][y1];
        int min = tmp;
        
        //첫번째 회전
        for(int i = x1;i<x2;i++){
            this.matrix[i][y1] = this.matrix[i+1][y1];
            if(min > this.matrix[i][y1]) min = this.matrix[i][y1];
        }
        
        //두번째 회전
        for(int i = y1;i<y2;i++){
            this.matrix[x2][i] = this.matrix[x2][i+1];
            if(min > this.matrix[x2][i]) min = this.matrix[x2][i];
        }
        
        //세번째 회전
        for(int i = x2;i>x1;i--){
            this.matrix[i][y2] = this.matrix[i-1][y2];
            if(min > this.matrix[i][y2]) min = this.matrix[i][y2];
        }
        
        //네번째 회전
        for(int i = y2;i>y1;i--){
            this.matrix[x1][i] = this.matrix[x1][i-1];
            if(min > this.matrix[x1][i]) min = this.matrix[x1][i];
        }
        
        this.matrix[x1][y1+1] = tmp;
        
        return min;
        
    }
}