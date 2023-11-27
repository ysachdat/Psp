// Car, наследник Vehicle и реализующий интерфейс Object
public class Car extends Vehicle implements Object {


    public Car(String brand, String engineType, int enginePower, double weight, double mileage) {
        super(brand, engineType, enginePower, weight, mileage);
    }


    @Override
    public void print() {
        System.out.println("Car brand: " + getBrand());
    }
}
