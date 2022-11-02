/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortAlgorithms;

import Models.*;
public class MergeSort {
    public static Vulnerability[] arr  ; // for sort
    int size;
    int low = 0;
    long start, end ;
    
    
    public MergeSort(Root root) {
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
        mergeSort(cleanArr,low,cleanArr.length-1) ;
        end = System.currentTimeMillis() ;     
    } 
    
  
    
    void merge(Vulnerability array[], int start, int mid, int end) {
    
    int n1 = mid - start + 1;
    int n2 = end - mid;

    Vulnerability left[] = new Vulnerability[n1];
    Vulnerability right[] = new Vulnerability[n2];

    for (int i = 0; i < n1; i++)
      left[i] = array[start + i];
    for (int j = 0; j < n2; j++)
      right[j] = array[mid + 1 + j];

    int i, j, k;
    i = 0;
    j = 0;
    k = start;

    
    while (i < n1 && j < n2) {
      if (left[i].compareTo(right[j])>0) {
        array[k] = left[i++];
        
      } else {
        array[k] = right[j++];
       
      }
      k++;
    }
    while (i < n1) {
      array[k++] = left[i++];
    }

    while (j < n2) {
      array[k++] = right[j++];
    }
  }

  void mergeSort(Vulnerability array[], int start, int end) {
    if (start < end) {
      int mid = (start + end) / 2;
      
      mergeSort(array, start, mid);
      mergeSort(array, mid + 1, end);
      merge(array, start, mid, end);
    }
  }
    
     public long timeDifference() {
        return (end-start) ;
    }      
}
