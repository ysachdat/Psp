// PassengerCar, наследник класса Vehicle и реализующий интерфейс Object
public class PassengerCar extends Vehicle implements Object {

    // Конструктор для создания объекта PassengerCar
    public PassengerCar(String brand, String engineType, int enginePower, double weight, double mileage) {
        super(brand, engineType, enginePower, weight, mileage);
    }

    // Реализация вывода Object
    @Override
    public void print() {
        System.out.println("Passenger car brand: " + getBrand());
    }
}
