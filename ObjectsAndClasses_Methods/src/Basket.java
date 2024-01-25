public class Basket {

    private static int count = 0;
    private String items = "";
    private int totalPrice = 0;
    private int limit;
    private double totalWeight = 0;
    private int totalCount;
    private static int allBasketsPrice = 0;
    private static int allBasketsCount = 0;
    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public void add(String name, int price, int count, double weight) {
        add(name, price, count);
        totalWeight = totalWeight + count * weight;
    }

    public void add(String name, int price, int count) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }

        if (totalPrice + count * price >= limit) {
            error = true;
        }

        if (error) {
            System.out.println("Error occured :(");
            return;
        }

        items = items + "\n" + name + " - " +
                count + " шт. - " + price + "руб.";
setAllBasketsPrice(price);
setAllBasketsCount(count);
    }

    private int getTotalCount() {
        totalCount = totalCount + count;
        return totalCount;
    }

    public void clear() {
        items = "";
        totalPrice = 0;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
        }
    }
public static int getAllBasketsPrice(){
        return allBasketsPrice;
}
public static int getAllBasketsCount(){
        return allBasketsCount;
}

    public static void setAllBasketsPrice(int price){
       Basket.allBasketsPrice += price;
    }

    public static void setAllBasketsCount(int count){
        Basket.allBasketsCount +=count;
    }
public static double averagePriceProduct(){
        return (double) allBasketsPrice/allBasketsCount;
}

    public static double averageCostBasket(){
        return (double) allBasketsPrice/count;
    }
    public double getTotalWeight() {
        return totalWeight;
    }
}
