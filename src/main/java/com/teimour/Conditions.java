// SPDX-License-Identifier: MIT

package com.teimour;

/**
 * @author kebritam
 * Project checksy
 */

public class Conditions {

    public static <T> T checkNotNull(T object) {
        if (object == null) {
            throw new NullPointerException();
        }
        return object;
    }

    public static <T> T checkNotNull(T object, String nullMessage) {
        if (object == null) {
            throw new NullPointerException(nullMessage);
        }
        return object;
    }

    public static <T> T[] checkNotNullElements(T[] array, String nullMessage) {
        checkNotNull(array, "array must not be null");
        for (T element : array) {
            checkNotNull(element, nullMessage);
        }
        return array;
    }

    public static <T> T[] checkNotNullElements(T[] array, int firstIndex, int lastIndex, String nullMessage) {
        checkNotNull(array, "array must not be null");
        if (lastIndex > array.length)
            throw new ArrayIndexOutOfBoundsException(lastIndex);

        for (int i = firstIndex; i <= lastIndex; i++) {
            checkNotNull(array[i], nullMessage);
        }
        return array;
    }

    public static <T> T[] checkNotWasteArray(T[] array) {
        checkNotNull(array, "array must not be null");
        if (array.length < 1) {
            throw new AssertionError("array is empty");
        }
        return array;
    }
}
