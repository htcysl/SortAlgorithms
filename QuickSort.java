/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortAlgorithms;

import Models.*;

public class QuickSort {
    
    public static Vulnerability[] arr  ; // for sort
    int size;
    long start,end;
    
    public QuickSort(Root root){
        size = root.vulnerabilities.size() ;
        arr = new Vulnerability[size] ;
       
        
       // ignoring null values in vulnerabilities arraylist and assing them array 
        int index = 0 ;    
        for(int i=0;i<size;i++) {
            if(root.vulnerabilities.get(i).cve.metrics.cvssMetricV2==null){
                continue ;
            }
            else {
                arr[index++] = root.vulnerabilities.get(i) ;
            }
        }  
        // rearranging the array size to run sort method correctly 
        Vulnerability[] cleanArr = new Vulnerability[index] ; 
        for(int l =0 ;l<index;l++) 
            cleanArr[l] = arr[l] ;
        
        
        start = System.currentTimeMillis() ;
        quickSort(cleanArr,0,index-1);
        end = System.currentTimeMillis() ;  
    }
//----------------------------------------------------------------------------
    public void swap(Vulnerability[] arr, int i, int j)
    {
        Vulnerability temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
  
//--------------------------------------------------------------------------
    public int partition(Vulnerability[] arr, int low, int high){
  
        Vulnerability pivot = arr[high];
       
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
              if (arr[j].compareTo(pivot)>0) {
                i++;
                swap(arr, i, j);
              }
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
  
// ------------------------------------------------------------------------   
    public void quickSort(Vulnerability[] arr, int low, int high){
        
        if (low < high) {   
            int pi = partition(arr, low, high);
            
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
// ------------------- time difference -------------------------------------
    public long timeDifference() {
        return (end-start) ;
     }    
}

