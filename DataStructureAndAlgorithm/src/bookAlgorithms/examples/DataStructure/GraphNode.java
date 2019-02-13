package bookAlgorithms.examples.DataStructure;

import java.util.ArrayList;
import java.util.List;

public class GraphNode {
    public List<GraphNode> neighbours;
    public GraphNode(){
        this.neighbours = new ArrayList<>();
    }
}
