import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {

    public int[] solution(String[] id_list, String[] report, int k) {
        
        Map<String, List<String>>map = new HashMap<>();
        Map<String,Integer>mail_map = new HashMap<>();

        //user라는 String에 id_list 저장 
        for(String user: id_list){
            List<String> list = new LinkedList<>(); //list 선언

            //map, mail_map 초기화
            map.put(user, list);  //map이라는 Map에 Key = user, value = list 저장
            mail_map.put(user, 0); //mail_map이라는 Map에 Key = user, value = 0 저장
        }

        for(String temp: report){
            String[] arr = temp.split(" ");
            String attacker=arr[0];
            String defender=arr[1];
            List<String> list = map.get(defender);

            if(list.contains(attacker)){
                continue;
            }
            list.add(attacker);
            map.put(defender, list);
        }

        for(String data: map.keySet()){
            List<String> list = map.get(data);
            if(list.size()>=k){
                for(String user: list){
                    int count = mail_map.get(user) +1;
                    mail_map.put(user,count);
                }
            }
        }

            int i=0;
            int[] answer = new int[id_list.length];
            for(String data: id_list){
                answer[i] = mail_map.get(data);
                i++;
            }

        return answer;
    }
}

/*

1. 2차원 배열 선언 arr[][]
2. 첫번째 [] 에는 id_list 저장
3. 두번째 [] 에는 report값 저장 (중복되는 값은 저장하지 않음)
4. for분으로 두번째 [] 비교해서 중복되는 값 저장
5. 저장한 값들 중 k이상되는 값들 선별
6. 두번째 []에 5번의 값이 있으면 cnt++;
*/

