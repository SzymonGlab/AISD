public class HeapSort extends Sort {

  public void sortASC(int array[], int low, int high) {

    int n = high + 1;                                                                                                

    for (int i = n / 2 - 1; i >= 0; i--) {                                                                            
      validateMaxHeap(array, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
//      System.err.println("SWAP");
      swap(array, 0, i);                                                                                   
      n--;
      validateMaxHeap(array, n, 0);                                                                         
    }
  }

  private void validateMaxHeap(int[] array, int heapSize, int parentIndex) {
    int maxIndex = parentIndex;
    int leftChild = parentIndex * 2 + 1;
    int rightChild = parentIndex * 2 + 2;

    comparisionCounter++;
//    System.err.println("COMPARITION");
    if (leftChild < heapSize && array[leftChild] > array[maxIndex]) {
      maxIndex = leftChild;
    }
    comparisionCounter++;
//    System.err.println("COMPARITION");
    if (rightChild < heapSize && array[rightChild] > array[maxIndex]) {
      maxIndex = rightChild;
    }
    comparisionCounter++;
    if (maxIndex != parentIndex) {
//      System.err.println("SWAP");
      swap(array, maxIndex, parentIndex);
      validateMaxHeap(array, heapSize, maxIndex);                                                                      
                                                                                                                        
                                                                                                                        
                                                                                                                        
    }
  }

  private void validateMinHeap(int[] array, int heapSize, int parentIndex) {
    int maxIndex = parentIndex;
    int leftChild = parentIndex * 2 + 1;
    int rightChild = parentIndex * 2 + 2;
    comparisionCounter++;
//    System.err.println("COMPARITION");
    if (leftChild < heapSize && array[leftChild] < array[maxIndex]) {                                                 
      maxIndex = leftChild;
    }
    comparisionCounter++;
//    System.err.println("COMPARITION");
    if (rightChild < heapSize && array[rightChild] < array[maxIndex]) {
      maxIndex = rightChild;
    }
    comparisionCounter++;
    if (maxIndex != parentIndex) {
//      System.err.println("SWAP");                                                                                    
      swap(array, maxIndex, parentIndex);                                                                               
                                                                                                                        
                                                                                                                    
      validateMaxHeap(array, heapSize, maxIndex);
    }
  }

  public void sortDESC(int array[], int low, int high) {

    int n = high + 1;                                                                                               

    for (int i = n / 2 - 1; i >= 0; i--) {                                                                           
      validateMinHeap(array, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      System.err.println("SWAP");
      swap(array, 0, i);                                                                                     
      n--;
      validateMinHeap(array, n, 0);                                                                         
    }
  }
}



