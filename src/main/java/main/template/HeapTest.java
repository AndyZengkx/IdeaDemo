package main.template;

public class HeapTest {
    public static void main(String... args) {
        Heap<Integer> heap = new Heap<>(((o1, o2) -> o2 - o1));
        for (int i = 0; i < 100; i++)
            heap.offer((int) (Math.random() * 100));
        while (heap.size() > 0) {
            System.out.println(heap.poll());
        }
    }
}
