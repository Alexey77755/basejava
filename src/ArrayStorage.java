import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int indexArray;

    void clear() {
        Arrays.fill(storage, 0, indexArray - 1, null);
        indexArray = 0;
    }

    void save(Resume r) {
        if (r == null) {
            System.out.println("Нет резюме для сохранения");
        } else {
            storage[indexArray] = r;
            indexArray++;
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < indexArray; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        System.out.println("Резюме не найдено");
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < indexArray; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = null;
                Resume[] tempArr = new Resume[storage.length];
                System.arraycopy(storage, 0, tempArr, 0, i);
                System.arraycopy(storage, i + 1, tempArr, i, (indexArray - 1) - i);
                storage = tempArr;
                indexArray--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (indexArray == 0) {
            return new Resume[0];
        }
        return Arrays.copyOf(storage, indexArray);
    }

    int size() {
        return indexArray;
    }
}
