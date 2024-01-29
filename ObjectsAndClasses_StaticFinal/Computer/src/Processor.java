public class Processor {
    public final double frequency;
    public final int numberOfCores;
    public final ManufacturerProc manufacturer;
    public final double weightProcessor;

    public Processor(double frequency, int numberOfCores, ManufacturerProc manufacturer, double weightProcessor) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weightProcessor = weightProcessor;
    }
    public double getFrequency(){
        return frequency;
    }public int getNumberOfCores(){
        return numberOfCores;
    }public ManufacturerProc getManufacturer(){
        return manufacturer;
    }
    public double getWeightProcessor(){
        return weightProcessor;
    }

    public String toString(){
        return "\n" + "Частота: " + getFrequency() +
                "\n" + "Количество ядер: " + getNumberOfCores() +
                "\n" + "Производитель: " + getManufacturer() +
                "\n" + "Вес: " + getWeightProcessor();
    }


}
