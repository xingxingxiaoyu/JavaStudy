package art.bytecode.test;

import java.lang.reflect.Method;

public interface TestInter<T> {

    T getName(String name);

}

class TestImpl implements TestInter<String> {
    @Override
    public String getName(String name) {
        System.out.println(name);
        return "";
    }

    public static void main(String[] args) {
        TestImpl impl = new TestImpl();
        try {
            Method[] declaredMethods = impl.getClass().getDeclaredMethods();
            for (int i = 0; i < declaredMethods.length; i++) {
                Method declaredMethod = declaredMethods[i];
                System.out.println(declaredMethod.toGenericString());
                if (declaredMethod.getReturnType() == Object.class) {
                    declaredMethod.invoke(impl, "xujiafeng");
                }
            }
            System.out.println();

            Method method = impl.getClass().getDeclaredMethod("getName",String.class);
            System.out.println(method.toGenericString());
            method.invoke(impl, "xujiafeng");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
