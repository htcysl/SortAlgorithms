/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package SortAlgorithms;

import Models.*;



public class AvlTree<T extends Comparable>{
    
  private static class AvlNode<T> {
     
      T element; // The data in the node
      AvlNode<T> left; // Left child 
      AvlNode<T> right; // Right child
      int height; // Height
      
      AvlNode( T theElement ){
            this( theElement, null, null );
      }
      
      AvlNode( T theElement, AvlNode<T> l, AvlNode<T> r ){
             element = theElement;
             left = l;
             right = r;
             height = 0;
      }
   }
    
    private AvlNode<T> root ; //Tree root
    int ALLOWED_IMBALANCE = 1 ;
    long start , end ;
    
    public AvlTree(Root rootJson){
       root = null;
       
       int size = rootJson.vulnerabilities.size() ;
       
        start = System.currentTimeMillis() ;
        for(int i=0;i<size;i++) {
            if(rootJson.vulnerabilities.get(i).cve.metrics.cvssMetricV2==null){
                continue ;     
            }
            else {
                root = insert((T) rootJson.vulnerabilities.get(i),root) ;
            } 
        }
         end = System.currentTimeMillis() ;     
    }
    public long timeDifference() {
        return (end-start) ;
    }
    // Return the height of node t, or -1, if null.
    private int height( AvlNode<T> t ){
          return t == null ? -1 : t.height;
    }
    private AvlNode<T> rotateWithLeftChild( AvlNode<T> k2 ){
        AvlNode<T> k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        k2.height = Math.max( height( k2.left ), height( k2.right ) ) + 1;
        k1.height = Math.max( height( k1.left ), k2.height ) + 1;
        return k1;
   }
   
    private AvlNode<T> rotateWithRightChild( AvlNode<T> k1 ){
         AvlNode<T> k2 = k1.right;
         k1.right = k2.left;
         k2.left = k1;
         k1.height = Math.max( height( k1.left ), height( k1.right ) ) + 1;
         k2.height = Math.max( height( k2.right ), k1.height ) + 1;
         return k2;
    }
    private AvlNode<T> doubleWithLeftChild( AvlNode<T> k3 ) {
        k3.left = rotateWithRightChild( k3.left );
        return rotateWithLeftChild( k3 );
    }
    private AvlNode<T> doubleWithRightChild( AvlNode<T> k1 ){
        k1.right = rotateWithLeftChild( k1.right );
        return rotateWithRightChild( k1 );
    }
    private AvlNode<T> balance( AvlNode<T> t ){
        if( t == null )
        return t;

        if( height( t.left ) - height( t.right ) > ALLOWED_IMBALANCE )
        if( height( t.left.left ) >= height( t.left.right ) )
            t = rotateWithLeftChild( t ); //CASE 1
        else
            t = doubleWithLeftChild( t ); //CASE 2
        else
           if( height( t.right ) - height( t.left ) > ALLOWED_IMBALANCE )
           if( height( t.right.right ) >= height( t.right.left ) )
                 t = rotateWithRightChild( t ); //CASE 4
           else
                 t = doubleWithRightChild( t ); //CASE 3
                 t.height = Math.max( height( t.left ), height( t.right ) ) + 1;
        return t;
    }
    
    private AvlNode<T> insert( T x, AvlNode<T> t ){
        if( t == null )
        return new AvlNode( x, null, null );

        int compareResult = x.compareTo( t.element );

        if( compareResult < 0 )
            t.left = insert( x, t.left );
        else if( compareResult > 0 )
            t.right = insert( x, t.right );
        else
        ; // Duplicate; do nothing
        return balance( t );
    }
    


}



