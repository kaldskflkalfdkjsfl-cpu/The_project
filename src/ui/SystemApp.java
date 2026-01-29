package ui;

import core.*;
import core.Stack; // Explicit to avoid java.util conflict
import core.Queue; // Explicit to avoid java.util conflict
import advanced.*;
import algorithms.*;
import java.util.Scanner;
import java.util.Arrays;

/**
 * THE ULTIMATE DATA STRUCTURES & ALGORITHMS ENGINE
 * Designed for Professional Educational Purposes.
 */
public class SystemApp {
    private static final Scanner sc = new Scanner(System.in);
    private static final String RESET = "\u001B[0m";
    private static final String GREEN = "\u001B[32m";
    private static final String RED = "\u001B[31m";
    private static final String CYAN = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String PURPLE = "\u001B[35m";

    public static void main(String[] args) {
        showBrand();
        while (true) {
            try {
                printMainMenu();
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 0) {
                    System.out.println(GREEN + "Exiting Professional System. Goodbye!" + RESET);
                    break;
                }
                handleMainChoice(choice);
            } catch (Exception e) {
                System.out.println(RED + "Error: Invalid Input. " + e.getMessage() + RESET);
            }
        }
    }

    private static void showBrand() {
        System.out.println(CYAN + "================================================================" + RESET);
        System.out.println(GREEN + "  ███╗   ███╗ ██████╗ ████████╗██╗  ██╗ █████╗ ███╗   ██╗ █████╗ " + RESET);
        System.out.println(GREEN + "  ████╗ ████║██╔═══██╗╚══██╔══╝██║  ██║██╔══██╗████╗  ██║██╔══██╗" + RESET);
        System.out.println(GREEN + "  ██╔████╔██║██║   ██║   ██║   ███████║███████║██╔██╗ ██║███████║" + RESET);
        System.out.println(GREEN + "  ██║╚██╔╝██║██║   ██║   ██║   ██╔══██║██╔══██║██║╚██╗██║██╔══██║" + RESET);
        System.out.println(GREEN + "  ██║ ╚═╝ ██║╚██████╔╝   ██║   ██║  ██║██║  ██║██║ ╚████║██║  ██║" + RESET);
        System.out.println(GREEN + "  ╚═╝     ╚═╝ ╚═════╝    ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝╚═╝  ╚═══╝╚═╝  ╚═╝" + RESET);
        System.out.println(CYAN + "           ULTIMATE DATA STRUCTURES PROFESSIONAL ENGINE V3.0" + RESET);
        System.out.println(CYAN + "================================================================" + RESET);
    }

    private static void printMainMenu() {
        System.out.println("\n" + PURPLE + ">>> MAIN DASHBOARD <<<" + RESET);
        System.out.println("1. " + YELLOW + "Linear Linked Structures" + RESET + " (SLL, DLL, CLL)");
        System.out.println("2. " + YELLOW + "LIFO & FIFO Structures" + RESET + " (Stack, Queue)");
        System.out.println("3. " + YELLOW + "Hierarchical Tree Structures" + RESET + " (BST, AVL Tree)");
        System.out.println("4. " + YELLOW + "Complex Advanced Structures" + RESET + " (Graph, Heap, Hash Table, Trie)");
        System.out.println("5. " + YELLOW + "Comprehensive Algorithms" + RESET + " (Sorting, Searching)");
        System.out.println("0. " + RED + "Exit System" + RESET);
        System.out.print(CYAN + "Select Module: " + RESET);
    }

    private static void handleMainChoice(int choice) {
        switch (choice) {
            case 1: runLinearModule(); break;
            case 2: runStackQueueModule(); break;
            case 3: runTreeModule(); break;
            case 4: runComplexModule(); break;
            case 5: runAlgoModule(); break;
            default: System.out.println(RED + "Invalid selection." + RESET);
        }
    }

    private static void runLinearModule() {
        System.out.println("\n" + YELLOW + "--- Linear Linked Structures ---" + RESET);
        System.out.println("1. Singly Linked List (SLL)");
        System.out.println("2. Doubly Linked List (DLL)");
        System.out.println("3. Circular Linked List (CLL)");
        System.out.print("Choice: ");
        int c = Integer.parseInt(sc.nextLine());
        
        if (c == 1) {
            SLL<Integer> sll = new SLL<>();
            sll.addFirst(10); sll.addLast(20); sll.addFirst(5);
            System.out.println(GREEN + "SLL created: " + sll + RESET);
        } else if (c == 2) {
            DLL<String> dll = new DLL<>();
            dll.addLast("Data"); dll.addLast("Structure"); dll.addFirst("Professional");
            System.out.println(GREEN + "DLL created: " + dll + RESET);
        } else if (c == 3) {
            CircularLL<Integer> cll = new CircularLL<>();
            cll.add(1); cll.add(2); cll.add(3);
            System.out.print(GREEN + "CLL Display: "); cll.display(); System.out.print(RESET);
        }
    }

    private static void runStackQueueModule() {
        System.out.println("\n" + YELLOW + "--- LIFO & FIFO Structures ---" + RESET);
        System.out.println("1. Stack (LIFO)");
        System.out.println("2. Queue (FIFO)");
        System.out.print("Choice: ");
        int c = Integer.parseInt(sc.nextLine());

        if (c == 1) {
            Stack<Integer> stack = new Stack<>();
            stack.push(100); stack.push(200);
            System.out.println(GREEN + "Stack: " + stack + " | Peeking: " + stack.peek() + RESET);
        } else if (c == 2) {
            Queue<String> queue = new Queue<>();
            queue.enqueue("First"); queue.enqueue("Second");
            System.out.println(GREEN + "Queue: " + queue + " | Dequeueing: " + queue.dequeue() + RESET);
        }
    }

    private static void runTreeModule() {
        System.out.println("\n" + YELLOW + "--- Hierarchical Tree Structures ---" + RESET);
        System.out.println("1. Binary Search Tree (BST)");
        System.out.println("2. AVL Tree (Self-Balancing)");
        System.out.print("Choice: ");
        int c = Integer.parseInt(sc.nextLine());

        if (c == 1) {
            BST<Integer> bst = new BST<>();
            bst.insert(50); bst.insert(30); bst.insert(70);
            System.out.print(GREEN); bst.traverse(); System.out.print(RESET);
        } else if (c == 2) {
            AVLTree<Integer> avl = new AVLTree<>();
            avl.insert(10); avl.insert(20); avl.insert(30);
            System.out.print(GREEN + "AVL InOrder: "); avl.traverse(); System.out.print(RESET);
        }
    }

    private static void runComplexModule() {
        System.out.println("\n" + YELLOW + "--- Complex Advanced Structures ---" + RESET);
        System.out.println("1. Weighted Graph (Dijkstra, BFS, DFS)");
        System.out.println("2. Min-Heap (Priority Basis)");
        System.out.println("3. Hash Table (K-V Pairs)");
        System.out.println("4. Trie (Prefix Tree)");
        System.out.print("Choice: ");
        int c = Integer.parseInt(sc.nextLine());

        if (c == 1) {
            ProfessionalGraph g = new ProfessionalGraph();
            g.addEdge(0, 1, 10); g.addEdge(1, 2, 5); g.addEdge(0, 2, 20); g.addEdge(2, 3, 15);
            System.out.print(GREEN); 
            g.dijkstra(0); 
            g.bfs(0);
            g.dfs(0);
            System.out.print(RESET);
        } else if (c == 2) {
            MinHeap<Integer> heap = new MinHeap<>();
            heap.insert(40); heap.insert(10); heap.insert(30);
            System.out.println(GREEN + "Heap: " + heap + " | Min removed: " + heap.removeMin() + RESET);
        } else if (c == 3) {
            HashTable<String, Integer> map = new HashTable<>();
            map.put("Java", 2024); map.put("DSA", 101);
            System.out.println(GREEN + "Hash Table: " + map + RESET);
        } else if (c == 4) {
            Trie trie = new Trie();
            trie.insert("apple"); trie.insert("app");
            System.out.println(GREEN + "Trie search 'apple': " + trie.search("apple"));
            System.out.println("Trie startsWith 'ap': " + trie.startsWith("ap") + RESET);
        }
    }

    private static void runAlgoModule() {
        System.out.println("\n" + YELLOW + "--- Comprehensive Algorithms ---" + RESET);
        System.out.println("1. Sorting Algorithms");
        System.out.println("2. Searching Algorithms");
        System.out.print("Choice: ");
        int c = Integer.parseInt(sc.nextLine());

        if (c == 1) {
            int[] data = {5, 2, 9, 1, 5, 6};
            System.out.println("Experimental Data: " + Arrays.toString(data));
            System.out.println("1. QuickSort  2. MergeSort  3. BubbleSort  4. SelectionSort  5. InsertionSort");
            int s = Integer.parseInt(sc.nextLine());
            int[] copy = data.clone();
            switch (s) {
                case 1: AdvancedSorter.quickSort(copy, 0, copy.length-1); break;
                case 2: AdvancedSorter.mergeSort(copy); break;
                case 3: AdvancedSorter.bubbleSort(copy); break;
                case 4: AdvancedSorter.selectionSort(copy); break;
                case 5: AdvancedSorter.insertionSort(copy); break;
            }
            System.out.println(GREEN + "Sorted result: " + Arrays.toString(copy) + RESET);
        } else if (c == 2) {
            int[] sortedData = {10, 20, 30, 40, 50};
            System.out.println("Data: " + Arrays.toString(sortedData));
            System.out.print("Enter value to find: ");
            int val = Integer.parseInt(sc.nextLine());
            int idx = SearchingAlgorithms.binarySearch(sortedData, val);
            if (idx != -1) System.out.println(GREEN + "Found at index: " + idx + RESET);
            else System.out.println(RED + "Not found." + RESET);
        }
    }
}
