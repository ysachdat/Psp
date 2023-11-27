
// Класс машинок
public class Car
{
    // Характеристики автомобиля
    private String brand;        // Марка
    private String engineType;   // Тип двигателя
    private int enginePower;     // Мощность двигателя
    private double weight;       // Вес
    private double mileage;      // Пробег

    // Конструктор для инициализации характеристик автомобиля
    // Параметры: brand, enginetype, enginepower, weight, milleage

    public Car(String brand, String engineType, int enginePower, double weight, double mileage)
    {
        this.brand = brand;
        this.engineType = engineType;
        this.enginePower = enginePower;
        this.weight = weight;
        this.mileage = mileage;
    }

    // Метод для получения марки автомобиля
    // Возвращает марку

    public String getBrand()
    {
        return brand;
    }
}
