public class Main {
    public static void main(String[] args) {
        Processor proc1 = new Processor(13, 5, ManufacturerProc.INTEL, 6);
        RAM ram1 = new RAM(TypeRAM.DDR, 15, 340);
        Storage stor1 = new Storage(TypeStorage.HDD, 12, 45);
        Screen scr1 = new Screen(15, TypeScreen.TN, 120);
        Keyboard key1 = new Keyboard(TypeKeyboard.WIRED, true, 40);
        Computer comp1 = new Computer(VendorComputer.APPLE, Name.MacBook, proc1, ram1, stor1, scr1, key1);

        Processor proc2 = new Processor(14, 6, ManufacturerProc.AMD, 10);
        RAM ram2 = new RAM(TypeRAM.SDR, 25, 15);
        Storage stor2 = new Storage(TypeStorage.SSD, 8, 55);
        Screen scr2 = new Screen(17, TypeScreen.VA, 50);
        Keyboard key2 = new Keyboard(TypeKeyboard.WIRELESS, true, 50);
        Computer comp2 = new Computer(VendorComputer.HUAWEI, Name.MateBook, proc2, ram2, stor2, scr2, key2);

        System.out.println("Компьютер 1: " + comp1 + "\n");
        System.out.println("Компьютер 2: " + comp2);
    }
}