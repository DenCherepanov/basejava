package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10000];
    private int sizeStorage = 0;

    public void clear() {
        Arrays.fill(storage, 0, sizeStorage, null);
        /**
         * First implementation of the method
         for (int i = 0; i < sizeStorage; i++) {
         storage[i] = null;
         }
         */
        sizeStorage = 0;
    }

    public void save(Resume r) {
        if (sizeStorage == 10000) {
            System.out.println("Out of range!");
        } else if (getIndexArray(r.getUuid()) > -1) {
            System.out.println("This uuid already exists!");
        } else {
            storage[sizeStorage] = r;
            sizeStorage++;
        }
    }

    public void update(Resume r) {
        if (getIndexArray(r.getUuid()) == -1) {
            System.out.println("This uuid was not found!");
        } else {
            storage[getIndexArray(r.getUuid())].setUuid(r.getUuid().concat("0"));
        }
    }

    public Resume get(String uuid) {
        if (getIndexArray(uuid) == -1) {
            System.out.println("This uuid was not found!");
        } else {
            return storage[getIndexArray(uuid)];
        }
        return null;
    }

    public void delete(String uuid) {
        if (getIndexArray(uuid) == -1) {
            System.out.println("This uuid was not found!");
        } else {
            storage[getIndexArray(uuid)] = storage[sizeStorage - 1];
            storage[sizeStorage - 1] = null;
            sizeStorage--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[sizeStorage];
        resumes = Arrays.copyOfRange(storage, 0, sizeStorage);
        /**
         * First implementation of the method
         for (int i = 0; i < sizeStorage; i++) {
         resumes[i] = storage[i];
         }
         */
        return resumes;
    }

    private int getIndexArray(String uuid) {
        for (int i = 0; i < sizeStorage; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return sizeStorage;
    }
}
