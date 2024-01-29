public class Main {

    public static void main(String[] args) {
        Basket basket = new Basket();
        basket.add("Milk", 40, 50);
        basket.add("Coffee", 20, 40, 50);
        basket.add("Sugar", 30, 40, 40);
        basket.print("Корзина");
        double totalWeihgt = basket.getTotalWeight();
        System.out.println("Общий вес товаров: " + basket.getTotalWeight());
        Basket basket1 = new Basket();
        basket1.add("Milk", 40, 50);
        basket1.add("Coffee", 20, 40, 50);
        basket1.add("Sugar", 30, 40, 40);
        basket1.print("Корзина 1");
        double totalWeihgt1 = basket1.getTotalWeight();
        System.out.println("Общий вес товаров: " + basket1.getTotalWeight());
        Basket basket2 = new Basket();
        basket2.add("Milk", 40, 50);
        basket2.add("Coffee", 20, 40, 50);
        basket2.add("Sugar", 30, 40, 40);
        basket2.print("Корзина 2");
        double totalWeihgt2 = basket2.getTotalWeight();
        System.out.println("Общий вес товаров: " + basket2.getTotalWeight());

        System.out.println("Общее количество товаров в корзинах: " + Basket.getAllBasketsCount());
        System.out.println("Общая стоимость товаров в корзинах: " + Basket.getAllBasketsPrice());
        System.out.println("Средняя стоимость товара: " + Basket.averagePriceProduct());
        System.out.println("Средняя стоимость корзины: " + Basket.averageCostBasket());


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
