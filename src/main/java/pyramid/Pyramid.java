package pyramid;

public class Pyramid {

    private Node[] array = new Node[256];
    int counter = -1;

    class Node {
        public int number;
    }

    public void display() {


    }

    ;

    public void insert(Node node) {
        if (counter == -1) {
            counter++;
            array[0] = node;
        }
        {
            int rootInt = this.array[0].number;
            counter++;
            array[counter] = node;
            throwUp(counter);
            array[counter] = node;
        }
    }

    private void throwUp(int position) {

        int currentInt = position;

        while (currentInt > 0) {
            int old = currentInt;
            currentInt = (currentInt - 1) / 2;
            if (array[old].number > array[currentInt].number) {
                array[old] = array[currentInt];
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {

    }


}
