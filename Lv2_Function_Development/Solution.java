import java.util.ArrayList;

class Solution {
    public static int[] solution(int[] progresses, int[] speeds) {
        
        // 1. progress[0]을 기준으로, 100이상이 될때까지 모든 progress를 하나씩 올려준다.
        // 2. 0이 다 올라갔을때 100이상인 progress 개수 출력
        // 3. 반복

        ArrayList<Integer> arrayList = new ArrayList<>();

        //progress 전체 반복
        for(int i=0;i<progresses.length;i++){
            int cnt = 0;

            //현재 단계의 progress가 100 이상일때까지 반복
            while(progresses[i] < 100){
                for(int j=0;j<progresses.length;j++){
                    progresses[j] += speeds[j]; //각각의 progress에 각각의 speeds를 더해줌
                }
            }
            
            //100넘는 progress판별
            for(int j=i;j<progresses.length;j++){
                if(progresses[j]>=100 && speeds[j]>0){
                    cnt++;
                    speeds[j] = 0; //이미 count된 progress를 배제하기 위해 speed 0으로 변경
                }
                else{
                    break;
                }
            }
            if(cnt != 0){ //cnt가 0이 아닌경우 arrayList에 저장
                arrayList.add(cnt);
            }
        }

        //arrayList 배열로 변경하여 return
        int[] answer = new int[arrayList.size()];
        int size=0;
        for(int temp : arrayList){
            answer[size++] = temp;
        }

        return answer;
    }

    //예시 문제
    public static void main(String[] args) {
        int[] P = {95, 90, 99, 99, 80, 99};
        int[] S = {1, 1, 1, 1, 1, 1};

        int[] sol = solution(P,S);
        
        for(int i=0;i<sol.length;i++){
            System.out.println(sol[i]);
        }
    }
}