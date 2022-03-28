import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class Main {    
    public int[] solution(String[] id_list, String[] report, int k) {
    
        int[] answer = new int[id_list.length];

        //1. 중복제거
        HashSet<String> reportSet = new HashSet<>();// reportSet이라는 Hashset<String>을 생성
        for(String rep: report) reportSet.add(rep);
        
        //2. notifyListHash 만들기
        HashMap<String, ArrayList<String>> notifyListHash = new HashMap<>();
        for(String rep : reportSet){
            int blankIdx = rep.indexOf(" ");//공백의 위치 int로 반환
            String reporter = rep.substring(0, blankIdx); //신고한 사람
            String reportee = rep.substring(blankIdx+1);//신고당한 사람

            ArrayList<String> reporterList = notifyListHash.getOrDefault(reportee, null); //신고당한 사람이 있으면 reportee반환, 없다면 null 반환

            if(reporterList == null) reporterList = new ArrayList<>(); //아직 신고를 안당해  null이라면, reporterList 생성
            
            reporterList.add(reporter); //reporterList에 reporter 추가
            notifyListHash.put(reportee, reporterList); //notifyListHash에 추가
        }
    
        //3. notifyListHash 기반으로 reportHash 만들기
        HashMap<String, Integer> reporterHash = new HashMap<>();
        for(ArrayList<String> notifyList : notifyListHash.values()){
            if(notifyList.size()>=k){
                for(String reporter : notifyList){ //신고한 사람들 한명씩 전달
                    reporterHash.put(reporter, reporterHash.getOrDefault(reporter, 0)+1);//기존 reporter의 value 값을 반환하고, 값이 없으면 0전달(뒤에 +1, 하나 더 누적) 
                }
            }
        }

        //4. reportHash 기반으로 answer 배열 채우기
        for(int i=0;i<id_list.length;i++){
            answer[i] = reporterHash.getOrDefault(id_list[i], 0);
        }

        return answer;
    }


    public static void main(String[] args){ 
        Solution sol = new Solution(); 
        String[] id_list = {"muzi", "frodo", "apeach", "neo"}; 
        String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}; 
        int k = 2;

        sol.solution(id_list, report, k);
    }
}

//HashSet은 주머니 형태로, 비선형적 구조를 띄고있어 순서가 없고, 객체를 중복해서 저장할 수 없습니다