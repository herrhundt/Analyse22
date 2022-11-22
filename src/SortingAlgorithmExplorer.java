import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class is created for an analysis of different simple sorting algorithms. 
 * The implementation of the sorting algorithms is done in class SortingAlgorithms. 
 * @author Hundt, 
 * @version 22.11.2022
 */
public class SortingAlgorithmExplorer {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //Reader of console inputs

        System.out.println("LETS ANALYZE!");
        System.out.println("Willkommen beim Analyse-Programm der Sortierverfahren!");

        int menuItem = 0; //für die Menüstruktur
        int n=0; //Länge des Arrays (wird später benötigt)
        while(menuItem!=-1){

        int[] testArray;

        System.out.println("Wählen Sie einen Menüpunkt aus!");
        System.out.println("(1): Average-Case-Szenario");
        System.out.println("(2): Worst-Case-Szenario");
        System.out.println("(3): Worst-Case-Szenarien (von 1.000-100.000) sukzessive");

        System.out.println("_________________________________");
        System.out.println("(-1): Exit");

        try {menuItem = Integer.parseInt(br.readLine());} catch (Exception e) {System.out.println("\nPlease enter an integer");menuItem=0;} //Gives feedback to the user if the input cannot be used

        switch (menuItem) {
            case 1:
                System.out.print("Wählen Sie die Array-Länge: n=");
                try {n = Integer.parseInt(br.readLine());} catch (Exception e) {n=0;System.out.println("\nPlease enter an integer");} //Gives feedback to the user if the input cannot be used

                System.out.println("Average-Case-Szenario mit n="+n);
                testArray = createRandomArray(n,1000);
                System.out.println(SortingAlgorithm.countSelectionSort(testArray.clone())+"(SelectionSort)"); //Arbeite auf einer Kopie!
                System.out.println(SortingAlgorithm.countInsertionSort(testArray.clone())+"(InsertionSort)"); //Arbeite auf einer Kopie!
                System.out.println(SortingAlgorithm.countBubbleSort(testArray.clone())+"(BubbleSort)"); //Arbeite auf einer Kopie!
                break;
            case 2:
                System.out.print("Wählen Sie die Array-Länge: n=");
                try {n = Integer.parseInt(br.readLine());} catch (Exception e) {n=0;System.out.println("\nPlease enter an integer");} //Gives feedback to the user if the input cannot be used

                System.out.println("Worst-Case-Szenario mit n="+n);
                testArray = createDescendingArray(n);
                System.out.println(SortingAlgorithm.countSelectionSort(testArray.clone())+"(SelectionSort)"); //Arbeite auf einer Kopie!
                System.out.println(SortingAlgorithm.countInsertionSort(testArray.clone())+"(InsertionSort)"); //Arbeite auf einer Kopie!
                System.out.println(SortingAlgorithm.countBubbleSort(testArray.clone())+"(BubbleSort)"); //Arbeite auf einer Kopie!
                break;
            case 3:
                for(int i=1000;i<=100000;i=i*10)
                {
                    testArray = createDescendingArray(i);
                    System.out.println("n="+i);
                    System.out.println(SortingAlgorithm.countSelectionSort(testArray.clone())+"(SSort)"); //Arbeite auf einer Kopie!
                    System.out.println(SortingAlgorithm.countInsertionSort(testArray.clone())+"(ISort)"); //Arbeite auf einer Kopie!
                    System.out.println(SortingAlgorithm.countBubbleSort(testArray.clone())+"(BSort)"); //Arbeite auf einer Kopie!
                    System.out.println();
                }
                break;
        }
        }
  }

    /**
     * Die Methode speichert die Analyseergebnisse eines durchschnittlichen Szenarios in eine CSV-Datei.
     * @param nMax
     */
    public static void saveAVGCaseSzenarioToCSV(int nMax)
{
     int[] countValues = new int[nMax]; 
        for(int n=1; n<=nMax; n++)
        {
           int[] sampleArray = createRandomArray(n*10, 1000);  
           
           countValues[n-1] = SortingAlgorithm.countInsertionSort(sampleArray); 
        } 
    PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("testAVG.csv"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SortingAlgorithmExplorer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ColumnNamesList = "n,Aufwand";
        StringBuilder builder = new StringBuilder();

        // No need give the headers Like: id, Name on builder.append
        builder.append(ColumnNamesList +"\n");
        for(int n=1; n<=nMax; n++)
        {  
          builder.append(10*n+",");
          builder.append(countValues[n-1]);
          builder.append('\n');
          
        }
        pw.write(builder.toString()); 
        pw.close();
        System.out.println("done!");
}        
public static void saveWorstCaseSzenarioToCSV(int nMax)
{
     int[] countValues = new int[nMax]; 
        for(int n=1; n<=nMax; n++)
        {
           int[] sampleArray = createDescendingArray(n*10);  
           
           countValues[n-1] = SortingAlgorithm.countInsertionSort(sampleArray); 
        } 
    PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("testWorstCase.csv"));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(SortingAlgorithmExplorer.class.getName()).log(Level.SEVERE, null, ex);
        }
        String ColumnNamesList = "n,Aufwand";
        StringBuilder builder = new StringBuilder();

        // No need give the headers Like: id, Name on builder.append
        builder.append(ColumnNamesList +"\n");
        for(int n=1; n<=nMax; n++)
        {  
          builder.append(10*n+",");
          builder.append(countValues[n-1]);
          builder.append('\n');
          
        }
        pw.write(builder.toString()); 
        pw.close();
        System.out.println("done!");
}
public static void printWorstCaseSzenario(int nMax)
{
   int[] countValues = new int[nMax]; 
        for(int n=1; n<=nMax; n++)
        {
           int[] sampleArray = createDescendingArray(n*10);  
           countValues[n-1] = SortingAlgorithm.countInsertionSort(sampleArray); 
           System.out.println("n="+n+", A(n)="+countValues[n-1]);
        } 
}    
    /*
  This method prints the values of an array on the console. 
    @param array: Array, that should be printed on console. 
  */
  public static void printArrayOnConsole(int[] array)
  {
    System.out.print("["); 
    for (int i=0;i<array.length-1;i++ ) {
      System.out.print(array[i]+","); 
    } // end of for
    System.out.print(array[array.length-1]); 
    System.out.println("]"); 
    }

public static int[] createSampleArray()
    {
        int sample[] = {8,3,1,7}; 
        return sample;  
    } 
    
    public static int[] sortedSampleArray()
    {
        int[] sorted = {1,3,7,8};  
        return sorted; 
    }
    
    public static int[] createSampleArray2()
    {
        int[] sample = {6,3,5,2,8,1,7};  
        return sample; 
    }
    
    public static int[] sortedSampleArray2()
    {
        int[] sorted = {1,2,3,5,6,7,8};  
        return sorted; 
    }
    
    /*
    This method creates a random array of int-values of size length.  
    The values vary from 0 to zMax. 
    */ 
    public static int[] createRandomArray(int length, int zMax) 
  {
    int[] array = new int[length]; 
      for(int i=0;i<length;i++)
      {
         array[i] = (int) Math.round(Math.random()*zMax); 
      }
      return array; 
  } 
    
    /**
     * This method creates an array of int-values of size length. 
     * The values will be descending, f.e. createDescendingArray(3) will create 
     * the array [3,2,1]. 
     * @param length
     * @return 
     */
      public static int[] createDescendingArray(int length) 
  {
      int[] array = new int[length]; 
      for(int i=0;i<length;i++)
      {
         array[i] = length-i;  
      }
      return array; 
  }   
    
}
