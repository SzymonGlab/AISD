public class QuickSort extends Sort {

//  tablica = (9,1,2,5,7,3)
//  Wybieramy ostatni element jako pivot (3), oraz wyznaczamy granice jako i=-1 i stawiamy ją przed całą tablicą (|(9),1,2,5,7,3),
//  po prawej stronie granicy są elementy większe od piwota po lewej mniejsze. Porównujemy piwot z 9, 9 jest po prawej stronie granicy
//  więc wszystko się zgadza, nie przesuwamy granicy, badamy kolejny element (|9,(1),2,5,7,3) i porównujemy z kolejnym elementem (1), 1 jest mniejsza od 3, więc zostaje
//  zamieniona z pierwszym elementem po prawej od granicy (9) i granica zosaje przesunięta o jedno miejsce  (1|9,(2),5,7,3), (teraz i=0), porównujemy 2 z 3 i znowu zamieniamy z pierwszym elementem
//  po prawej granicy (9) i przesuwamy granicę (1,2|9,(5),7,3), (teraz i=1) porównujemy 3 z 5 i wszystko jest okej, więc badamy kolejny element (7), 7 jest większa od 3, więc badamy kolejny element
//  dochodzimy do piwota i zamieniamy piwot z miejscem w tablicy gdzie teraz jest granica (1,2,3,9,5,7) (w przypadku implementacji  zamieniamy z miejscem i+1). Dzielimy tablicę na dwie części (1,2) i (9,5,7) piwot jest już na swoim miejscu.
//  Powtarzamy operację dla każdej z tablic.



  int findBoundASC(int arr[], int low, int high)
  {
    int pivot = arr[high];
    int i = (low-1);
    for (int j=low; j<high; j++)
    {
//      System.err.println("COMPARITION");
      comparisionCounter++;
      if (arr[j] <= pivot)
      {
//        System.err.println("SWAP");
        i++;
        swap(arr,i,j);
      }
    }
    swap(arr,i+1,high);

    return i+1;
  }


  public void sortASC(int arr[], int low, int high)
  {
    if (low < high)
    {
      int pi = findBoundASC(arr, low, high);

      sortASC(arr, low, pi-1);
      sortASC(arr, pi+1, high);
    }
  }

  int findBoundDESC(int arr[], int low, int high)
  {
    int pivot = arr[high];
    int i = (low-1);
    for (int j=low; j<high; j++)
    {
//      System.err.println("COMPARITION");
      comparisionCounter++;
      if (arr[j] >= pivot)
      {
        i++;
//        System.err.println("SWAP");
        swap(arr,i,j);
      }
    }
    swap(arr,i+1,high);

    return i+1;
  }

  public void sortDESC(int arr[], int low, int high)
  {
    if (low < high)
    {
      int pi = findBoundDESC(arr, low, high);

      sortDESC(arr, low, pi-1);
      sortDESC(arr, pi+1, high);
    }
  }
}
