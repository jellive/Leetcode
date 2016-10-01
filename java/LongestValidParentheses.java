class Node{

	int index;
	char c;
	public Node(int index, char c){
		this.index = index;
		this.c = c;
	}
}


public class Solution {
    
    public int longestValidParentheses(String s) {

    	/*

		전략 : 

		문제를 보면 짝이 맞는 괄호의 가장 긴 길이를 구하는 것이다.

		즉, " ) " 이 문자에 의해 짝이 맞는 최대 길이의 개수가 정해진다.

		그래서 내가 새로 만든 자료구조를 보면 
		자기가 몇번째 index에 속하는지, 그리고 자기의 문자를 알고있는 자료구조를 만들었다.
	

    	*/
		char strArray[] = s.toCharArray();
		int length = strArray.length;

		Stack <Node> stack = new Stack<Node>();
    
        if(s.length() == 0 || s.length() == 1 || s == null){
            return 0;
        }

		for(int i = 0 ; i < length ; i++){

			char c = strArray[i];
			if(!stack.isEmpty()){
			    
			    Node peekNode = stack.peek(); 
			    if(peekNode.c == '(' && c == ')'){
			        stack.pop();
			    }else{
		    	    Node node = new Node(i,c);
			        stack.push(node);			    
			    }
			}
			else{
			        Node node = new Node(i,c);
			        stack.push(node);	
			}
		}

		int max = 0;
		int pointer = length;

		while(!stack.isEmpty()){

			Node node = stack.pop();
			int longestLength = pointer - node.index -1;

			if(max < longestLength){
				max = longestLength;
			}
			pointer = node.index;
		}

		if(max < pointer){
			max = pointer;
		}

		return max;
    }


}