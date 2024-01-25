public class CargoInformation {
    private final Dimentions dimentions;
    private final double weight;
    private final String deliveryAddress;
    private final boolean turnOver;
    private final int registrationNumber;
    private final boolean fragileCargo;

    public CargoInformation(Dimentions dimentions,
                            double weight,
                            String deliveryAddress,
                            boolean turnOver,
                            int registrationNumber,
                            boolean fragileCargo) {
        this.dimentions = dimentions;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.turnOver = turnOver;
        this.registrationNumber = registrationNumber;
        this.fragileCargo = fragileCargo;
    }

    public CargoInformation setDimensions(Dimentions dimensions) {
        return new CargoInformation(dimensions, weight, deliveryAddress, turnOver, registrationNumber, fragileCargo);
    }

    public Dimentions getDimentions() {
        return dimentions;
    }

    public CargoInformation setWeight(double weight) {
        return new CargoInformation(dimentions, weight, deliveryAddress, turnOver, registrationNumber, fragileCargo);
    }

    public double getWeight() {
        return weight;
    }

    public CargoInformation setDeliveryAddress(String deliveryAddress) {
        return new CargoInformation(dimentions, weight, deliveryAddress, turnOver, registrationNumber, fragileCargo);
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public CargoInformation setTurnOver(boolean turnOver) {
        return new CargoInformation(dimentions, weight, deliveryAddress, turnOver, registrationNumber, fragileCargo);
    }

    public boolean getTurnOver() {
        return turnOver;
    }

    public CargoInformation setRegistrationNumber(int registrationNumber) {
        return new CargoInformation(dimentions, weight, deliveryAddress, turnOver, registrationNumber, fragileCargo);
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public CargoInformation setFragileCargo(boolean fragileCargo) {
        return new CargoInformation(dimentions, weight, deliveryAddress, turnOver, registrationNumber, fragileCargo);
    }

    public boolean getFragileCargo() {
        return fragileCargo;
    }

    public String toString() {
        return "Информация о грузе: " + "\n" + "Габариты: " + getDimentions() + "\n" + "Вес: " + getWeight() + "\n" + "Адрес доставки: " + getDeliveryAddress() + "\n" + "Можно ли переворачивать: " + getTurnOver() + "\n" + "Регистрационный номер: " + getRegistrationNumber() + "\n" + "Хрупкий ли товар: " + getFragileCargo();
    }
}
