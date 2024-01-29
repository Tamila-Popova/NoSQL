public class Screen {
    public final int diagonal;
    private final TypeScreen typeScreen;
    public final double weightScreen;

    public Screen(int diagonal, TypeScreen typeScreen, double weightScreen) {
        this.diagonal = diagonal;
        this.typeScreen = typeScreen;
        this.weightScreen = weightScreen;
    }
    public int getDiagonal(){
        return diagonal;
    }public TypeScreen getTypeScreen(){
        return typeScreen;
    }public double getWeightScreen(){
        return weightScreen;
    }
    public String toString(){
        return "\n" + "Диагональ: " + getDiagonal() +
                "\n" + "Тип: " + getTypeScreen() +
                "\n" + "Вес: " + getWeightScreen();
    }
}
