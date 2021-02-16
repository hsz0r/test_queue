/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_queue;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author hsz0r
 * @param <T>
 */
public class priority_queue <T extends Comparable<T>>  {
    
    ArrayList<T> queue;
        
    public priority_queue(){
        queue = new ArrayList<T>();
    }

    public boolean isEmpty(){  		
        return this.getSize() == 0;
    }
    
    public int getSize(){
        return this.queue.size();
    }    
         
    
    public void insert(T element) {
        queue.add(element);
        int index = queue.size() - 1;
        while (index > 0){
            int parIndex = index / 2;
            T child = queue.get(index);
            T parent = queue.get(parIndex);
            if (queue.get(index).compareTo(queue.get(parIndex)) > 0){
                queue.set(index, parent);
                queue.set(parIndex, child);
                index = parIndex;
            }
            else break;
        }
    }
  
    public void delete(){
        queue.set(0, queue.get(queue.size() - 1));
        queue.remove(queue.size() - 1);
        
        int size = queue.size();
        for (int i = size / 2 - 1; i >= 0; i--)
            heapify(queue, size, i);
        for (int i = size - 1; i >=0; i--){
            Collections.swap(queue, 0, i);
            heapify(queue, i, 0);
        }
    }
    
    private void heapify(ArrayList<T> queue, int index, int size) {
            
        int largest = index; 
        int left = 2 * index + 1; 
        int right = 2 * index + 2; 

        if (left < size && queue.get(left).compareTo(queue.get(largest)) > 0) {
            largest = left;
        }
        if (right < size && queue.get(right).compareTo(queue.get(largest)) > 0) {
            largest = right;
        }

        if (largest != index) {
            Collections.swap(queue, index, largest); 
            heapify(queue, largest, size);
        }
    }
        
    public T getMax(){
        return queue.get(0);
    }
    
    public ArrayList print(){
        return queue;
    }
    
}
