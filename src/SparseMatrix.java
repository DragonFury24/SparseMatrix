import java.util.LinkedList;

public class SparseMatrix<anyType> implements Matrixable<anyType> {

    private LinkedList<Cell<anyType>> list;
    private int numElements;
    private int numRows, numColumns;

    public SparseMatrix(int row, int col) {
        list = new LinkedList<>();
        numElements = 0;
        numRows = row;
        numColumns = col;
    }

    public void add(int r, int c, anyType x) {
        int tempKey = getKey(r, c);

        for (int i = 0; i < list.size(); i++) {
            if (tempKey < getKey(i)) {
                list.add(i, new Cell<anyType>(x, r, c));
                return;
            }
        }
        list.add(new Cell<anyType>(x, r, c));
        //find the key at r, c -> tempKey
        //traverse through each Cell of list
        //find key of current Cell - currKey
        //if curKey > tempKey
        //      add new Cell at that index
        //      end the method
        //if we finish and no cell was added
        //add cell to the end
    }

    public anyType get(int r, int c) {
        int tempKey = getKey(r, c);
        for (int i = 0; i < list.size(); i++) {
            if (tempKey == getKey(i))
                return (anyType) list.get(i).getValue();
        }
        return null;
//find the key at r, c -> tempKey
        //traverse through each Cell of list
        //find key of current Cell - currKey
        //if curKey == tempKey
        //
        //      return the oldValue
        //if we finish and no cell was added
        //add cell to the end
    }

    public anyType set(int r, int c, anyType x) {
        int tempKey = getKey(r, c);
        anyType oldValue = null;
        for (int i = 0; i < list.size(); i++) {
            if (tempKey == getKey(i)) {
                oldValue = (anyType) list.get(i).getValue();
                list.get(i).setValue(x);
            }
            return (anyType)oldValue;
        }
        list.add(new Cell<>(x, r, c));

        return get(r, c);

//find the key at r, c -> tempKey
        //traverse through each Cell of list
        //find key of current Cell - currKey
        //if curKey == tempKey
        //      change the value of that Cell at that index to x
        //      return the oldValue
        //if we finish and no cell was added
        //add cell to the end
    }

    private int getKey(int r, int c) {
        return (r * numColumns) + c;
    }

    private int getKey(int i) {
        return list.get(i).getRow() * numColumns + list.get(i).getCol();
    }

    public anyType remove(int r, int c) {
        int tempKey = getKey(r, c);
        anyType oldValue = null;
        for (int i = 0; i < list.size(); i++) {
            if (tempKey == getKey(i)) {
                oldValue = (anyType) list.get(i).getValue();
                list.remove(i);
            }
        }
        return oldValue != null ? (anyType)oldValue : null;
    }

    public int size() {
        return numElements;
    }

    public int numRows() {
        return numRows;
    }

    public int numColumns() {
        return numColumns;
    }

    public String toString() {
        return "";
    }
}
