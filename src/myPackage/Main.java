package myPackage;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        //Add elements
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.addLast(40);
        System.out.println("List after addFirst/addLast:");
        printList(list);

        //Insert at index
        list.insertAtIndex(2, 25);
        System.out.println("\nList after insertAtIndex(2, 25):");
        printList(list);

        //Delete at index
        list.deleteAtIndex(1);
        System.out.println("\nList after deleteAtIndex(1):");
        printList(list);

        //Remove first and last
        list.removeFirst();
        list.removeLast();
        System.out.println("\nList after removeFirst and removeLast:");
        printList(list);

        //Reverse
        list.reverse();
        System.out.println("\nList after reverse:");
        printList(list);

        //Add more elements for swap tests
        list.addFirst(50);
        list.addLast(60);
        list.addLast(70);
        System.out.println("\nList before swapNodes tests:");
        printList(list);

        //Swap head and tail
        System.out.println("\nSwap head (0) and tail (list.size()-1):");
        list.swapNodes(0, list.size() - 1);
        printList(list);

        //Swap adjacent nodes
        System.out.println("\nSwap adjacent nodes (1 and 2):");
        list.swapNodes(1, 2);
        printList(list);

        //Swap non-adjacent nodes
        System.out.println("\nSwap non-adjacent nodes (0 and 2):");
        list.swapNodes(0, 2);
        printList(list);

        //Swap same index
        System.out.println("\nSwap same index (1 and 1):");
        list.swapNodes(1, 1);
        printList(list);

        //Contains
        System.out.println("\nContains 25? " + list.contains(25));
        System.out.println("Contains 100? " + list.contains(100));

        //Size
        System.out.println("\nSize of list: " + list.size());
    }

    private static void printList(DoublyLinkedList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}