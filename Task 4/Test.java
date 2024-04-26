public class Test {
    public static void main(String[] args) {
        TwoWayArrayLinkedList<String> list = new TwoWayArrayLinkedList<>(4);

        System.out.println("Test add(\"a\"):");
        System.out.print("Start: ");
        list.testPrint();

        list.add("a");

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        list.clear();
        System.out.println("==========================================\n");



        System.out.println("Test add(\"e\"):");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        System.out.print("Start: ");
        list.testPrint();

        list.add("e");

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");



        System.out.println("Test add(3, \"H\"):");
        System.out.print("Start: ");
        list.testPrint();

        list.add(3, "H");

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");


        System.out.println("Test get(3):");
        System.out.print("Start: ");
        list.testPrint();

        System.out.println("Returns: " + list.get(3));

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");



        System.out.println("Test set(3, \"K\"):");
        System.out.print("Start: ");
        list.testPrint();

        list.set(3, "K");

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");


        System.out.println("Test indexOf(\"d\"):");
        System.out.print("Start: ");
        list.testPrint();

        System.out.println("Returns: " + list.indexOf("d"));;

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");



        System.out.println("Test remove(\"d\"):");
        System.out.print("Start: ");
        list.testPrint();

        list.remove("d");

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");



        System.out.println("Test totalCapacity():");
        System.out.print("Start: ");
        list.add("a");
        list.testPrint();

        System.out.println("Total capacity: " + list.totalCapacity());

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");



        System.out.println("Test remove(4):");
        System.out.print("Start: ");
        list.testPrint();

        list.remove(4);

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        list.clear();
        System.out.println("==========================================\n");



        System.out.println("Test totalCapacity():");
        System.out.print("Start: ");
        list.testPrint();

        System.out.println("Total capacity: " + list.totalCapacity());

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");



        System.out.println("Test remove(0):");
        System.out.print("Start: ");
        list.add("a");
        list.testPrint();

        list.remove(0);

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");



        System.out.println("Test endCapacity:");
        System.out.print("Start: ");
        list.add("a");
        list.testPrint();

        System.out.println("End capacity: " + list.endCapacity());

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        list.clear();
        System.out.println("==========================================\n");



        System.out.println("Test endCapacity:");
        System.out.print("Start: ");
        list.testPrint();

        System.out.println("End capacity: " + list.endCapacity());

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        list.clear();
        System.out.println("==========================================\n");



        System.out.println("Test defrag():");
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");
        list.add("g");
        list.remove("b");
        list.remove("c");
        list.remove("f");
        System.out.print("Start: ");
        list.testPrint();

        list.defrag();

        System.out.print("TestPrint: ");
        list.testPrint();
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("==========================================\n");
    }
}
