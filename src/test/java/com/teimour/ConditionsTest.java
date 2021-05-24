// SPDX-License-Identifier: MIT

package com.teimour;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author kebritam
 * Project checksy
 */

public class ConditionsTest {

    private static final String SAMPLE_ERROR_MESSAGE = "errorMessage";
    private static final Integer[] cleanArray = new Integer[]{1, 2, 3, 4, 5, 6};
    private static final Object object = new Object();
    private static final Integer[] nullElementArray = new Integer[] {1, 2, 3, 4, null, 5, 6};

    @Test
    void shouldReturnExactObject() {
        Object reference = Conditions.checkNotNull(object);
        assertNotNull(reference);
        assertEquals(reference, object);

        reference = Conditions.checkNotNull(object, SAMPLE_ERROR_MESSAGE);
        assertEquals(object, reference);
    }

    @Test
    void shouldThrowNullPointerException() {
        Exception exception = assertThrows(NullPointerException.class, () -> Conditions.checkNotNull(null));
        assertNull(exception.getMessage());
    }

    @Test
    void shouldThrowNullPointerExceptionWithMessage() {
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> Conditions.checkNotNull(null, SAMPLE_ERROR_MESSAGE)
        );
        assertEquals(SAMPLE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowNullPointerExceptionForNullElement() {
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> Conditions.checkNotNullElements(nullElementArray, SAMPLE_ERROR_MESSAGE)
        );
        assertEquals(SAMPLE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldThrowNullPointerExceptionForNullArray() {
        String exceptionMessage = "array must not be null";
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> Conditions.checkNotNullElements(null, "exceptionMessage")
        );
        assertEquals(exceptionMessage, exception.getMessage());
    }

    @Test
    void shouldReturnExactArrayForCleanOnes() {
        assertEquals(cleanArray, Conditions.checkNotNullElements(cleanArray, SAMPLE_ERROR_MESSAGE));
    }

    @Test
    void shouldThrowArrayIndexOutOfBoundsExceptionForArrayLength() {
        assertThrows(
                ArrayIndexOutOfBoundsException.class,
                () -> Conditions.checkNotNullElements(nullElementArray, 5, 7, SAMPLE_ERROR_MESSAGE)
        );
    }

    @Test
    void shouldThrowNullPointerExceptionForNullElementWithIndices() {
        Exception exception = assertThrows(
                NullPointerException.class,
                () -> Conditions.checkNotNullElements(nullElementArray, 1, 4, SAMPLE_ERROR_MESSAGE)
        );
        assertEquals(SAMPLE_ERROR_MESSAGE, exception.getMessage());
    }

    @Test
    void shouldReturnExactArrayFromNotNullElementWithIndices() {
        assertEquals(cleanArray, Conditions.checkNotNullElements(cleanArray, 0, 3, SAMPLE_ERROR_MESSAGE));
    }

    @Test
    void shouldReturnExactArrayFromNotWasteArray() {
        assertEquals(cleanArray, Conditions.checkNotWasteArray(cleanArray));
    }

    @Test
    void shouldThrowAssertionErrorFromNotWasteArray() {
        Integer[] intArray = {};
        assertThrows(AssertionError.class, () -> Conditions.checkNotWasteArray(intArray));
    }

}
