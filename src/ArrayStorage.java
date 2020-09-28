/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];
    private int count_storage = storage.length;

    void clear() {
        for (int i = 0; i < count_storage - 1; i++) {
            if (storage[i] != null) {
                storage[i] = null;
            } else {
                break;
            }
        }
    }

    void save(Resume r) {
        for (int i = 0; i < count_storage - 1; i++) {
            if (storage[i] == null) {
                storage[i] = r;
                break;
            }
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < count_storage - 1; i++) {
            if (storage[i] != null) {
                if (storage[i].uuid == uuid) {
                    return storage[i];
                }
            } else {
                break;
            }
        }
        return null;
    }

    void delete(String uuid) {
        int last_resume = -1;
        int del_resume = -1;
        for (int i = 0; i < count_storage - 1; i++) {
            if (storage[i] != null) {
                last_resume = i;
            } else {
                break;
            }
            if (storage[i].uuid == uuid) {
                del_resume = i;
            }
        }
        if (last_resume > -1 & del_resume > -1) {
            storage[del_resume] = storage[last_resume];
            storage[last_resume] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int size_resume = -1;
        for (int i = 0; i < count_storage - 1; i++) {
            if (storage[i] != null) {
                size_resume = i + 1;
            } else {
                break;
            }
        }
        if (size_resume != -1) {
            Resume[] new_storage = new Resume[size_resume];
            for (int i = 0; i < size_resume; i++) {
                new_storage[i] = storage[i];
            }
            return new_storage;
        } else {
            return new Resume[0];
        }
    }

    int size() {
        int size_resume = -1;
        for (int i = 0; i < count_storage - 1; i++) {
            if (storage[i] != null) {
                size_resume = i;
            } else {
                break;
            }
        }
        if (size_resume != -1) {
            return size_resume + 1;
        } else {
            return 0;
        }
    }
}
