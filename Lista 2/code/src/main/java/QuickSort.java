public class QuickSort extends Sort {

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
