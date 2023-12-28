package ex6;

import java.util.HashMap;
import java.util.Map;

public class DictionaryExample {

    public static void main(String[] args) {
        // Создание словаря
        Map<String, String> dictionary = new HashMap<>();

        // Добавление пар ключ-значение
        dictionary.put("apple", "яблоко");
        dictionary.put("car", "машина");
        dictionary.put("house", "дом");

        // Получение значения по ключу
        String translation = dictionary.get("apple");
        System.out.println("Перевод слова apple: " + translation);

        // Проверка наличия ключа в словаре
        boolean containsKey = dictionary.containsKey("car");
        System.out.println("Словарь содержит ключ car: " + containsKey);

        // Проверка наличия значения в словаре
        boolean containsValue = dictionary.containsValue("дом");
        System.out.println("Словарь содержит значение дом: " + containsValue);

        // Удаление элемента по ключу
        dictionary.remove("house");

        // Проверка размера словаря
        int size = dictionary.size();
        System.out.println("Размер словаря: " + size);

        // Перебор всех элементов словаря
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println("Ключ: " + key + ", Значение: " + value);
        }
    }
}