package ua.khpi.oop.malokhvii05.util.algorithms.sort;

import java.util.Comparator;

import ua.khpi.oop.malokhvii05.util.Array;

/**
 * <p>
 * Призначений, для реалізації алгоритму сортування вхідного масиву. Ключ у
 * фабриці алгоритмів - "top-down-merge-sort".
 * </p>
 * <p>
 * Сортування злиттям (англ. merge sort) — алгоритм сортування, в основі якого
 * лежить принцип «Розділяй та володарюй». В основі цього способу сортування
 * лежить злиття двох упорядкованих ділянок масиву в одну впорядковану ділянку
 * іншого масиву.
 * </p>
 * <p>
 * Злиття двох упорядкованих послідовностей можна порівняти з перебудовою двох
 * колон солдатів, вишикуваних за зростом, в одну, де вони також розташовуються
 * за зростом. Якщо цим процесом керує офіцер, то він порівнює зріст солдатів,
 * перших у своїх колонах і вказує, якому з них треба ставати останнім у нову
 * колону, а кому залишатися першим у своїй. Так він вчиняє, поки одна з колон
 * не вичерпається — тоді решта іншої колони додається до нової.
 * </p>
 * <ul>
 * <li>Назва: Merge Sort (Top-Down)</li>
 * <li>Автор: John von Neumann</li>
 * <li>Метод: Merging</li>
 * <li>Найкраща швидкодія: Ω(n log(n))</li>
 * <li>Середня швидкодія: Θ(n log(n))</li>
 * <li>Найгірша швидкодія: O(n log(n))</li>
 * <li>Просторова складність: O(n)</li>
 * <li>Стабільний: Так</li>
 * </ul>
 *
 * @author malokhvii-eduard
 * @version 1.0.0
 * @see SortAlgorithmFactory
 * @param <T>
 *            Тип даних, елементів масиву для сортування, та компаратору для
 *            порівняння елементів
 */
public final class TopDownMergeSort<T> extends AbstractSortAlgorithm<T> {

    /**
     * Поточний напрямок сортування, тобто обернений чи ні.
     */
    private boolean isReversed;

    static {
        SortAlgorithmFactory.registerAlgorithm("top-down-merge-sort",
                TopDownMergeSort.class);
        SortAlgorithmFactory.setDefaultAlgorithm(TopDownMergeSort.class);
    }

    /**
     * Пирзначений, для інійіалізації об'єкту компоратором для порівняння
     * вхідних даних.
     *
     * @param comparator
     *            компоратор для вхідних даних
     */
    public TopDownMergeSort(final Comparator<T> comparator) {
        super(comparator);
    }

    @Override
    public void sort(final Array<T> array) {
        Object[] arrayData = array.getData();
        Object[] sortedArrayData = mergeSort(array.toArray());
        System.arraycopy(sortedArrayData, 0, arrayData, 0,
                arrayData.length - (arrayData.length - array.size()));
    }

    /**
     * Призначений, для рекурсивного розділення масиву на рівні частини, та їх
     * сортування.
     *
     * @param array
     *            вхідний масив
     * @return відсортований масив
     */
    private Object[] mergeSort(final Object[] array) {
        if (array.length <= 1) {
            return array;
        }

        int middle = array.length >> 1;

        Object[] left = new Object[middle];
        Object[] right = new Object[array.length - middle];

        System.arraycopy(array, 0, left, 0, left.length);
        System.arraycopy(array, left.length, right, 0, right.length);

        left = mergeSort(left);
        right = mergeSort(right);

        return mergeSlices(left, right);
    }

    @Override
    public void setSortOrder(final Order sortOrder) {
        isReversed = isReversed(sortOrderToKey(sortOrder),
                INTERNAL_ASCENDING_KEY);
        super.setSortOrder(sortOrder);
    }

    /**
     * Призначений, для злиття двох фрагментів масиву.
     *
     * @param left
     *            лівий фрагмент
     * @param right
     *            правий фрагмент
     * @return об'єднаний масив, та відсортований
     */
    @SuppressWarnings("unchecked")
    private Object[] mergeSlices(final Object[] left, final Object[] right) {
        Object[] mergeBuffer = new Integer[left.length + right.length];

        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;
        while (leftIndex < left.length || rightIndex < right.length) {
            if (leftIndex < left.length && rightIndex < right.length) {
                if (isReversed == (comparator.compare((T) left[leftIndex],
                        (T) right[rightIndex])) < 1) {
                    mergeBuffer[resultIndex++] = left[leftIndex++];
                } else {
                    mergeBuffer[resultIndex++] = right[rightIndex++];
                }
            } else if (leftIndex < left.length) {
                mergeBuffer[resultIndex++] = left[leftIndex++];
            } else if (rightIndex < right.length) {
                mergeBuffer[resultIndex++] = right[rightIndex++];
            }
        }
        return mergeBuffer;
    }
}
