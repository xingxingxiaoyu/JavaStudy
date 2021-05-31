package art.bytecode.asm.old.genericity; 
 
 
public class AsmGenericityTest<TString extends String> { 
 
    private TString t; 
 
    private <Bean> Bean test(TString tField) { 
        System.out.println(" " + tField); 
        return (Bean) new Object(); 
    } 
 
 
    private void test() { 
        String s = test((TString) ""); 
    } 
 
 
} 
