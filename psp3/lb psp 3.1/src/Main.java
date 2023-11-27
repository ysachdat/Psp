// Основной класс с методом main для использования классов автомобилей
public class Main
{
    public static void main(String[] args)
    {
        // Экземпляра  Car
        Car car = new Car("Toyota", "Petrol", 150, 1200.0, 50000.0);
        System.out.println("Car brand: " + car.getBrand());

        // Экземпляра  PassengerCar
        PassengerCar passengerCar = new PassengerCar("Honda", "Petrol", 200, 1400.0, 30000.0, 7.5, 8.5);
        System.out.println("Passenger car brand: " + passengerCar.getBrand());

        //  Экземпляра  Truck
        Truck truck = new Truck("Volvo", "Diesel", 300, 8000.0, 100000.0, 10.0, "Closed");
        System.out.println("Truck brand: " + truck.getBrand());

        // Экземпляра Bus
        Bus bus = new Bus("Mercedes", "Diesel", 250, 9500.0, 60000.0, 12.0, 15.0, 40);
        System.out.println("Bus brand: " + bus.getBrand());
    }
}
