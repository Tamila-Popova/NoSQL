public class Dimentions {
    private final double width;
    private final double height;
    private final double length;

    public Dimentions(double width, double height, double length) {
        this.width = width;
        this.height = height;
        this.length = length;
    }
    public double getWidth(){
        return width;
    }
    public double getHeight(){
        return height;
    }
    public double getLength(){
        return length;
    }
    public double getVolume() {
        return width * height * length;
    }
    public String toString() {
        return "Ширина:" + width + "\n" + "Высота:" + height + "\n" + "Длина:" + length + "\n" +
        "Объем груза:" + getVolume();
    }
}
