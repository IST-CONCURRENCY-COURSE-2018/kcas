package kcas;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReferenceArray;

/**
 * Works similarly to {@link AtomicReferenceArray},
 * but supports 2-word CAS in addition.
 */
public class AtomicArray<T> {
    private final AtomicReferenceArray<T> a;

    AtomicArray(int length) {
        a = new AtomicReferenceArray<>(length);
    }

    // see `AtomicReferenceArray.set`
    void set(int index, T value) {
        a.set(index, value);
    }

    // see `AtomicReferenceArray.get`
    T get(int index) {
        return a.get(index);
    }

    // see `AtomicReferenceArray.compareAndSet`
    boolean cas(int index, T expected, T update) {
        return a.compareAndSet(index, expected, update);
    }

    // Performs 2-word CAS operation
    boolean cas2(int firstIndex, T firstExpected, T firstUpdate,
                 int secondIndex, T secondExpected, T secondUpdate) {
        // TODO implement me using k-CAS algorithm!
        // TODO Do not forget to update all other methods
        // TODO since your internal array can store descriptors.
        if (Objects.equals(a.get(firstIndex), firstExpected) && Objects.equals(a.get(secondIndex), secondExpected)) {
            a.set(firstIndex, firstUpdate);
            a.set(secondIndex, secondUpdate);
            return true;
        } else {
            return false;
        }
    }
}
