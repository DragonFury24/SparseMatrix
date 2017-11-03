public class Cell<anyType> {
    private anyType value;
    private int row;
    private int col;

    public Cell(anyType v, int r, int c) {
        row = r;
        col = c;
        value = v;
    }

    public void setValue(anyType v) {
        value = v;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public anyType getValue() {
        return value;
    }
}
