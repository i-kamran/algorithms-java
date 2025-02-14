public class QuickSort {
  public void sort(int[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  private void quickSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int partitionIdx = partition(arr, left, right);
    quickSort(arr, left, partitionIdx);
    quickSort(arr, partitionIdx + 1, right);
  }

  public int partition(int[] arr, int left, int right) {

  }
  public void swap(int[] arr, int aIdx, int bIdx){
    int temp = arr[aIdx];
    arr[aIdx] = arr[bIdx];
    arr[bIdx] = temp;
  } 
}
