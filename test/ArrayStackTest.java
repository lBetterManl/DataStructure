import com.stack.demo.ArrayStack;
import com.stack.demo.Stack;

/**
 * Created by Hanson on 2017/6/7.
 */
public class ArrayStackTest {
    public static void main(String[] args) {
        Stack stack = new ArrayStack();
        stack.push("大哈");
        stack.push("二狗");
        System.out.println(stack);
        stack.pop();    //先出"二狗"
        System.out.println(stack);
    }
}
