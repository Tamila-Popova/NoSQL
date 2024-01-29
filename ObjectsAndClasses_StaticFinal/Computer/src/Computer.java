public class Computer {

    private Processor processor;
    private RAM ram;
    private Storage storage;
    private Screen screen;
    private Keyboard keyboard;
    public final VendorComputer vendor;
    public final Name name;


    public Computer(VendorComputer vendor, Name name, Processor processor, RAM ram, Storage storage, Screen screen, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.screen = screen;
        this.keyboard = keyboard;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setRAM(RAM ram) {
        this.ram = ram;
    }

    public RAM getRAM() {
        return ram;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setScreen(Screen screen) {
        this.screen = screen;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public VendorComputer getVendor() {
        return vendor;
    }

    public Name getName() {
        return name;
    }

    public double getTotalWeightComputer() {
        return processor.getWeightProcessor() +
                ram.getWeightRAM() + storage.getWeightStorage() + screen.getWeightScreen() +
                keyboard.getWeightKeyboard();
    }

    public String toString() {
        return "\n" + "Производитель: " + getVendor() + "\n" + "Название: " + getName() +
                "\n" + "Процессор: " + getProcessor() + "\n" + "Оперативная память: " + getRAM() +
                "\n" + "Накопитель информации: " + getStorage() + "\n" + "Экран: " + getScreen() +
                "\n" + "Клавиатура: " + getKeyboard() + "\n" + "Вес всего компьютера: " + getTotalWeightComputer();
    }

}



