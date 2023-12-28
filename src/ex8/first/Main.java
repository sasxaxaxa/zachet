package ex8.first;
import java.util.LinkedList;

// Пример реализации хэш-функции
class HashFunction {
    static int getHash(String key, int tableSize) {
        int hash = 0;
        for (int i = 0; i < key.length(); i++) {
            hash = (hash + key.charAt(i)) % tableSize;
        }
        return hash;
    }
}

// Пример реализации хеш-таблицы
class HashTable {
    private LinkedList<String>[] table;
    private int size;

    HashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            table[i] = new LinkedList<>();
        }
    }

    void put(String key, String value) {
        int index = HashFunction.getHash(key, size);
        LinkedList<String> list = table[index];
        list.add(value);
    }

    String get(String key) {
        int index = HashFunction.getHash(key, size);
        LinkedList<String> list = table[index];
        for (String value : list) {
            if (value.equals(key)) {
                return value;
            }
        }
        return null;
    }
}

// Пример использования хеш-таблицы
public class Main {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);
        hashTable.put("apple", "fruit");
        hashTable.put("carrot", "vegetable");

        System.out.println(hashTable.get("apple"));   // Выводит "fruit"
        System.out.println(hashTable.get("carrot"));  // Выводит "vegetable"
        System.out.println(hashTable.get("banana"));  // Выводит null
    }
}