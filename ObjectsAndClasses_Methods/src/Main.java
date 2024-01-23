public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40, 50, 60);
        basket.print("Корзина");


        Arithmetic arithmetic = new Arithmetic(3, 5);
        arithmetic.sum();
        System.out.println("\n" + "Сумма чисел: " + arithmetic.sum());

        arithmetic.mul();
        System.out.println("Произведение чисел: " + arithmetic.mul());

        arithmetic.max();
        System.out.println("Большее число: " + arithmetic.max());

        arithmetic.min();
        System.out.println("Меньшее число: " + arithmetic.min());

    }
}
