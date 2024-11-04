
public class IntegerSet {
    private boolean[] iSet;

    IntegerSet() {
        this.iSet = new boolean[101];
        for (int i = 0; i < 101; i++) {
            this.iSet[i] = false;
        }
    }

    public IntegerSet union(IntegerSet iSet) {
        IntegerSet unionInt = new IntegerSet();

        for (int i = 0; i < 101; i++) {
            if (iSet.iSet[i] == true || this.iSet[i] == true) {
                unionInt.iSet[i] = true;
            }
        }

        return unionInt;
    }

    public IntegerSet intersection(IntegerSet iSet) {
        IntegerSet interInt = new IntegerSet();

        for (int i = 0; i < 101; i++) {
            if (iSet.iSet[i] == true && this.iSet[i] == true) {
                interInt.iSet[i] = true;
            }
        }

        return interInt;
    }

    public IntegerSet insertElement(int data) {
        this.iSet[data] = true;

        return this;
    }

    public IntegerSet deleteElement(int data) {
        this.iSet[data] = false;

        return this;
    }

    public boolean isEqualTo(IntegerSet iSet) {
        for (int i = 0; i < 101; i++) {
            if (iSet.iSet[i] != this.iSet[i]) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        String returnedString = new String();
        int count = 0;
        for (int i = 0; i < 101; i++) {
            if (this.iSet[i] == true) {
                count++;
                if (count <= 1) {
                    returnedString = Integer.toString(i);
                } else if (count > 1) {
                    returnedString = returnedString + ' ' + Integer.toString(i);
                }
            }
        }

        if (count == 0) {
            returnedString = "---";
        }

        return returnedString;
    }
}