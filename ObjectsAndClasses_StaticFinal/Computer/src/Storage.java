public class Storage {
    public final TypeStorage typeStorage;
    public final int memoryVolume;
    public final double weightStorage;

    public Storage(TypeStorage typeStorage, int memoryVolume, double weightStorage) {
        this.typeStorage = typeStorage;
        this.memoryVolume = memoryVolume;
        this.weightStorage = weightStorage;
    }
    public TypeStorage getTypeStorage(){
        return typeStorage;
    }public int getMemoryVolume(){
        return memoryVolume;
    }public double getWeightStorage(){
        return weightStorage;
    }
    public String toString(){
        return "\n" + "Тип: " + getTypeStorage() +
                "\n" + "Объём: " + getMemoryVolume() +
                "\n" + "Вес: " + getWeightStorage();
    }
}
