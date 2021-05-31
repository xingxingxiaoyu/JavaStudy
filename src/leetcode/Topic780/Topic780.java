package leetcode.Topic780; 
 
public class Topic780 { 
    public static void main(String[] args) { 
 
        System.out.println(new Topic780().reachingPoints(1, 1, 3, 5)); 
    } 
 
    public boolean reachingPoints(int sx, int sy, int tx, int ty) { 
        while (true) { 
            if (Math.min(tx,ty) < Math.min(sx,sy) ) { 
                return false; 
            } 
            if (tx == sx && ty == sy) { 
                return true; 
            } 
            if (tx < ty) { 
                ty = ty - tx; 
            } else { 
                tx = tx - ty; 
 
            } 
        } 
 
    } 
} 
