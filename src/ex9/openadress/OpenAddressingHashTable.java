package ex9.openadress;

public class OpenAddressingHashTable {
    private int size;
    private String[] table;
    private boolean[] isOccupied;

    public OpenAddressingHashTable(int size) {
        this.size = size;
        table = new String[size];
        isOccupied = new boolean[size];
    }

    private int hash(String key) {
        // Ваша функция хэширования
        // Например, можно использовать простое сложение кодов символов
        int hashValue = 0;
        for (int i = 0; i < key.length(); i++) {
            hashValue += key.charAt(i);
        }
        return hashValue % size;
    }

    public void insert(String key) {
        int index = hash(key);
        while (isOccupied[index]) {
            index = (index + 1) % size; // Метод линейного пробирования
        }
        table[index] = key;
        isOccupied[index] = true;
    }

    public boolean search(String key) {
        int index = hash(key);
        while (isOccupied[index]) {
            if (table[index].equals(key)) {
                return true;
            }
            index = (index + 1) % size; // Продолжаем пробирование, пока не найдем или не дойдем до пустой ячейки
        }
        return false;
    }

    public void delete(String key) {
        int index = hash(key);
        while (isOccupied[index]) {
            if (table[index].equals(key)) {
                table[index] = null;
                isOccupied[index] = false;
                return;
            }
            index = (index + 1) % size; // Продолжаем пробирование, пока не найдем или не дойдем до пустой ячейки
        }
    }
}