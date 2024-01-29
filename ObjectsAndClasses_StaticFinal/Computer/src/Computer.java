public class Computer {

    private Processor processor;
    private RAM ram;
    private Storage storage;
    private Screen screen;
    private Keyboard keyboard;
    public final String vendor;
    public final String name;


    private Computer(String vendor, String name){
        this.vendor = vendor;
        this.name = name;
    }

    public int totalWeight(){
        return Processor.weightProcessor() + RAM.weightRAM + Storage.weightStorage + Screen.weightScreen + Keyboard.weightKeyboard;
    }
}



