import com.seek.demo.Find;

/**
 * Created by Hanson on 2017/6/17.
 */
public class FindTest {
    public static void main(String[] args) {
        //int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int a[] = {3, 7, 4, 1, 0, 6, 2, 8, 8, 9};   //折半查找需是有序数组
        int index = Find.arraySearch(a, 7);
        System.out.println("array: " + index);
        int index2 = Find.binSearch(a, 0, 9, 7);
        System.out.println("bin: " + index2);
    }
}
