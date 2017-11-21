package ua.khpi.oop.malokhvii05.common.algorithms.sort;

import javax.annotation.Nonnegative;
import javax.annotation.Nonnull;

import ua.khpi.oop.malokhvii05.common.algorithms.AlgorithmWithComparator;

/**
 * Ітерфейс, призначений для оголошення алгоритму сортування для масиву. Усі
 * алгоритми базуються на порівнянні. Інші алгоритми не розглядаються.
 *
 * @author malokhvii-eduard (malokhvii.ee@gmail.com)
 * @version 1.0.0
 * @param <T>
 *            Тип даних, елементів масиву для сортування
 */
public interface SortAlgorithm<T> extends AlgorithmWithComparator<T> {

    /**
     * Призначений, для отримання поточного стану компаратора, тобто чи
     * обернений порядок сортування.
     *
     * @return порядок сортування обернений
     * @since 1.0.0
     */
    boolean isReversedOrder();

    /**
     * Призначений, для оновлення поточного порядку сортування за допомогою
     * методу {@link java.util.Comparator#reversed}.
     *
     * @param isReversedOrder
     *            новий порядок сортування
     * @since 1.0.0
     */
    void setReversedOrder(boolean isReversedOrder);

    /**
     * Призначений, для сотування вхідного масиву.
     *
     * @param array
     *            вхідний масив для сорутвання
     * @return результат операції сортування
     * @since 1.0.0
     */
    boolean sort(@Nonnull T[] array);

    /**
     * Призначений, для сотування вхідного масиву, з конкретною довжиною.
     *
     * @param array
     *            вхідний масив для сорутвання
     * @param length
     *            довжина фрагменту масиву для сортування
     * @return результат операції сортування
     * @since 1.0.0
     */
    boolean sort(@Nonnull T[] array, @Nonnegative int length);
}
