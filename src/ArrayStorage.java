/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    void clear() {
        for (int i = 0; i < sizeStorage; i++) {
            storage[i] = null;
        }
        sizeStorage = 0;
    }

    void save(Resume r) {
        storage[sizeStorage] = r;
        sizeStorage++;
    }

    Resume get(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid == uuid) {
                return storage[i];
            }
        }
        return null;
    }

    void delete(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].uuid == uuid) {
                storage[i] = storage[sizeStorage - 1];
                storage[sizeStorage - 1] = null;
                sizeStorage--;
                break;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[sizeStorage];
        for (int i = 0; i < sizeStorage; i++) {
            resumes[i] = storage[i];
        }
        return resumes;
    }

    int size() {
        return sizeStorage;
    }
}
