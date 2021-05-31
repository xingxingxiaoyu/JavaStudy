package art.list; 
 
import java.util.LinkedHashMap; 
import java.util.Map; 
 
public class Util { 
    private void add(SimpleNode<String> node, String str) { 
        if (node == null) 
            return; 
        //不考虑链表有环 
        while (node.next != null) { 
            node = node.next; 
        } 
        SimpleNode<String> next = new SimpleNode<>(str); 
        node.next = next; 
        next.prep = node; 
    } 
 
    private void remove(SimpleNode<String> node, int index) { 
 
 
    } 
 
    private void search(SimpleNode<String> node, int index) { 
 
    } 
 
    public static void main(String[] args) { 
        LinkedHashMap<String, String> map = new LinkedHashMap<>(); 
        map.put("a","a"); 
        map.put("b","a"); 
        map.put("a","c"); 
        for (Map.Entry<String, String> entry : 
                map.entrySet()) { 
            System.out.println(entry.getKey()); 
        } 
    } 
 
 
} 
