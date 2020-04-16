import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    int indexArray;

    void clear() {
        if(indexArray == 0) {
            storage[indexArray] = null;
        } else {
            Arrays.fill(storage, 0, indexArray - 1, 0);
        }
    }

    void save(Resume r) {
        storage[indexArray] = r;
        indexArray++;
    }

    Resume get(String uuid) {
        for(int i = 0; i < indexArray-1; i++) {
            if(storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        System.out.println("Резюме не найдено");
        return null;
    }

    void delete(String uuid) {
        for(int i = 0; i < indexArray-1; i++) {
            if(storage[i].uuid ==uuid) {
                storage[i] = null;
                Resume[] tempArr = new Resume[storage.length-1];
                System.arraycopy(storage,0,tempArr,0,i-1);
                System.arraycopy(storage,i+1,tempArr,i-1,indexArray-1);
                storage =tempArr;
            }

        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if(indexArray == 0){
            return null;
        }
        return Arrays.copyOf(storage, indexArray-1);
    }

    int size() {
        if(indexArray == 0) {
            return 0;
        }
        return indexArray-1;
    }
}
