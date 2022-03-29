import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
    public static int solution(int n, int k) {
       
        int answer = 0; //조건을 만족하는 소수의 개수

        StringBuilder sb = new StringBuilder();
        //진수 변환
        while (n>=k){
            sb.insert(0, n%k);
            n = n/k;
        }
        sb.insert(0, n);

        String change = sb.toString(); //진수변환이 완료된 String
        
        long tmp = 0L; //P의값을 넣을 tmp 변수

        //탐색
        for(int i=0;i<change.length();i++){
            if(change.charAt(i) == '0'){
                if(tmp != 0L && is_prime(tmp)){
                    answer++;
                }
                tmp = 0L; //tmp값 초기화
            }
            else{
                tmp = tmp*10 + (change.charAt(i)-'0'); //tmp값 더해주기
            }
        }

        //마지막 tmp가 0P였을 경우 탐색
        if(tmp%10 != 0L && is_prime(tmp)){
            answer++;
        }

        return answer;
    }

    //소수 판별
    private static boolean is_prime(long num){
        if(num == 1){
            return false;
        }
        int max = (int)Math.sqrt(num);
        for(int i=2;i<=max;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        int S = solution(n,k);
        System.out.println(S);
    }
}