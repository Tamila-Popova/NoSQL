import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //exercise 2, Cargo
        Dimentions dimentions = new Dimentions(20, 30, 40);
        CargoInformation firstDel = new CargoInformation(dimentions,
                50,
                "Shkolnaya street,25/3",
                true,
                987654321,
                true);
        CargoInformation copy = firstDel.setWeight(65);
        System.out.println(firstDel.toString());
        System.out.println(" ");
        System.out.println(copy.toString());


        //exercise 1, Elevator
        System.out.println("\n");
        Elevator elevator = new Elevator(-3, 26);
        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);
        }

    }
}