public class SelectSort extends Sort {

  public void sortASC(int[] array, int low, int high) {
    int arraySize = high+1;                                                                                             
    for (int i = 0; i < arraySize; i++) {                                                                               
      int min_idx = i;                                                                                                  
      for (int j = i + 1; j < arraySize; j++) {
        //system.err.println("COMPARITION");
        comparisionCounter++;
        if (array[j] < array[min_idx]) {
          min_idx = j;
        }
      }
      //system.err.println("SWAP");
      swap(array,min_idx,i);                                                                                            
    }
  }

  public void sortDESC(int array[], int low, int high){
    int arraySize = high+1;                                                                                             
    for (int i = 0; i < arraySize; i++) {
      int max_idx = i;
      for (int j = i + 1; j < arraySize; j++) {
        comparisionCounter++;
        //system.err.println("COMPARITION");
        if (array[j] > array[max_idx]) {
          max_idx = j;
        }
      }
      //system.err.println("SWAP");
      swap(array,max_idx,i);
    }
  }
}
