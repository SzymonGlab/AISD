public class InsertionSort extends Sort {

  public void sortASC(int array[], int low, int high) {
    int arraySize = high +1;                                                                                            
      for (int i=low; i<arraySize;   ++i)
      {
        int key = array[i];
        int j = i-1;                                                                                                    
        while (j>=0 && array[j] > key)                                                                                  
                                                                                                                        
        {
          comparisionCounter++;
          swapCounter ++;
//          System.err.println("COMPARITION");
//          System.err.println("SWAP");
          array[j+1] = array[j];
          j = j-1;
        }
        swapCounter ++;
        array[j+1] = key;
      }
    }


  public void sortDESC(int array[], int low, int high){
    int arraySize = high +1;                                                                                            
    for (int i=1; i<arraySize; ++i)
    {
      int key = array[i];
      int j = i-1;

      while (j>=0 && array[j] < key)                                                                                    
                                                                                                                        
                                                                                                                        
      {
//        System.err.println("COMPARITION");
//        System.err.println("SWAP");
        comparisionCounter++;
        swapCounter ++;
        array[j+1] = array[j];
        j = j-1;
      }
//      System.err.println("SWAP");
      swapCounter ++;
      array[j+1] = key;
    }
  }
}
