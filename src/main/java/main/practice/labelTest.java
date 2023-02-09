package main.practice;

public class labelTest {
    public static void main(String ... args){
        first:
        for(int i = 0; i < 10; i++){
            int tmp = i*10;
            for(int j = 0; j < 10; j++){
                if(j==3) continue first;
                System.out.println(tmp+j);
            }
        }
    }
}
