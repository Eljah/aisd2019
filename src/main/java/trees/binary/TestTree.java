package trees.binary;

public class TestTree {
    public static void main(String[] args) {
        Tree tree=new Tree();
        tree.insert(45,"45");
        tree.insert(27,"27");
        tree.insert(35,"35");
        tree.insert(20,"20");
        tree.insert(25,"25");
        tree.insert(21,"21");
        tree.insert(24,"24");
        tree.insert(17,"17");
        tree.insert(22,"22");
        tree.insert(19,"19");
        tree.insert(23,"23");
        tree.insert(18,"18");
        tree.insert(37,"37");
        tree.insert(33,"33");
        tree.insert(34,"34");

        tree.insert(60,"60");
//        tree.insert(60,"60-2");
//        tree.insert(45,"45-2");

        tree.print();
        //tree.remove(40);
        //
        tree.remove(27);

        tree.print();

        tree.remove(25);

        tree.print();

        tree.remove(37);

        tree.print();
    }
}
