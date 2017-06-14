import com.graph.demo.Graph;
import com.graph.demo.MatrixGraph;

/**
 * Created by Hanson on 2017/6/14.
 */
public class MatrixGraphTest {

    public static void main(String[] args) {
        Object obj[] = { 'A', 'B', 'C', 'D', 'E', 'F' };

        //Graph graph = new MatrixGraph(obj);
        Graph graph = new MatrixGraph(obj);

        //graph.addVex('F');
        graph.addEdge('A','C',5);
        graph.addEdge('B','A',2);
        graph.addEdge('C','B',15);
        graph.addEdge('E','D',4);
        graph.addEdge('F','E',18);
        graph.addEdge('A', 'F', 60);
        graph.addEdge('C', 'F', 70);
        System.out.println(graph.printGraph());
        /*graph.removeEdge('A', 'C');
        System.out.println(graph.printGraph());
        graph.removeVex('E');
        System.out.println(graph.printGraph());*/
        System.out.println(graph.deptFirst('A'));

    }
}
