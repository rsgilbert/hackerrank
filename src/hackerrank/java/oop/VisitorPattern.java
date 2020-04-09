package hackerrank.java.oop;


import java.util.*;

enum Color {
    RED, GREEN
}

abstract class Tree {

    private int value;
    private Color color;
    private int depth;

    public Tree(int value, Color color, int depth) {
        this.value = value;
        this.color = color;
        this.depth = depth;
    }

    public int getValue() {
        return value;
    }

    public Color getColor() {
        return color;
    }

    public int getDepth() {
        return depth;
    }

    public abstract void accept(TreeVis visitor);
}

class TreeNode extends Tree {

    private ArrayList<Tree> children = new ArrayList<>();

    public TreeNode(int value, Color color, int depth) {
        super(value, color, depth);
    }

    @Override
    public void accept(TreeVis visitor) {
        visitor.visitNode(this);

        for (Tree child : children) {
            child.accept(visitor);
        }
    }

    public void addChild(Tree child) {
        children.add(child);
    }
}

class TreeLeaf extends Tree {

    public TreeLeaf(int value, Color color, int depth) {
        super(value, color, depth);
    }

    @Override
    public void accept(TreeVis visitor) {
        visitor.visitLeaf(this);
    }
}

abstract class TreeVis {
    public abstract int getResult();

    public abstract void visitNode(TreeNode node);

    public abstract void visitLeaf(TreeLeaf leaf);

}

class SumInLeavesVisitor extends TreeVis {
    // sum of the values in the tree's leaves
    private int result = 0;

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public void visitNode(TreeNode node) {
        //implement this
        // intentionally left blank
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        //implement this
         result = Integer.sum(result, leaf.getValue());
    }
}

class ProductOfRedNodesVisitor extends TreeVis {
    private int result = 1;

    @Override
    public int getResult() {
        //implement this
        return result;
    }

    @Override
    public void visitNode(TreeNode node) {
        //implement this
//        if(node.getColor() == Color.RED) {
//            result = result * node.getValue();
//            System.out.println("  node " + node.getValue());
//        }
        System.out.println("visited node " + node.getValue() + " " + node.getColor() + " " + node.getDepth());
    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        //implement this
//        if(leaf.getColor() == Color.RED) {
//            result = result * leaf.getValue();
//            System.out.println( "  leaf " + leaf.getValue());
//        }// else System.out.println("skipped leaf ");
        System.out.println("visited leaf " + leaf.getValue() + " " + leaf.getColor() + " " + leaf.getDepth());

    }
}

class FancyVisitor extends TreeVis {
    private int result = 0;

    @Override
    public int getResult() {
        //implement this
        return result;
    }

    @Override
    public void visitNode(TreeNode node) {
        // implement this
        if(node.getDepth() % 2 == 0) {
            result = result + node.getValue();
        }

    }

    @Override
    public void visitLeaf(TreeLeaf leaf) {
        // implement this
        if(leaf.getColor().equals(Color.GREEN)) {
            result = Math.abs(result - leaf.getValue());
        }
    }
}

/**
 * This was a terrible question
 * I did not finish it
 */
public class VisitorPattern {
    static Scanner sc = new Scanner(System.in);

    public static Tree solve() {
        //read the tree from STDIN and return its root as a return value of this function
        int nodeCount = Integer.parseInt(sc.nextLine().trim());
        int[] values = Arrays.stream(sc.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();


        Color[] colors = Arrays.stream(sc.nextLine().split("\\s"))
                .map(i -> i.equals("0") ? Color.RED : Color.GREEN)
                .toArray(Color[]::new);

        TreeNode root = new TreeNode(values[0], colors[0], 0);

        Map<Integer, Integer> depthsMap = new HashMap<>();
        depthsMap.put(1, 0);

        Set<Integer> finishedNodes = new HashSet<>();
        finishedNodes.add(1);


        HashMap<Integer, Integer> leafNodesAndPos = new HashMap<>();

        for (int i = 1; i < nodeCount; i++) {
            int parent = sc.nextInt();
            int child = Integer.parseInt(sc.nextLine().trim());
            leafNodesAndPos.put(child, i);

            depthsMap.put(child, depthsMap.get(parent) + 1);

            if (!finishedNodes.contains(parent)) {
                TreeNode node = new TreeNode(values[i], colors[i], depthsMap.get(parent));
                root.addChild(node);
                finishedNodes.add(parent);
                leafNodesAndPos.remove(parent);
            }
        }

        for(Map.Entry<Integer, Integer> entry : leafNodesAndPos.entrySet()) {
            TreeLeaf leaf = new TreeLeaf(values[entry.getValue()], colors[entry.getValue()], depthsMap.get(entry.getKey()));
            root.addChild(leaf);
        }

        return root;
    }

    public static void main(String[] args) {
        Tree root = solve();
        SumInLeavesVisitor vis1 = new SumInLeavesVisitor();
        ProductOfRedNodesVisitor vis2 = new ProductOfRedNodesVisitor();
        FancyVisitor vis3 = new FancyVisitor();

        root.accept(vis1);
        root.accept(vis2);
        root.accept(vis3);

        int res1 = vis1.getResult();
        int res2 = vis2.getResult();
        int res3 = vis3.getResult();

//        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);
    }
}

/*
5
4 7 2 5 12
0 1 0 0 1
1 2
1 3
3 4
3 5

5
41 78 22 58 32
0 1 0 0 1
1 2
1 3
3 4
3 5


 */