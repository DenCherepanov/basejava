package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private Resume[] storage = new Resume[10_000];
    private int sizeStorage = 0;

    public void clear() {
        Arrays.fill(storage, 0, sizeStorage, null);
        sizeStorage = 0;
    }

    public void save(Resume resume) {
        int indexResume = getIndex(resume.getUuid());
        if (sizeStorage == storage.length) {
            System.out.println("Out of range!");
        } else if (indexResume > -1) {
            System.out.println(resume.getUuid() + " is already exists!");
        } else {
            storage[sizeStorage] = resume;
            sizeStorage++;
        }
    }

    public void update(Resume resume) {
        int indexResume = getIndex(resume.getUuid());
        if (indexResume == -1) {
            System.out.println(resume.getUuid() + " was not found!");
        } else {
            storage[indexResume] = resume;
        }
    }

    public Resume get(String uuid) {
        int indexResume = getIndex(uuid);
        if (indexResume == -1) {
            System.out.println(uuid + " was not found!");
            return null;
        }
        return storage[indexResume];
    }

    public void delete(String uuid) {
        int indexResume = getIndex(uuid);
        if (indexResume == -1) {
            System.out.println(uuid + " was not found!");
        } else {
            storage[indexResume] = storage[sizeStorage - 1];
            storage[sizeStorage - 1] = null;
            sizeStorage--;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, sizeStorage);
    }

    private int getIndex(String uuid) {
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
