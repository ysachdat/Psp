// Truck, наследие от Vehicle и реализация  Object
public class Truck extends Vehicle implements Object {


    public Truck(String brand, String engineType, int enginePower, double weight, double mileage) {
        super(brand, engineType, enginePower, weight, mileage);
    }

    // вывод из Object
    @Override
    public void print() {
        System.out.println("Truck brand: " + getBrand());
    }
}
