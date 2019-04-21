import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class Main {

  private static Sort sortClass;
  
    public static void main(String[] args) {

      //Path where results will be saved
      String resultsPath = ""; 
      
      int k = 0;

      Scanner scanner = new Scanner(System.in);

      String[] userChoice;

      userChoice = checkInput(args);
      if(userChoice == null){
        System.out.println("WRONG ARGUMENTS");
        return;
      } else if(userChoice[0].equals("stat")){
        k = Integer.parseInt(args[2]);
        runSorting(null, userChoice, k);
        return;
      }


        int num1 = scanner.nextInt();
        int[] elements = new int[num1];
        int counter = 0;

        while(counter<num1 && scanner.hasNext()){
          elements[counter] = scanner.nextInt();
          counter++;
        }

        runSorting(elements, userChoice, k);

        for(int x : elements){
          System.out.println(x);
        }

        if(isSorted(elements,userChoice[1])){
          System.err.println("Array is sorted!");
          System.out.println("Comparision number: "+sortClass.getComparisionCounter());
          System.out.println("Swap number: "+sortClass.getSwapCounter());

        } else {
          System.err.println("Array is not sorted!");
        }

    }

  private static void runSorting(int[] elements,String[] userChoice, int k) {

    if ("select".equals(userChoice[0])) {
      sortClass = new SelectSort();

    } else if ("quick".equals(userChoice[0])) {
      sortClass = new QuickSort();

    } else if ("insert".equals(userChoice[0])) {
      sortClass = new InsertionSort();

    } else if ("heap".equals(userChoice[0])) {
      sortClass = new HeapSort();

    } else if ("mquick".equals(userChoice[0])) {
      sortClass = new ModifiedQuickSort();

    } else if ("stat".equals(userChoice[0])) {
      runStat(k);

    }
    if(userChoice.length>1  ) {
      if (userChoice[1].equals("--asc")) {
        sortClass.sortASC(elements, 0, elements.length - 1);
      } else if (userChoice[1].equals("--desc")) {
        sortClass.sortDESC(elements, 0, elements.length - 1);
      }
    }
  }

  private static String[] checkInput(String[] args) {

      String[] sortAlgorithms = {"quick","insert","heap","select","mquick"};
      String[] sortTypes = {"--asc","--desc"};

      if(args[1].equals("stat")){
        return new String[]{"stat"};
      }

      if(args.length!=3){
        return null;
      }

      if(args[0].equals("--type")){
        for(int i=0; i<5; i++){
          if(args[1].equals(sortAlgorithms[i])){
            for(int j=0; j<2; j++){
              if(args[2].equals(sortTypes[j])){
                return new String[]{sortAlgorithms[i],sortTypes[j]};
              }
            }
          }
        }
      }

    return null;
  }

  private static Boolean isSorted(int[] elements, String type){

      if(type.equals("--asc")){
        for(int i=0; i<elements.length-1; i++){
          if(elements[i]>elements[i+1]){
            return false;
          }
        }
      } else {
        for(int i=0; i<elements.length-1; i++){
          if(elements[i]<elements[i+1]){
            return false;
          }
        }
      }

      return true;
  }

  private static void  runStat(int k){

    int[] arrayToBeSorted;
    int[] clonedArray;

    ArrayList<String> quickResults = new ArrayList<>();
    ArrayList<String> modifiedResults = new ArrayList<>();
    ArrayList<String> insertResults = new ArrayList<>();
    ArrayList<String> selectResults = new ArrayList<>();
    ArrayList<String> heapResults = new ArrayList<>();


    QuickSort qs2 = new QuickSort();
    InsertionSort is = new InsertionSort();
    SelectSort ss = new SelectSort();
    ModifiedQuickSort mqs = new ModifiedQuickSort();
    HeapSort hs = new HeapSort();


    for(int i =100  ; i<10001; i=i+100) {

      for(int j=0; j<k; j++) {

        arrayToBeSorted = generateRandomArray(i);

        clonedArray = arrayToBeSorted.clone();
        insertResults.add(sorting(clonedArray,is,i));

        clonedArray = arrayToBeSorted.clone();
        quickResults.add(sorting(clonedArray,qs2,i));

        clonedArray = arrayToBeSorted.clone();
        modifiedResults.add(sorting(clonedArray,mqs,i));

        clonedArray = arrayToBeSorted.clone();
        selectResults.add(sorting(clonedArray,ss,i));

        clonedArray = arrayToBeSorted.clone();
        heapResults.add(sorting(clonedArray,hs,i));

        resetCounters(is, ss, mqs, hs,qs2);
      }
    }

    ArrayList<String> heapResultsAVG = calculateAvg(heapResults, k);
    ArrayList<String> quickResultsAVG = calculateAvg(quickResults, k);
    ArrayList<String> modifiedResultsAVG = calculateAvg(modifiedResults, k);
    ArrayList<String> selectResultsAVG = calculateAvg(selectResults, k);
    ArrayList<String> insertResultsAVG = calculateAvg(insertResults, k);

    saveToFile(resultsPath,quickResultsAVG);
    saveToFile(resultsPath,selectResultsAVG);
    saveToFile(resultsPath,insertResultsAVG);
    saveToFile(resultsPath,modifiedResultsAVG);
    saveToFile(resultsPath,heapResultsAVG);

  }

  private static void resetCounters(InsertionSort is, SelectSort ss, ModifiedQuickSort mqs, HeapSort hs, QuickSort qs) {
      is.setComparisionCounter(0);
      ss.setComparisionCounter(0);
      mqs.setComparisionCounter(0);
      hs.setComparisionCounter(0);
      mqs.getInsertionSort().setComparisionCounter(0);
      mqs.getInsertionSort().setSwapCounter(0);
      is.setSwapCounter(0);
      ss.setSwapCounter(0);
      mqs.setSwapCounter(0);
      hs.setSwapCounter(0);
      qs.setComparisionCounter(0);
      qs.setSwapCounter(0);

  }

  private static int[] generateRandomArray(int n) {
    Random r = new Random();

    int[] array = new int[n];

    for(int i=0; i<n; i++){
      array[i] = r.nextInt();
    }
    return array;
  }

  public static ArrayList<String> calculateAvg(ArrayList<String> results, int k){
      long avgComp =0;
      long avgTime=0;
      long avgSwap=0;
      int counter = 0;
      ArrayList<String> avgResults = new ArrayList<>();


      String[] sepResults;
      String[] prevResults = new String[4];
      prevResults[0]="100";
      for(String result : results){

        sepResults = result.split(",");
        if(sepResults[0].equals(prevResults[0])){
          avgComp += Long.parseLong(sepResults[1]);
          avgSwap += Long.parseLong(sepResults[2]);
          avgTime += Long.parseLong(sepResults[3]);
        } else {
          avgResults.add(counter,Integer.parseInt(prevResults[0]) + ","+avgComp/k+","+avgSwap/k+","+avgTime/k);
          counter++;
          avgComp = Long.parseLong(sepResults[1]);
          avgSwap = Long.parseLong(sepResults[2]);
          avgTime = Long.parseLong(sepResults[3]);
        }
        prevResults[0] = sepResults[0];
      }
      return avgResults;
  }

  public static void saveToFile(String filePath, ArrayList<String> data){
    Gson gson = new Gson();
    try{
      FileWriter fw =  new FileWriter(filePath);
      gson.toJson(data,fw);
      fw.flush();
      fw.close();
    } catch (IOException e){
      System.out.println("err: " + e.getMessage());
    }
  }

  public static String sorting(int[] arrayToBeSorted, Sort sortingAlgorithm, int elementsNumber){

    long startTime;
    long endTime;

    String result;
    startTime = System.nanoTime();
    sortingAlgorithm.sortASC(arrayToBeSorted, 0, elementsNumber - 1);
    endTime = System.nanoTime();
    result = elementsNumber + "," + sortingAlgorithm.getComparisionCounter() + "," + sortingAlgorithm.getSwapCounter() + "," + (endTime - startTime) / 1000;
    return result;
  }


}
