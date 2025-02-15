public class ImageRotator {
  public void rotate(int[][] arr) {
    int n = arr.length;
    for (int i = 0; i < n / 2; ++i) {
      for (int j = i; j < n - 1; ++j) {
        int temp = arr[i][j];
        arr[i][j] = arr[n - j - 1][i];
        arr[n - j - 1][i] = arr[n - i - 1][n - j - 1];
        arr[n - i - 1][n - j - 1] = arr[j][n - i - 1];
        arr[j][n - i - 1] = temp;
      }
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    ImageRotator rotator = new ImageRotator();
    rotator.rotate(matrix);

    // Print the rotated matrix
    printMatrix(matrix);
  }

  private static void printMatrix(int[][] matrix) {
    for (int[] row : matrix) {
      for (int num : row) {
        System.out.print(num + " ");
      }
      System.out.println();
    }
  }
}
