package com.zipcodewilmington.looplabs;

import java.util.Arrays;

/**
 * Created by leon on 1/25/18.
 */
public abstract class DuplicateDeleter<T> implements DuplicateDeleterInterface<T> {
    protected T[] array;

    public DuplicateDeleter(T[] intArray) {
        this.array = intArray;
    }

    public Integer numberOfOccurrences(T number) {
        Integer count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == number) {
                count++;

            }
        } return count;
    }

    @Override
    public T[] removeDuplicates(Integer numberOfDuplications) {
        T[] intArray = array;
        T[] newArray = array.clone();
        int newLength = 0;
        for (T arrayElement : array) {
            Integer numberOfOccurrences = numberOfOccurrences(arrayElement);
            if (!(numberOfOccurrences >= numberOfDuplications)) {
                newArray[newLength] = arrayElement;
                newLength++;
            }
        }
        return Arrays.copyOfRange(newArray, 0, newLength);
    }


    @Override
    public T[] removeDuplicatesExactly(Integer exactNumberOfDuplications) {
        T[] intArray = array;
        T[] newArray = array.clone();
        int newLength = 0;
        for (T arrayElement : array) {
            Integer numberOfOccurrences = numberOfOccurrences(arrayElement);
            if (!(numberOfOccurrences == exactNumberOfDuplications)) {
                newArray[newLength] = arrayElement;
                newLength++;
            }
        }
        return Arrays.copyOfRange(newArray, 0, newLength);
    }
}
