// Интерфейс Transport с методами для получения характеристик
public interface Transport {
    String getBrand();         // Получение марки
    String getEngineType();    // Типа двигателя
    int getEnginePower();      // Мощности двигателя
    double getWeight();        // Веса
    double getMileage();       // Пробега
}
