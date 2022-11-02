/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortAlgorithms;

import Models.*;

public class HeapSort {
    public static Vulnerability[] arr  ; // for sort
    int size;
    long start,end;
    
    public HeapSort(Root root){
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
        heapSort(cleanArr) ;
        end = System.currentTimeMillis() ;     
    }
// --------------------------    
    public void heapSort(Vulnerability arr[]){
        
        for (int i=arr.length/2-1;i>=0;i--)
            heapify(arr,arr.length, i);
 
        for (int i=arr.length-1;i>0;i--) {
            // Move current root to end
            Vulnerability temp = arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
 
            heapify(arr, i, 0);
        }
    }
//------------------------------------    
    void heapify(Vulnerability arr[], int size, int i)
    {
        int largest=i; // Initialize largest as root
        int l=2*i+1; // left = 2*i + 1
        int r=2*i+2; // right = 2*i + 2
 
        // If left child is larger than root
        if (l<size&&arr[l].compareTo(arr[largest])<0)
            largest=l;
 
        // If right child is larger than largest so far
        if (r<size&&arr[r].compareTo(arr[largest])<0)
            largest=r;
 
        // If largest is not root
        if (largest != i) {
            Vulnerability swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
 
            // Recursively heapify the affected sub-tree
            heapify(arr, size, largest);
        }
    }
    public long timeDifference() {
        return (end-start) ;
    }
}
