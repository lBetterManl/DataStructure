import com.queue.demo.LinkQueue;

/**
 * Created by Hanson on 2017/6/6.
 */
public class LinkQueueTest {
    public static void main(String[] args) {
        LinkQueue linkQue = new LinkQueue();
        linkQue.push("男神");
        linkQue.push("女神");
        linkQue.push("二狗");
        linkQue.push("哈哈");

        System.out.println(linkQue.toString());

        linkQue.deQueue();

        linkQue.push("嘻嘻");

        System.out.println(linkQue.toString());

    }
}
