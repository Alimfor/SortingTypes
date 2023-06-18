import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Sorting implements SortingType{
    @Override
    public void selectionSort(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.size(); j++) {
                if (arr.get(minIndex) > arr.get(j)) {
                    minIndex = j;
                }
            }
            Collections.swap(arr,i, minIndex);
        }
    }

    @Override
    public void bubbleSort(List<Integer> arr) {
        for (int i = 0; i < arr.size(); i++) {
            boolean isSorted = true;
            for (int j = 1; j < arr.size() - i; j++) {
                if (arr.get(j) < arr.get(j - 1)) {
                    isSorted = false;
                    Collections.swap(arr,j,j - 1);
                }
            }
            if (isSorted) {
                return;
            }
        }
    }

    @Override
    public void insertionSort(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            int cur = arr.get(i);
            int j = i - 1;
            while (j >= 0 && arr.get(j) > cur) {
                arr.set(j + 1, arr.get(j));
                --j;
            }
            arr.set(j + 1,cur);
        }
    }

    @Override
    public void countingSort(List<Integer> arr) {
        int max = Collections.max(arr);
        int min = Collections.min(arr);

        int[] elemQuantity = new int[max - min + 1];
        for (Integer integer : arr) {
            elemQuantity[integer - min]++;
        }

        arr.clear();
        for (int i = 0; i < elemQuantity.length; i++) {
            int count = elemQuantity[i];
            for (int j = 0; j < count; j++) {
                arr.add(i + min);
            }
        }
    }

    @Override
    public void mergeSort(List<Integer> arr) {
        if (arr.size() <= 1) {
            return;
        }
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int n = arr.size() / 2;

        for (int i = 0; i < n; i++) {
            left.add(arr.get(i));
        }
        for (int i = n; i < arr.size(); i++) {
            right.add(arr.get(i));
        }
        mergeSort(left);
        mergeSort(right);

        arr.clear();
        arr.addAll(merge(left,right));
    }
    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int leftIndex = 0, rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (left.get(leftIndex) <= right.get(rightIndex)) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            merged.add(left.get(leftIndex++));
        }
        while (rightIndex < right.size()) {
            merged.add(right.get(rightIndex++));
        }
        return merged;
    }

    @Override
    public void quickSort(List<Integer> arr) {
        quickSort(arr,0,arr.size());
    }
    private void quickSort(List<Integer> arr, int i, int size) {
        if (i == size) return;

        int pivot = partition(arr,i,size);// [i,pivot - 1] < pivot // [pivot + 1,j] >= pivot
        quickSort(arr,i,pivot);
        quickSort(arr,pivot + 1,size);
    }
    private int partition(List<Integer> arr, int i, int j) {
        Random random = new Random();
        int pivot = random.nextInt(j - i) + i;
        Collections.swap(arr,i,pivot);

        pivot = i;
        int s1Index = i;
        int s2Index = i;

        for (int k = i + 1; k < j; k++) {
            if (arr.get(k) >= arr.get(pivot)) {
                ++s2Index;
            } else {
                ++s1Index;
                Collections.swap(arr,s1Index,k);
                ++s2Index;
            }
        }
        Collections.swap(arr,s1Index,pivot);
        pivot = s1Index;
        return pivot;
    }
}
