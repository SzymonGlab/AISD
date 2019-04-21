public class SelectSort extends Sort {
  
//  Tablica jest podzielona na dwie części, posortowaną i nieposortowaną. Na początku posortowana jest puta.
//  Znajdujemy najmniejszy element w tablicy i wstawiamy go na pierwsze miejsce, szukamy z pozostałych elementów
//  najmniejszego i wstawiamy na 2 itd ...

  public void sortASC(int[] array, int low, int high) {
    int arraySize = high+1;                                                                                             // Rozmiar tablicy to ilość indeksów +1 (high to numer ostantiego indeksu)
    for (int i = 0; i < arraySize; i++) {                                                                               // Wszyskie wcześniejsze elementy są już uporządkowane
      int min_idx = i;                                                                                                  // Szukamy pośród pozostałych elementów najmniejszego
      for (int j = i + 1; j < arraySize; j++) {
        //system.err.println("COMPARITION");
        comparisionCounter++;
        if (array[j] < array[min_idx]) {
          min_idx = j;
        }
      }
      //system.err.println("SWAP");
      swap(array,min_idx,i);                                                                                            // Zamieniamy miejscami najmniejszą znalezioną wartośc w nieułożonej części tablicy
    }
  }

  public void sortDESC(int array[], int low, int high){
    int arraySize = high+1;                                                                                             // Rozmiar tablicy to ilość indeksów +1 (high to numer ostantiego indeksu)
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
