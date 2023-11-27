// Грузовой автомобиль, наследуем от car
public class Truck extends Car
{

    private double loadCapacity;    // Грузоподъемность
    private String bodyType;        // Тип кузова

    // Конструктор для инициализации. Параметры + грозоподьемность, тип кузова

    public Truck(String brand, String engineType, int enginePower, double weight, double mileage, double loadCapacity, String bodyType)
    {
        super(brand, engineType, enginePower, weight, mileage);
        this.loadCapacity = loadCapacity;
        this.bodyType = bodyType;
    }

    // Переопределенный метод для получения марки
    @Override
    public String getBrand()
    {
        return "Truck " + super.getBrand();
    }
}
