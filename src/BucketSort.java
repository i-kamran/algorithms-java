import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BucketSort {
  public void sort(int[] arr, int numberOfBuckets) {
    var i = 0;
    for (var bucket : createBuckets(arr, numberOfBuckets)) {
      Collections.sort(bucket);
      for (var item : bucket) {
        arr[i++] = item;
      }
    }
  }

  private List<List<Integer>> createBuckets(int[] arr, int numberOfBuckets) {
    List<List<Integer>> buckets = new ArrayList<>();
    for (var i = 0; i < numberOfBuckets; ++i) {
      buckets.add(new ArrayList<>());
    }
    for (var item : arr) {
      buckets.get(item / numberOfBuckets).add(item);
    }
    return buckets;
  }
}
