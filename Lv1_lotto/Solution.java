class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
                boolean[] arr = new boolean[6];
        int ZeroCnt = 0;
        int cnt = 0;
        int A = 0;

        for(int i=0;i<6;i++){
            if(lottos[i] == 0){
                    ZeroCnt ++;
                    continue;
                }
            for(int j=0;j<6;j++){
                if(lottos[i] == win_nums[j]){
                    arr[i] = true;
                }
            }
        }
        
        //일치하지 않는 숫자개수 구하기
        for(int i=0;i<6;i++){
            if(!arr[i]){
                cnt++;
            }
        }

        //일치하는 숫자가 없을 경우
        if(cnt == 6){
            cnt = 6;
            //0이 하나도 없을 경우
            if(ZeroCnt == 0){
                A = 6;
            }
            //전부 0일 경우
            else if(ZeroCnt == 6){
                A = 1;
            }
            else{
                A = cnt-ZeroCnt;
            }
        }
        //일치하지 않는 숫자 +1 = 순위
        else{
            cnt++;
            A = cnt-ZeroCnt;
        }
        int[] answer = {A ,cnt};
        return answer;
    }
}