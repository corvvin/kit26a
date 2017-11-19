package ua.khpi.oop.malokhvii05.common.algorithms.search;

import java.util.Comparator;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.Signed;

/**
 * Абстрактний клас, призначений для об'єднання усіх алгоритмів пошуку в
 * діапазоні під єдиною реалізацією.
 *
 * @author malokhvii-eduard (malokhvii.ee@gmail.com)
 * @version 1.0.0
 * @param <T>
 *            Тип даних, елементів діапазону та елемента для пошуку
 */
public abstract class AbstractSearchInRangeAlgorithm<T> extends
        AbstractSearchAlgorithm<T> implements SearchInRangeAlgorithm<T> {

    /**
     * Призначений, для ініціалізації об'єкту компаратором для подільшого
     * обчислення.
     *
     * @param comparator
     *            компаратор для порівння під час сорутвання
     * @since 1.0.0
     */
    public AbstractSearchInRangeAlgorithm(
            @Nonnull final Comparator<T> comparator) {
        super(comparator);
    }

    /**
     * Призначений, для перевірки на коректність вхідного діапазону, чи не
     * виходить він за границі масиву або ліва границя більша за праву гарницю.
     *
     * @param array
     *            вхідний масив
     * @param left
     *            ліва границя діапазону
     * @param right
     *            права границя діапазону
     * @return результат перевірки вхідного діапазону
     * @since 1.0.0
     */
    protected final boolean isValidRange(@Nonnull final T[] array,
            @Nonnegative final int left, @Nonnegative final int right) {
        boolean isValidRange = true;
        if (right < left) {
            isValidRange = false;
        } else if (right > array.length) {
            isValidRange = false;
        } else if (left < 0) {
            isValidRange = false;
        }
        indexNotFound();
        return isValidRange;
    }

    @Override
    public final @Signed int search(@Nonnull final T[] array,
            @Nullable final T value) {
        return this.search(array, value, 0, array.length);
    }
}
