public class Solution {
    
    public List<String> letterCombinations(String digits) {
        
        ArrayList <String> result = new ArrayList<String>();
		if(digits == null || digits.length() < 1){
			return result;
		}

		HashMap <Character,String> hashMap = new HashMap<Character, String>();
		hashMap.put('2',"abc");
        hashMap.put('3',"def");
        hashMap.put('4',"ghi");
        hashMap.put('5',"jkl");
        hashMap.put('6',"mno");
        hashMap.put('7',"pqrs");
        hashMap.put('8',"tuv");
        hashMap.put('9',"wxyz");

        StringBuffer bufferString = new StringBuffer();
        dfs(digits,0,result,bufferString,hashMap);
        
        return result;
        
    }
    
    public void dfs(String digits, int step, ArrayList<String> result,StringBuffer buffer, HashMap<Character, String> map){

		if(step == digits.length()){
			result.add(buffer.toString());
			return;
		}

		Character c = digits.charAt(step);
		String str = map.get(c);

		for(int i = 0 ; i < str.length() ; i++){
			buffer.append(str.charAt(i));
			dfs(digits, step + 1, result, buffer, map);
			buffer.deleteCharAt(buffer.length() - 1);
		}
	}
    
}