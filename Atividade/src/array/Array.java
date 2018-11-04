/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package array;

import interfaces.Navigator;
import interfaces.DataStructure;

public class Array implements DataStructure{
    private Object[] array;
    
    public Array(int size) {
        array = new Object[size];
    }
    public Object getElement(int index) { return array[index]; }
     
    public void setElement(int index, Object element) {
        array[index] = element;
    }
    @Override
    public Navigator getNavigator() {
        return new ArrayNavigator();
    }
    @Override
    public int length() { return array.length; }
    
    
    
    private class ArrayNavigator implements Navigator {
        
        private int lastIndex = -1;
        
        @Override
        public boolean hasNext() {
            if (lastIndex + 1 < array.length) {
                lastIndex++;
                return true;
            }
            return false;
        }

        @Override
        public Object getElement() { return array[lastIndex]; }
    }
}
