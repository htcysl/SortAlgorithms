/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package algorithms2;

import java.io.File;
import Models.* ;
import SortAlgorithms.* ;
import com.fasterxml.jackson.annotation.JsonAutoDetect;  
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper ;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import java.io.IOException;

public class Main {
    
    public static void main(String[] args) throws IOException {
     
        try{
            ObjectMapper om = new ObjectMapper() ;
            om.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            om.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(JsonAutoDetect.Visibility.ANY));
            Root root = om.readValue(new File("3.json"), Root.class) ;
           
      
           // ------------------- SORTING ALGORITHMS --------------------------
           System.out.println("--------------- SORTING ALGORITHMS ----------\n");
           // ------------------- MERGESORT------------------------------------
           //System.out.println("----------------------------------------------");
           MergeSort mergeSort = new MergeSort(root) ;
           System.out.print(" MERGESORT TIME DIFFERENCE : ");
           System.out.println(mergeSort.timeDifference()+" millisecond");
           System.out.println("----------------------------------------------\n");
           
           // ------------------- INSERTIONSORT --------------------------------
           InsertionSort insertionSort = new InsertionSort(root) ;
           System.out.print(" INSERTIONSORT TIME DIFFERENCE : ");
           System.out.println(insertionSort.timeDifference()+" millisecond");
           System.out.println(" (using 10 000 json data)");
           System.out.println("----------------------------------------------\n");
           
           //--------------------- HEAPSORT -----------------------------------
           HeapSort heapSort = new HeapSort(root) ;
           System.out.print(" HEAPSORT TIME DIFFERENCE : ");
           System.out.println(heapSort.timeDifference()+" millisecond");
           System.out.println("----------------------------------------------\n");
           
           //--------------------- QUICKSORT ----------------------------------
           QuickSort quickSort = new QuickSort(root) ; 
           System.out.print(" QUICKSORT TIME DIFFERENCE : ");
           System.out.println(quickSort.timeDifference()+" millisecond");
           System.out.println("----------------------------------------------\n");
          
           //---------------------- AvlTree Sort -------------------------------
           AvlTree avlSort = new AvlTree(root) ; 
           System.out.print(" AVLTSORT TIME DIFFERENCE : ");
           System.out.println(avlSort.timeDifference()+" millisecond");
           System.out.println("----------------------------------------------\n");
           
         //System.out.println(root.vulnerabilities.size()) ;
        }catch(NullPointerException e) {
            e.getMessage();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        
    }
    
}
