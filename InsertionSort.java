/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortAlgorithms;

import Models.*;


public class InsertionSort {
    
    Vulnerability[] arr  ; // for sort
    int size = 10000  ; 
    long start, end ;
    
    public InsertionSort(Root root) {
        
       // size = root.vulnerabilities.size() ;
       
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
        insertionSort(cleanArr) ;
        end = System.currentTimeMillis() ;     
    } 
    
    public void insertionSort(Vulnerability[] arr){
       
        for(int i=1;i<arr.length;i++) {
            Vulnerability key = arr[i] ;
            int j = i-1 ;
            while(j>=0 && arr[j].compareTo(key)<0) {
                arr[j+1] = arr[j] ;
                j=j-1 ;
            } 
            arr[j+1] = key ;
        }
    }
    public long timeDifference() {
        return (end-start) ;
    }    
}
