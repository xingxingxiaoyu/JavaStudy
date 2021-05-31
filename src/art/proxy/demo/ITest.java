package art.proxy.demo; 
 
import art.proxy.demo.lib.Add; 
import art.proxy.demo.lib.Divide; 
import art.proxy.demo.lib.Minus; 
import art.proxy.demo.lib.Multiply; 
 
public interface ITest { 
    @Add 
    int getOne(int a, int b, int c); 
 
    @Minus 
    int getTwo(int a, int b, int c); 
 
    @Multiply 
    int getThree(int a, int b, int c); 
 
    @Divide 
    int getFourth(int a, int b, int c); 
} 
