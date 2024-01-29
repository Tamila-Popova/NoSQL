public class RAM {
    public final TypeRAM typeRAM;
    public final int volume;
    public final double weightRAM;

    public RAM(TypeRAM typeRAM, int volume, double weightRAM) {
        this.typeRAM = typeRAM;
        this.volume = volume;
        this.weightRAM = weightRAM;
    }

    public TypeRAM getTypeRAM(){
        return typeRAM;
    }public int getVolume(){
        return volume;
    }public double getWeightRAM(){
        return weightRAM;
    }
    public String toString(){
        return "\n" + "Тип: " + getTypeRAM() +
                "\n" + "Объём: " + getVolume() +
                "\n" + "Вес: " + getWeightRAM();
    }

}
