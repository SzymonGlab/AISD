public class InsertionSort extends Sort {

  public void sortASC(int array[], int low, int high) {
    int arraySize = high +1;                                                                                            //rozmiar tablicy to ilość indeksów +1 (high to numer ostantiego indeksu)
      for (int i=low; i<arraySize;   ++i)
      {
        int key = array[i];
        int j = i-1;                                                                                                    // indexy posortowanych elementów które musimy porównać z nasszym kluczem
        while (j>=0 && array[j] > key)                                                                                  // Sprawdza czy poprzedni element jest większy od aktualnie badanego
                                                                                                                        // jeżeli tak to przesuwa ułożone już elementy w prawo, dopóki są one większe od badanego elementu.
                                                                                                                        // Potem w odpowiednie miejsce wstawia badany element
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
    int arraySize = high +1;                                                                                            //rozmiar tablicy to ilość indeksów +1 (high to numer ostantiego indeksu)
    for (int i=1; i<arraySize; ++i)
    {
      int key = array[i];
      int j = i-1;

      while (j>=0 && array[j] < key)                                                                                    // Sprawdza czy poprzedni element jest mniejszy od aktualnie badanego
                                                                                                                        // jeżeli tak to przesuwa ułożone już elementy w prawo, dopóki są one większe od badanego elementu.
                                                                                                                        // Potem w odpowiednie miejsce wstawia badany element.
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
