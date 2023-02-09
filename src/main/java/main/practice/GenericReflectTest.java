package main.practice;

import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashMap;

public class GenericReflectTest {
    private HashMap<Integer, String> map = new HashMap<>();

    public static void main(String... args) throws NoSuchFieldException {
        var classObj = GenericReflectTest.class;
        var field = classObj.getDeclaredField("map");
        var fType = field.getGenericType();
        System.out.println(fType.getTypeName());
        if (fType instanceof ParameterizedType) {
            var pType = (ParameterizedType) fType;
            System.out.println(pType.getClass().getName());
            Arrays.stream(pType.getActualTypeArguments()).map(w -> w.getTypeName()).forEach(System.out::println);
        }
    }
}
