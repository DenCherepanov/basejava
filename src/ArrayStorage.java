/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int SizeStorage = 0;

    void clear() {
        if (SizeStorage > 0) {
            for (int i = 0; i < SizeStorage; i++) {
                storage[i] = null;
            }
            SizeStorage = 0;
        }
    }

    void save(Resume r) {
        storage[SizeStorage] = r;
        SizeStorage++;
    }

    Resume get(String uuid) {
        if (SizeStorage > 0) {
            for (int i = 0; i < SizeStorage; i++) {
                if (storage[i].uuid == uuid) {
                    return storage[i];
                }
            }
        }
        return null;
    }

    void delete(String uuid) {
        if (SizeStorage > 0) {
            for (int i = 0; i < SizeStorage; i++) {
                if (storage[i].uuid == uuid) {
                    storage[i] = storage[SizeStorage - 1];
                    storage[SizeStorage - 1] = null;
                    SizeStorage--;
                    break;
                }
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        if (SizeStorage > 0) {
            Resume[] new_storage = new Resume[SizeStorage];
            for (int i = 0; i < SizeStorage; i++) {
                new_storage[i] = storage[i];
            }
            return new_storage;
        } else {
            return new Resume[0];
        }
    }

    int size() {
        return SizeStorage;
    }
}
