package cskit.sorting;


public interface ObjectSortingAlgorithm<E extends Comparable<? super E>> {

    /**
     * Sorts the entire array.
     *
     * @param array the array to sort.
     */
    public void sort(E[] array);

    /**
     * Sorts the subsequence defined by range <code>r</code>.
     *
     * @param array the array to sort.
     * @param r  the range to sort.
     */
    public void sort(E[] array, Range r);
}
