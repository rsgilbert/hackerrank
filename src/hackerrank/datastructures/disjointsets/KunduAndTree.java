package hackerrank.datastructures.disjointsets;

import hackerrank.util.Compute;
import java.util.*;

enum Color { RED, BLACK }

class Node {
    private int id;
    private Node parent;
    private Color color;
    private Node nextRedNode;

    public Node(int id, Node parent, Color color) {
        this.id = id;
        this.parent = parent;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getNextRedNode() {
        return nextRedNode;
    }

    public void setNextRedNode(Node nextRedNode) {
        this.nextRedNode = nextRedNode;
    }
}

class NodeInput {
    int parentId;
    int id;
    Color color;

    public NodeInput(String line) {
        String[] inputs = line.split("\\s");
        // Subtract 1 to use 0-based indexing
        setParentId(Integer.parseInt(inputs[0]) - 1);
        setId(Integer.parseInt(inputs[1]) - 1);
        this.color = inputs[2].equals( "b") ? Color.BLACK : Color.RED;
    }


    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

class Path {
    private int start;
    private int end;
    private Set<Node> nodeSet = new HashSet<>();
    private Color color;

    public Path (int start, int end, Set<Node> nodeSet, Color color) {
        this.start = start;
        this.end = end;
        this.nodeSet = nodeSet;
        this.color = color;
    }


    public Path (int start, int end, Node node, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;

        Set<Node> nodeSet = new HashSet<>();
        nodeSet.add(node);
        this.nodeSet = nodeSet;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    public Set<Node> getNodeSet() {
        return nodeSet;
    }

    public void setNodeSet(Set<Node> nodeSet) {
        this.nodeSet = nodeSet;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}

class KunduTree {
    private List<Path> pathList = new ArrayList<>();
    private List<Node> nodeList;

    public KunduTree(NodeInput[] nodeInputArray) {
        nodeList = new ArrayList<>(nodeInputArray.length);
        for(NodeInput nodeInput: nodeInputArray) {
            Node parentNode = null;
            if(nodeInput.parentId == 0) {
                Node node = new Node(0, null, null);
                nodeList.add(0, node);
            }
            if(nodeInput.parentId < nodeList.size()) {
                parentNode = nodeList.get(nodeInput.parentId);
            }
            Node node = new Node(nodeInput.id, parentNode, nodeInput.color);
            nodeList.add(node);
        }
        setupNextRedNodes();
        setupPaths();
    }

    public long getNumberOfTriplets() {
        long count = 0;
        for(int i = 0; i < nodeList.size(); i++) {
            Node node = nodeList.get(i);
            if(node.getColor() == Color.RED) {
                long combinations = Compute.nCr(nodeList.size() - i - 1, 2).longValue();
                System.out.println("Combinations for i = " + i + " are " + combinations);
                count += combinations;
            }

            while(node != null) {
                node = node.getNextRedNode();
                if(node != null) {

                }
            }

        }
        return count;
    };

    public boolean hasRed(int startIdx, int endIdx) {
        Node node = nodeList.get(endIdx);
        while(node != null && node.getId() != startIdx) {
            if(node.getColor().equals(Color.RED)) {
                return true;
            }
            node = node.getParent();
        }
        return false;
    }

    public void setupNextRedNodes() {
        Node nextRedNode = null;
        for(int idx = nodeList.size() - 1; idx > 0; idx --) {
            Node currentNode = nodeList.get(idx);
            currentNode.setNextRedNode(nextRedNode);
            if(currentNode.getColor() == Color.RED) {
                nextRedNode = currentNode;
            }
        }
    }
    public void setupPaths() {
    }
}

public class KunduAndTree {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        NodeInput[] nodeInputArray = new NodeInput[] {
                new NodeInput("1 2 b"),
                new NodeInput("2 3 b"),
                new NodeInput("3 4 r"),
                new NodeInput("4 5 r"),
                new NodeInput("5 6 b"),
                new NodeInput("6 7 b"),
                new NodeInput("7 8 r"),
                new NodeInput("8 9 b")
        };
        KunduTree kunduTree = new KunduTree(nodeInputArray);
        long numberOfTriplets = kunduTree.getNumberOfTriplets();
        System.out.println(numberOfTriplets);
        System.out.println(kunduTree.hasRed(0, 2));
    }
}
