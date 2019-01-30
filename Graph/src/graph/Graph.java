package graph;

import java.util.ArrayList;
import java.util.Scanner;

public class Graph {

    public static String nodeName;
    public static String edgeStart;
    public static String edgeEnd;
    public static int edgeLength;
    public static int totalNodes;
    public static int totalEdges;

    public static Scanner input = new Scanner(System.in);

    public static ArrayList<Edges> edgeList = new ArrayList<>();
    public static ArrayList<String> connectedNodes = new ArrayList<>();
    public static ArrayList<Nodes> nodes = new ArrayList<>();
    public static ArrayList<String> nodeNames = new ArrayList<>();

    public static void main(String[] args) {

        try {
            createNodes();
            createEdges();
            getInfo();

        } catch (Exception e) {
            System.out.println("----ERROR----");
            System.out.println("You probably entered illegal characters.");
            System.out.println("Error message: " + e);
            
        }

    }

    public static void createNodes() {
        System.out.println("Enter the number of nodes you would like to create: ");
        totalNodes = input.nextInt();

        for (int i = 0; i < totalNodes; i++) {
            System.out.println("Enter name of a new node: (" + (i + 1) + "/" + totalNodes + ")");
            nodeName = input.next();
            Nodes newNode = new Nodes(nodeName);
            nodes.add(newNode);
            nodeNames.add(nodeName);
        }
    }

    public static void createEdges() {
        System.out.println("Enter the number of edges you would like to create: ");
        totalEdges = input.nextInt();

        for (int i = 0; i < totalEdges; i++) {
            System.out.println("Enter the start of a new edge: (" + (i + 1) + "/" + totalNodes + ")");
            edgeStart = input.next();
            System.out.println("Enter the end of that new edge: (" + (i + 1) + "/" + totalNodes + ")");
            edgeEnd = input.next();
            System.out.println("Enter the length of that new edge: (" + (i + 1) + "/" + totalNodes + ")");
            edgeLength = input.nextInt();
            Edges newEdge = new Edges(edgeStart, edgeEnd, edgeLength);
            edgeList.add(newEdge);
        }
    }

    public static void getInfo() {
        System.out.println("Enter the name of a node for info: ");
        String chosenNode = input.next();

        for (Object i : edgeList) {
            if (i instanceof Edges) {
                if (((Edges) i).start.equals(chosenNode)) {
                    connectedNodes.add(((Edges) i).end);
                }
                if (((Edges) i).end.equals(chosenNode)) {
                    connectedNodes.add(((Edges) i).start);
                }
            }
        }

        System.out.println("This node is connected to:");
        for (int i = 0; i < connectedNodes.size(); i++) {
            System.out.println(connectedNodes.get(i));
        }

        nodeNames.sort(String::compareToIgnoreCase);
        System.out.println("All nodes: ");
        for (int i = 0; i < nodeNames.size(); i++) {
            System.out.println(nodeNames.get(i));
        }
    }
}
