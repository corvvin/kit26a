package ua.khpi.oop.malokhvii02.event;

/**
 * Перелік можливих подій обробки контейнерів даних, використовується у якості
 * ключа для збереження подій {@link DataCollectionEvent},
 * {@link DataVisualizationEvent}, {@link DataComputationEvent}.
 *
 * @author malokhvii-ee
 * @version 1.0.0
 * @see EventType
 */
public enum DataEvent implements EventType {
    /**
     * Ключ, події отримання вхідних даних та збереження їх до котнейнеру даних.
     * , для подальшої обробки.
     */
    COLLECTION,
    /**
     * Ключ, події відображення обчисленних даних, згідно типу контейнера даних.
     */
    VISUALIZATION,
    /**
     * Ключ, події обчислення вхідних даних згідно типу контейнера даних.
     */
    COMPUTATION
}
