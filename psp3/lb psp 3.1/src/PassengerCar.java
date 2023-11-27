// Класс легкового автомобиля, наследуем от car
public class PassengerCar extends Car
{
    // Дополнительные хар-ки
    private double fuelConsumption;    // Расход fuel
    private double accelerationTime;    // Время разгона

    // Конструктор для инициализации характеристик. Параметры +- такие же, только добавляется расход и время

    public PassengerCar(String brand, String engineType, int enginePower, double weight, double mileage, double fuelConsumption, double accelerationTime) {
        super(brand, engineType, enginePower, weight, mileage);
        this.fuelConsumption = fuelConsumption;
        this.accelerationTime = accelerationTime;
    }

    // Переопределение метода для получения марки, который возвращает марку

    @Override
    public String getBrand()
    {
        return "Passenger Car " + super.getBrand();
    }
}
