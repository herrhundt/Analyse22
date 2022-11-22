/**
  *
  * Diese Klasse kapselt die einfachen Sortierverfahren.
 * BubbleSort, SelectionSort und InsertionSort.
 * Dazu werden Möglichkeiten gegeben, den Aufwand der Sortierverfahren zu messen.
  *
  * @version 2.0 vom 22.11.2022
  * @author 
  */

public class SortingAlgorithm {
    private int counter = 0; 
  
  /**
   * BubbleSort-Algorithm. 
   * Beim Bubble-Sort-Algorithmus wird das Array v.l.n.r. durchgegangen. 
   * Hierbei werden benachbarte Elemente vertauscht, wenn sie in der falschen
   * Reihenfolge sind. 
   * Wenn man am rechten Ende angekommen ist, wird wieder von links begonnen. 
   * Dies wird solange wiederholt, bis das Array sortiert ist. 
   * @param array
   * @return 
   */
  public static int[] bubbleSort(int[] array) {
        boolean swap = true; //Es wurde noch nicht getauscht
        while (swap==true)  {
            swap = false;
            int help = 0;
            for (int i=0;i<array.length-1 ;i++ ) {
                if (array[i]>array[i+1]) { //Falls rechts ein kleineres Element steht, tauschen!
                    help = array[i];       //Dreieckstausch
                    array[i] = array[i+1];
                    array[i+1] = help;
                    swap = true; //Es wurde nun getauscht.
                } // end of if
            } // end of for
        }
        return array;
    }

    public static int countBubbleSort(int[] array) {
      int count =0;
        boolean swap = true; //Es wurde noch nicht getauscht
        while (swap==true)  {
            swap = false;
            int help = 0;
            for (int i=0;i<array.length-1 ;i++ ) {
                if (array[i]>array[i+1]) { //Falls rechts ein kleineres Element steht, tauschen!
                    help = array[i];       //Dreieckstausch
                    array[i] = array[i+1];
                    array[i+1] = help;
                    swap = true; //Es wurde nun getauscht.
                    count++; //Gezählt werden Tausch-Operationen
                } // end of if
            } // end of for
        }
        return count;
    }
  
  /**
   * Beim SelectionSort-Algorithmus wird in jedem Durchlauf das im nicht 
   * sortierten Bereich kleinste Element gesucht und an die nächste Stelle
   * eingefügt. Beim ersten Durchlauf wird also das kleinste Element an die
   * erste Position gestellt, beim zweiten Durchlauf das nächstkleinste Element
   * an die zweite Stelle usw. 
   * @param array
   * @return 
   */
  public static int[] selectionSort(int[] array)
  {
    int minValue;
    int minPosition;   
    int swap; 
    
    for (int i=0;i<array.length ;i++ ) {
    //Idee: Suche in jedem Schritt das kleinste Element im Array und f�ge es an der passenden Position ein
      minValue=array[i]; //Zunächst setzen wir das kleinste Element auf das erste noch verbliebene
      minPosition=i;   //Die Position des kleinsten Elements wird gespeichert 
      for (int j=i+1;j<array.length-1 ;j++ ) {
        if (array[j] < minValue) {//Ein kleineres Element ist gefunden
           minValue = array[j];  //Neues kleinstes Element
           minPosition = j;      //Position des kleinsten Elements merken 
        } // end of if         
      } // end of for
      swap = array[i];           //Dreieckstausch 
        array[i] = array[minPosition]; //Werte tauschen
        array[minPosition] = swap;
    } // end of for
    return array; 
  }


    /**
     * //TODO: Die Methode ist noch nicht korrekt implementiert, der Aufwand wird nicht richtig gemessen
     * @param array
     * @return
     */
    public static int countSelectionSort(int[] array)
    {
        int minValue;
        int minPosition;
        int swap;
        int count=0; //Gezählt werden Tausche (als eine Operation)

        for (int i=0;i<array.length ;i++ ) {
            //Idee: Suche in jedem Schritt das kleinste Element im Array und füge es an der passenden Position ein
            minValue=array[i]; //Zunächst setzen wir das kleinste Element auf das erste noch verbliebene
            minPosition=i;   //Die Position des kleinsten Elements wird gespeichert
            for (int j=i+1;j<array.length-1 ;j++ ) {
                if (array[j] < minValue) {//Ein kleineres Element ist gefunden
                    minValue = array[j];  //Neues kleinstes Element
                    minPosition = j;      //Position des kleinsten Elements merken

                } // end of if
            } // end of for
            swap = array[i];           //Dreieckstausch
            array[i] = array[minPosition]; //Werte tauschen
            array[minPosition] = swap;
            count++;
        } // end of for
        return count;
    }
  
  public static int[] insertionSortWithErrors(int[] array)
  {
    int value; 
    int help; 
       for (int i = 1; i<array.length;i++) 
       {  
         value = array[i]; 
          int j = i; 
          while(j > 1 && array[j-1] > value)
           {
              array[j] = array[j-1]; 
             j--;
           }
      array[j] = value;
      } 
      return array; 
  }
  
  /**
   * Beim InsertionSort wird das Array von links nach rechts durchgegangen. 
   * Hierbei wird jeweils das nächste Element genommen und im bereits 
   * sortierten Bereich (links) an der richtigen Stelle eingefügt. 
   * Die richtige Stelle ist die, an der links ein kleineres und rechts 
   * ein größeres Element steht. Solange links also ein größeres als das aktuelle
   * Element steht, muss weiter links gesucht werden. 
   * @param array
   * @return 
   */
  public static int[] insertionSort(int[] array)
  {
    int value; 
       for (int i = 1; i<array.length;i++) 
       {  
         value = array[i]; //Aktuelles Element
          int j = i;  //Nach links durchgehen... 
          while(j > 0 && array[j-1] > value) //Gibt es links ein größeres Element, 
           {
             array[j] = array[j-1]; //Dann verschiebe es nach rechts 
             j--;                   // und gehe weiter nach links 
           }
      array[j] = value;             // Füge es an die korrekte Stelle ein 
      } 
      return array; 
  }

    /**
     * Die Methode zählt den Aufwand des Insertion-Sort-Algorithmus.
     * Gezählt werden
     * @param array
     * @return Anzahl der Verschiebungen und Einfüge-Operationen
     */
    public static int countInsertionSort(int[] array)

  {
    int count=0; 
    int value; 
       for (int i = 1; i<array.length;i++) 
       {  
         value = array[i]; //Aktuelles Element
          int j = i;  //Nach links durchgehen... 
          while(j > 0 && array[j-1] > value) //Gibt es links ein größeres Element, 
           {
             array[j] = array[j-1]; //Dann verschiebe es nach rechts 
             j--;                   // und gehe weiter nach links 
            count++; //Verschiebung zählen
          }
      array[j] = value;             // Füge es an die korrekte Stelle ein
           count++; //Einfügen zählen
      } 
      return count; 
  }

 /* public static void quicksort(List<Integer> liste)
  {
      if(liste.length()>1) //Rekursionsanker
      {
          List<Integer> kleinere = new List<Integer>();
          List<Integer> groessere = new List<Integer>();
          liste.toFirst();
          int pivot = liste.getContent();
          liste.remove();
          while(!liste.isEmpty())
          {
              int akt = liste.getContent();
              if(akt<pivot)//Element prüfen
              kleinere.append(akt); //und einsortieren
              else groessere.append(akt);
              liste.remove(); //Element entfernen
          }
          quicksort(kleinere);
          quicksort(groessere);
          liste.concat(kleinere);
          liste.append(pivot);
          liste.concat(groessere);
      }
  }*/
  
  
  public int getCounter(){return this.counter;}; 
  public void resetCounter(){this.counter=0;}
  // Ende Methoden
} // end of SortingAlgorithm
