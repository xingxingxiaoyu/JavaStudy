package art.bytecode.lambda; 
 
public class LambdaDemo { 
 
 
    public static void testLambda() { 
        printBy(() -> { 
 
        }); 
    } 
 
    public static void testNormal() { 
        printBy(new Testinterface() { 
            @Override 
            public void print() { 
 
            } 
        }); 
    } 
 
    private static Testinterface testinterface = new Testinterface() { 
        @Override 
        public void print() { 
 
        } 
    }; 
 
    public static void testNormal2() { 
        Testinterface testinterface = LambdaDemo.testinterface; 
        long startTime3 = System.currentTimeMillis(); 
        long maxValue = Long.MIN_VALUE + 10_0000_0000L; 
        for (long i = Long.MIN_VALUE; i < maxValue; i++) { 
            printBy(testinterface); 
        } 
        System.out.println(System.currentTimeMillis() - startTime3); 
    } 
 
    public static void printBy(Testinterface testinterface) { 
        testinterface.print(); 
    } 
 
    public static void main(String[] args) { 
        long maxValue = Long.MIN_VALUE + 10_0000_0000L; 
 
        long startTime = System.currentTimeMillis(); 
        for (long i = Long.MIN_VALUE; i < maxValue; i++) { 
            testLambda(); 
        } 
        System.out.println(System.currentTimeMillis() - startTime); 
 
        long startTime2 = System.currentTimeMillis(); 
        for (long i = Long.MIN_VALUE; i < maxValue; i++) { 
            testNormal(); 
        } 
        System.out.println(System.currentTimeMillis() - startTime2); 
 
        testNormal2(); 
//        testNormal2(); 
 
    } 
} 
 
interface Testinterface { 
    void print(); 
} 
 
//package art.bytecode.lambda; 
// 
//public class LambdaDemo { 
// 
// 
//    public static void testLambda() { 
//        printBy(() -> { 
// 
//        }); 
//    } 
// 
//    public static void testNormal() { 
//        printBy(new Testinterface() { 
//            @Override 
//            public void print() { 
// 
//            } 
//        }); 
//    } 
// 
//    private static Testinterface testinterface = new Testinterface() { 
//        @Override 
//        public void print() { 
// 
//        } 
//    }; 
// 
//    public static void testNormal2() { 
// 
//        printBy(testinterface); 
//    } 
// 
//    public static void printBy(Testinterface testinterface) { 
//        testinterface.print(); 
//    } 
// 
//    public static void main(String[] args) { 
//        long maxValue = Long.MIN_VALUE + 10_0000_0000L; 
// 
//        long startTime = System.currentTimeMillis(); 
//        for (long i = Long.MIN_VALUE; i < maxValue; i++) { 
//            testLambda(); 
//        } 
//        System.out.println(System.currentTimeMillis() - startTime); 
// 
//        long startTime2 = System.currentTimeMillis(); 
//        for (long i = Long.MIN_VALUE; i < maxValue; i++) { 
//            testNormal(); 
//        } 
//        System.out.println(System.currentTimeMillis() - startTime2); 
// 
//        long startTime3 = System.currentTimeMillis(); 
//        for (long i = Long.MIN_VALUE; i < maxValue; i++) { 
//            testNormal2(); 
//        } 
//        System.out.println(System.currentTimeMillis() - startTime3); 
//    } 
//} 
// 
//interface Testinterface { 
//    void print(); 
//} 
