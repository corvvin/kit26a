package ua.khpi.oop.malokhvii05.common.algorithms.search;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.annotation.Signed;

import ua.khpi.oop.malokhvii05.common.algorithms.AlgorithmWithComparator;

/**
 * Ітерфейс, призначений для оголошення алгоритму пошуку у масиві. Усі алгоритми
 * базуються на порівнянні. Інші алгоритми не розглядаються.
 *
 * @author malokhvii-eduard (malokhvii.ee@gmail.com)
 * @version 1.0.0
 * @param <T>
 *            Тип даних, елементів масиву та елемента для пошуку
 */
public interface SearchAlgorithm<T> extends AlgorithmWithComparator<T> {

    /**
     * Індекс елементу, якщо у результаті пошуку елемент не знайдено.
     */
    int INDEX_NOT_FOUND = -1;

    /**
     * Призначений, для отримання останнього індексу який було знайдено за
     * допомогою алгоритму.
     *
     * @return останній індекс, який було знайдено за допомгою алгоритму
     * @since 1.0.0
     */
    @Signed
    int getLastFoundIndex();

    /**
     * Призначений, для пошуку значення в вхідному масиві.
     *
     * @param array
     *            вхідний масив
     * @param value
     *            значення для пошуку
     * @return індекс знайдего значення, або якщо значення не знайдено тоді
     *         {@link SearchAlgorithm#INDEX_NOT_FOUND}.
     * @since 1.0.0
     */
    @Signed
    int search(@Nonnull T[] array, @Nullable T value);
}
