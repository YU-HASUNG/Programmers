class Solution {
    public int solution(String s) {
        
        int answer = Integer.MAX_VALUE;
        int len = s.length();
        
        if(s.length()==1) return 1; // 한문자일 경우 1 return;
        
        for(int r=1; r<=len/2; r++) { //반을 기준으로 계산
        	String pattern  = s.substring(0,r);
        	int cnt =1;
        	String reStr="";
        	for(int i=r; i<=s.length()-r; i+=r){
        		if(pattern.equals(s.substring(i,i+r))){
    				cnt++;
    			}else {
    				if(cnt>1) {
    					reStr += cnt+"";
    				}
   				    reStr += pattern;
    				pattern = s.substring(i,i+r);
    				cnt=1;
    			}
        	}
        	
        	if(cnt>1) {
    			reStr+= ""+cnt;
    		}
    		reStr+= pattern;
    		
    		int div = s.length()%r;
    		answer = Math.min(answer, reStr.length()+div);
        }
        return answer;
    }
}