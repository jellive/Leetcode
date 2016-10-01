//: Playground - noun: a place where people can play

import Cocoa

//32. Longest Parentheses
class Node{
    
    var index:Int
    var c:Character
    
    init(index: Int, c: Character){
        self.index = index
        self.c = c
    }
    
}
struct Stack<Element>{
    
    var items = [Element]()
    
    mutating func push(item:Element){
        items.append(item)
    }
    mutating func pop() -> Element{
        return items.removeLast()
    }
    mutating func peek() -> Element{
        return items.last!
    }
    
}

class Solution {
    
    func longestValidParentheses(_ s: String) -> Int {
        
        let strArray = Array(s.characters)
        let length : Int = strArray.count
        print(strArray)
        
        var stack:Stack = Stack<Node>()
        
        if(length == 0 || length == 1){
            return 0
        }
        
        
        for index in 0..<length{
            
            let c = strArray[index]
            if stack.items.count != 0{
                
                let peekNode = stack.peek()
                if peekNode.c == "(" && c == ")"{
                    stack.pop()
                }
                else{
                    let node = Node(index: index,c: c)
                    stack.push(item: node)
                }
                
            }else{
                let node:Node = Node(index: index,c: c)
                stack.push(item: node)
            }
        }
        
        var max = 0
        var pointer = length
        
        while stack.items.count != 0{
            
            let node = stack.pop()
            let longestLength = pointer - node.index - 1;
            
            if max < longestLength{
                max = longestLength
            }
            pointer = node.index
        }
        
        if max < pointer{
            max = pointer
        }
        
        return max
    }
}

var s :Solution = Solution()
s.longestValidParentheses("()())()()()")
