import com.queue.demo.ArrayQueue;

/**
 * Created by Hanson on 2017/6/6.
 *
 * 测试-》count刚好为DEFAULT_SIZE整数倍时，队尾指向队首即rear=0
 */
public class ArrayQueueTest {
    public static void main(String[] args) {
        ArrayQueue arrQue = new ArrayQueue();
        arrQue.push("男神");
        arrQue.push("嘻嘻");
        arrQue.push("女神");

        System.out.println(arrQue.peek());

        System.out.println(arrQue.toString());

        arrQue.deQueue();

        System.out.println(arrQue.toString());

        arrQue.push("二狗");
        System.out.println(arrQue.toString());
    }
}
