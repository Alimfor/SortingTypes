import java.util.List;

public interface SortingType {
    void selectionSort(List<Integer> arr);
    void bubbleSort(List<Integer> arr);
    void insertionSort(List<Integer> arr);
    void countingSort(List<Integer> arr);
    void mergeSort(List<Integer> arr);
    void quickSort(List<Integer> arr);
}
