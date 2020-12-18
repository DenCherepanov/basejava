package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage{

    @Override
    protected int getIndex(String uuid) {
        Resume searchKey = new Resume();
        searchKey.setUuid(uuid);
        return Arrays.binarySearch(storage, 0, size, searchKey);
    }

    @Override
    protected void addResume(Resume r, int index) {
        int insIndex = - index - 1;
        System.arraycopy(storage, insIndex, storage, insIndex + 1, size - insIndex);
        storage[insIndex] = r;
    }

    @Override
    protected void reduceResume(int index) {
        int cntMove = size - index - 1;
        if (cntMove > 0) {
            System.arraycopy(storage, index + 1, storage, index, cntMove);
        }
    }
}
