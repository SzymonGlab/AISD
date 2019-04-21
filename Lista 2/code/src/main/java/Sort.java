public abstract class Sort {

  int comparisionCounter = 0;
  int swapCounter = 0;

  public abstract void sortASC(int array[], int low, int high);
  public abstract void sortDESC(int array[], int low, int high);

  int getSwapCounter() {
    return swapCounter;
  }

  int getComparisionCounter() {
    return comparisionCounter;
  }

  void swap(int[] arr, int index1, int index2) {
    swapCounter++;
    int temp = arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }

  public void setComparisionCounter(int comparisionCounter) {
    this.comparisionCounter = comparisionCounter;
  }

  public void setSwapCounter(int swapCounter) {
    this.swapCounter = swapCounter;
  }

}

