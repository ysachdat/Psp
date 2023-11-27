// Класс автобусов, наследует от PassengerCar
public class Bus extends PassengerCar
{

    private int numberOfSeats;

    //
    public Bus(String brand, String engineType, int enginePower, double weight, double mileage, double fuelConsumption, double accelerationTime, int numberOfSeats)
    {
        super(brand, engineType, enginePower, weight, mileage, fuelConsumption, accelerationTime);
        this.numberOfSeats = numberOfSeats;
    }

    // Переопределенный метод для получения марки автобуса. Возвращает марку автобуса

    @Override
    public String getBrand()
    {
        return "Bus " + super.getBrand();
    }
}
