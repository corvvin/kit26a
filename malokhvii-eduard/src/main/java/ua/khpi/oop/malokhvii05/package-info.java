/**
 * <p>
 * <b>5. Розробка власних контейнерів. Ітератори</b>
 * </p>
 * <p>
 * <b>Мета</b><br/>
 * <ul>
 * <li>Набуття навичок розробки власних контейнерів.</li>
 * <li>Використання ітераторів.</li>
 * </ul>
 * </p>
 * <p>
 * <b>Вимоги</b><br/>
 * <ol>
 * <li>Розробити клас-контейнер, що ітерується для збереження початкових даних
 * завдання л.р. №3 у вигляді масиву рядків з можливістю додавання, видалення і
 * зміни елементів.</li>
 * <li>В контейнері реалізувати та продемонструвати наступні методи:
 * <ul>
 * <li>String toString() повертає вміст контейнера у вигляді рядка;</li>
 * <li>void add(String string) додає вказаний елемент до кінця контейнеру;</li>
 * <li>void clear() видаляє всі елементи з контейнеру;</li>
 * <li>boolean remove(String string) видаляє перший випадок вказаного елемента з
 * контейнера;</li>
 * <li>Object[] toArray() повертає масив, що містить всі елементи у
 * контейнері;</li>
 * <li>int size() повертає кількість елементів у контейнері;</li>
 * <li>boolean contains(String string) повертає true, якщо контейнер містить
 * вказаний елемент;</li>
 * <li>boolean containsAll(Container container) повертає true, якщо контейнер
 * містить всі елементи з зазначеного у параметрах;</li>
 * <li>public Iterator<String> iterator() повертає ітератор відповідно до
 * Interface Iterable.</li>
 * </ul>
 * </li>
 * <li>В класі ітератора відповідно до Interface Iterator реалізувати методи:
 * <ul>
 * <li>public boolean hasNext();</li>
 * <li>public String next();</li>
 * <li>public void remove().</li>
 * </ul>
 * </li>
 * <li>Продемонструвати роботу ітератора за допомогою циклів while и for
 * each.</li>
 * <li>Забороняється використання контейнерів (колекцій) і алгоритмів з Java
 * Collections Framework.</li>
 * </ol>
 * </p>
 *
 * @author malokhvii-eduard
 * @version 1.0.0
 */

package ua.khpi.oop.malokhvii05;