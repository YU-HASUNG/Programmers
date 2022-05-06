public class Main {
    public static int solution(String s) {
        int answer = Integer.MAX_VALUE; // 최소 문자열을 찾기 위한 비교변수
        
        if(s.length() == 1) return 1; // 문자열의 길이가 1일 경우

        for(int i=1;i<=s.length()/2;i++){
            
            String str = ""; // 정답 문자열
            String temp = ""; //비교할 문자열
            int count = 1; //동일한 문자 개수

            for(int j=0; j<s.length()/i; j++){

                // 이전 문자열과 동일한지
                // ex) dedede인 경우 3번째 de
                if(temp.equals(s.substring(j*i, (j*i)+i))){
                    count++;
                    continue;
                }

                // 같은 문자일 경우
                // 앞을 숫자로 변경하여 str 붙임
                // ex) 3a
                if(count>1){
                    str += count + temp;
                    count = 1;
                }
                // 같은 문자가 아닐경우
                // 그냥 붙임
                else{
                    str += temp;
                }

                System.out.print(temp+" ");
                System.out.println(str);

                // temp에 비교할 문자열 저장
                temp = s.substring(j*i, (j*i)+i); 
            }

            // 마지막 temp에 저장된 문자열 붙임
            // 같을 경우
            if(count>1){
                str += count + temp;
                count = 1;
            }
            //같지 않을 경우
            else{
                str += temp;
            }

            // i 로 나눠떨이지지 않는 경우, 남은 부분 substring으로 붙이기
            if(s.length()%i != 0){
                str += s.substring(s.length()-s.length()%i, s.length());
            }

            System.out.println("str = "+str);

            // 기존 answer과 현재 str을 비교해  더 짧은 것 answer에 저장
            answer = answer > str.length() ? str.length() : answer;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("abcabcdede"));
    }
}