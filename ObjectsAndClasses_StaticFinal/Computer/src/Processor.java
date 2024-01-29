public class Processor {
    public final int frequency;
    public final int numberOfCores;
    public final String manufacturer;
    public final int weightProcessor = 0;

    public Processor(int frequency, int numberOfCores, String manufacturer, int weightProcessor) {
        this.frequency = frequency;
        this.numberOfCores = numberOfCores;
        this.manufacturer = manufacturer;
        this.weightProcessor = weightProcessor;
    }

    public void setWeightProcessor(int weightProcessor){
        this.weightProcessor = weightProcessor;
    }
}
