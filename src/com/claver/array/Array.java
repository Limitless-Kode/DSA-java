package com.claver.array;

import java.util.Arrays;

public class Array {
    private int[] arr;
    private int currentIndex = 0;
    private int currentArraySize;
    public Array(Integer size) {
        currentArraySize = size;
        this.arr = new int[size];
    }

    public void insert(Integer value){
        if(currentArraySize == currentIndex){
            currentArraySize = (currentArraySize*2);
            int[] temp = new int[currentArraySize];
            for(int i = 0; i < currentIndex; i++){
                temp[i] = arr[i];
            }
            arr = temp;
        }
        arr[currentIndex] = value;
        this.currentIndex++;
    }

    public void removeAt(Integer index){
        if(index < 0 || index >= currentIndex) throw new IllegalArgumentException();
        int[] newArray = new int[currentIndex - 1];
        int nextArrayIndex = 0;
        for (int i = 0; i < (currentIndex); i++){
            if(i != index) {
                newArray[nextArrayIndex] = arr[i];
                nextArrayIndex++;
            }
        }
        arr = new int[--currentIndex];
        this.arr = newArray;
    }

    public int pop(){
        int last = arr[currentIndex - 1];
        removeAt(currentIndex - 1);
        return last;
    }

    public Integer indexOf(Integer number){
        for (int i = 0; i < currentIndex; i++){
            if(this.arr[i] == number) return i;
        }
        return -1;
    }

    public Integer max(){
        int maxValue = 0;
        for(int i = 0; i < currentIndex; i++){
            if(arr[i] > maxValue) maxValue = arr[i];
        }
        return maxValue;
    }

    public Integer size(){
        return arr.length;
    }

    public int[] intersect(int[] array){
        int[] intersection = new int[array.length];
        int counter = 0;
        for (int k : arr) {
            for (int j: array){
                if(j == k){
                    intersection[counter] = j;
                    counter++;
                }
            }
        }
        if(counter < array.length){
            int[] tempIntersection = intersection;
            intersection = new int[counter];
            for(int i = 0; i < counter; i++){
                intersection[i] = tempIntersection[i];
            }
        }

        return intersection;
    }


    public void reverse(){
        int[] reversed = arr;
        arr = new int[currentIndex];
        for(int i = 0; i < currentIndex; i++){
            arr[i] = reversed[(currentIndex - 1) - i];
        }
    }

    public void insertAt(int index, int value){
        if(index > currentArraySize) throw new IllegalArgumentException();

        int[] tempArr = new int[currentArraySize];
        for(int i = 0; i < arr.length; i++){
            if(index == i) tempArr[i] = value;
            else {
                tempArr[i] = arr[i];
                currentIndex++;
            }
        }
        arr = tempArr;
    }


    public boolean isEmpty(){
        return currentIndex == 0;
    }

    public void print(){
        for (int i = 0; i < currentIndex; i++){
            System.out.println(arr[i]);
        }
    }

    public void sort() {
        int[] temp = new int[currentIndex];
        for (int i = 0; i < currentIndex; i++){
            System.out.println(i);
        }
    }
}
