package art.bytecode.lambda.methodhandler;

import java.lang.invoke.*;
import java.util.function.Consumer;

public class MethodHandlerTest {
    public static void main(String[] args) throws Throwable {
        {
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            //获取String类中静态方法valueOf对应的方法句柄
            MethodHandle valueOfMethodHandler = lookup.findStatic(String.class, "valueOf", MethodType.methodType(String.class, int.class));
            //执行方法句柄
            String result = (String) valueOfMethodHandler.invokeExact(12);
            System.out.println(result);
        }
        {
            MethodType type = MethodType.methodType(String.class, int.class, int.class);
            MethodHandles.Lookup lookup = MethodHandles.lookup();
            MethodHandle handle = lookup.findVirtual(String.class, "substring", type);
            ConstantCallSite callSite = new ConstantCallSite(handle);
            MethodHandle invoker = callSite.dynamicInvoker();
            String result = (String) invoker.invoke("Hello", 0, 3);
            System.out.println(result);

            System.out.println(handle.invoke("Hello", 0, 3));
        }


//        INVOKEDYNAMIC accept()Ljava/util/function/Consumer; [
//        // handle kind 0x6 : INVOKESTATIC
//        java/lang/invoke/LambdaMetafactory.metafactory(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;
//        // arguments:
//        (Ljava/lang/Object;)V,
//                // handle kind 0x6 : INVOKESTATIC
//                art/methodhandler/MethodHandlerTest.lambda$main$0(Ljava/lang/String;)V,
//                (Ljava/lang/String;)V
//    ]

//        LambdaMetafactory.metafactory()
        updateAfterPay(info -> System.out.println(info));
    }

    private static void updateAfterPay(Consumer<String> consumer) {
        System.out.println("start ...");
        consumer.accept("pay success");
        System.out.println("end ...");
    }
}
