package main.practice;

public class StringInternTest {
    public static void main(String... args) {
        String newStr = new String("test");
        String str = "test";
        String internStr = str.intern();
        System.out.println(newStr == internStr);
        System.out.println(newStr.equals(internStr));
        System.out.println(str == newStr);
        String orgNewStr = newStr;
    }
}
//output result :
//        false
//        true
