public class Keyboard {
    public final TypeKeyboard typeKeyboard;
    public final boolean backlight;
    public final double weightKeyboard;

    public Keyboard(TypeKeyboard typeKeyboard, boolean backlight, double weightKeyboard) {
        this.typeKeyboard = typeKeyboard;
        this.backlight = backlight;
        this.weightKeyboard = weightKeyboard;
    }
    public TypeKeyboard getTypeKeyboard(){
        return typeKeyboard;
    }public boolean getBacklight(){
        return backlight;
    }public double getWeightKeyboard(){
        return weightKeyboard;
    }
    public String toString(){
        return "\n" + "Тип: " + getTypeKeyboard() +
                "\n" + "Наличие подсветки: " + getBacklight() +
                "\n" + "Вес: " + getWeightKeyboard();
    }
}
