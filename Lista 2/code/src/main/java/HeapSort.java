public class HeapSort extends Sort {

  //TODO Czas wstawienia elementu do kopca to O(log(n)), wstawiamy n elementów, więc po wstawieniu n elementów mamy czas O(nlog(n)).


  public void sortASC(int array[], int low, int high) {

    int n = high + 1;                                                                                                   // Rozmiar tablicy to ilość indeksów +1 (high to numer ostantiego indeksu)

    for (int i = n / 2 - 1; i >= 0; i--) {                                                                              // Tworzymy kopiec od ostatniego parenta n/2-1 bo indeksujemy od 0
      validateMaxHeap(array, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
//      System.err.println("SWAP");
      swap(array, 0, i);                                                                                         // Zamieniamy ostatni element z korzeniem
      n--;
      validateMaxHeap(array, n, 0);                                                                          // Tworzymy kopiec dla nowej tablicy o 1 element mniejszej
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
      validateMaxHeap(array, heapSize, maxIndex);                                                                       // Jeszcze raz wywołujemy dla dzieci elementu który zamieniliśmy,
                                                                                                                        // żeby sprawdzić czy po zamianie nie zaburzyła sie struktura
                                                                                                                        // dotyczy to rodziców z wyższych poziomów niż ostatni ponieważ ich dzieci nie mają już dzieci,
                                                                                                                        // więc nie da się zaburzyć struktury
    }
  }

  private void validateMinHeap(int[] array, int heapSize, int parentIndex) {
    int maxIndex = parentIndex;
    int leftChild = parentIndex * 2 + 1;
    int rightChild = parentIndex * 2 + 2;
    comparisionCounter++;
//    System.err.println("COMPARITION");
    if (leftChild < heapSize && array[leftChild] < array[maxIndex]) {                                                   //Jeżeli któreś z dzieci jest mniejsze od rodzica zamień je ze sobą
      maxIndex = leftChild;
    }
    comparisionCounter++;
//    System.err.println("COMPARITION");
    if (rightChild < heapSize && array[rightChild] < array[maxIndex]) {
      maxIndex = rightChild;
    }
    comparisionCounter++;
    if (maxIndex != parentIndex) {
//      System.err.println("SWAP");                                                                                     // Jeżeli zamieniliśmy rodzicam sprawdź czy nie została zaburzona struktura drzewa
      swap(array, maxIndex, parentIndex);                                                                               // Jeszcze raz wywołujemy dla dzieci elementu który zamieniliśmy dotyczy to rodziców
                                                                                                                        // z wyższych poziomów niż ostatni
                                                                                                                        // ponieważ ich dzieci nie mają już dzieci, więc nie da się zaburzyć struktury
      validateMaxHeap(array, heapSize, maxIndex);
    }
  }

  public void sortDESC(int array[], int low, int high) {

    int n = high + 1;                                                                                                   // Rozmiar tablicy to ilość indeksów +1 (high to numer ostantiego indeksu)

    for (int i = n / 2 - 1; i >= 0; i--) {                                                                              // Tworzymy kopiec od ostatniego parenta n/2-1 bo indeksujemy od 0
      validateMinHeap(array, n, i);
    }

    for (int i = n - 1; i > 0; i--) {
      System.err.println("SWAP");
      swap(array, 0, i);                                                                                         // Zamieniamy ostatni element z korzeniem
      n--;
      validateMinHeap(array, n, 0);                                                                          // Tworzymy kopiec dla nowej tablicy o 1 element mniejszej
    }
  }
}



