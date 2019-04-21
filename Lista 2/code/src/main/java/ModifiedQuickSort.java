public class ModifiedQuickSort extends QuickSort {




    InsertionSort insertionSort;

    public ModifiedQuickSort(){
      insertionSort = new InsertionSort();
    }

    public int findBoundDESC ( int arr[], int low, int high){
      int pivot = arr[calculateMedian(low,high,arr)];
      swap(arr, calculateMedian(low,high,arr),high);
      int i = (low - 1);                                                                                                // ustawienie granicy przed pierwszym elementem
      for (int j = low; j < high; j++) {
        if (arr[j] >= pivot)                                                                                            // sprawdzenie czy badany element jest większy od piwota
        {
          i++;                                                                                                          // Jeżeli jest przesuń granicę o jedno miejsce

          int temp = arr[i];                                                                                            // Zamień miejscami element po prawej stronie granicy z aktualnie badanym elementem
                                                                                                                        // (granica była i, ale i++ powyżej powoduje że i to teraz element po prawej stronie poprzedniej granicy)
          arr[i] = arr[j];
          arr[j] = temp;
        }
      }
      swapCounter++;
      int temp = arr[i + 1];                                                                                            // Po przejściu całej pętli zamień piwot z elementem po prawej granicy
      arr[i + 1] = arr[high];
      arr[high] = temp;

      return i + 1;
    }

  @Override
  public void sortDESC(int[] arr, int low, int high) {
    if(high-low<=16){
      insertionSort.sortDESC(arr,low,high);
//      insertionSort.insertionSortAsc(low,high,arr);
      comparisionCounter+=insertionSort.getComparisionCounter();
    } else {
      super.sortDESC(arr, low, high);
    }
  }

  @Override
  public int findBoundASC (int arr[], int low, int high)
    {

      int pivotIndex = calculateMedian(low,high,arr);
      swap(arr, pivotIndex, high);
      return super.findBoundASC(arr,low,high);                                                                          // po swapie high to index ostatniego elementu, który został wybrany teraz na piwot
    }

  @Override
  public void sortASC(int[] arr, int low, int high) {
      if(arr.length<=16) {                                                                                              // high+1 bo high to ostatni indeks, a elementów jest o 1 więcej
        insertionSort.sortASC(arr,low,high);
        comparisionCounter += insertionSort.getComparisionCounter();
        swapCounter += insertionSort.getSwapCounter();
      }

      if(low<high) {

        int bound = findBoundASC(arr, low, high);
        if ((bound - 1) - low + 1 <= 16) {
          insertionSort.sortASC(arr, low, bound - 1);
        } else {
          sortASC(arr, low, bound - 1);
        }

        if (high - (bound + 1) + 1 <= 16) {
          insertionSort.sortASC(arr, bound + 1, high);
        } else {

          sortASC(arr, bound + 1, high);
        }

        comparisionCounter +=insertionSort.getComparisionCounter();
        swapCounter += insertionSort.getSwapCounter();
        insertionSort.setSwapCounter(0);
        insertionSort.setComparisionCounter(0);
      }
  }

  private int calculateMedian(int first, int last, int[] array){
    int[] possiblePivots = {array[first],array[last],array[(first-last)/2+last]};

    insertionSort.sortASC(possiblePivots,0,2);
    int median;
    median = possiblePivots[1];
    if(median == first){
      return first;
    } else if(median == last){
      return last;
    } else
      return (first-last)/2+last;
  }

  InsertionSort getInsertionSort() {
    return insertionSort;
  }
}

