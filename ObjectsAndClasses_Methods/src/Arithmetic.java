public class Arithmetic {
    private int var1;
    private int var2;

    public Arithmetic(int var1, int var2) {
        this.var1 = var1;
        this.var2 = var2;
    }

    public int sum() {
        return var1 + var2;
    }

    public int mul() {
        return var1 * var2;
    }

    public int max() {
        if (var1 > var2) {
            return var1;
        } else {
            return var2;
        }
    }

    public int min() {
        if (var1 < var2) {
            return var1;
        } else {
            return var2;
        }
    }
}
