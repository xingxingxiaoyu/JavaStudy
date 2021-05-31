package daily_question.day3; 
 
import common.BaseNode; 
import common.SingleNode; 
 
public class IntegerNode extends SingleNode<Integer> { 
    public IntegerNode(Integer value) { 
        super(value); 
    } 
 
    public IntegerNode(Integer value, SingleNode<Integer> next) { 
        super(value, next); 
    } 
} 
