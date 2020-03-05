/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dsassignment3_spring2019;

import DataStructures.LinearNode;
import Exceptions.EmptyCollectionException;
import Exceptions.InvalidArgumentException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @param <T> General object
 * @author Sean Epley
 * @version 2019-28-3
 */
public class WorkAheadQueue<T> implements WorkAheadQueueADT<T> {
    private LinearNode<T> front;
    private LinearNode<T> back;
    private ArrayList<LinearNode<T>> frontThreeNodes;
    private ArrayList<T> frontThreeElements;
    private int numNodes;

    /**
     * Constructor for WorkAheadQueue
     */
    public WorkAheadQueue() {
        front = null;
        back = null;
        frontThreeNodes = new ArrayList<>();
        frontThreeElements = new ArrayList<>();
        numNodes = 0;
    }
    @Override
    public T dequeue(int x) throws EmptyCollectionException, InvalidArgumentException {
        T answer = null;
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Empty");
        }
        if (x < 2 || x > size() - 1) {
            throw new InvalidArgumentException("Invalid");
        }
        if (x == 0) {
            return this.dequeue();
        }
        answer = frontThreeElements.get(x - 1);
        this.dequeue();
        this.firstThreeElements();
        this.firstThreeNodes();
        numNodes--;
        return answer;
    }

    @Override
    public T first(int x) throws EmptyCollectionException, InvalidArgumentException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Empty");
        }
        if (x < 0 || x > size() - 1) {
            throw new InvalidArgumentException("Invalid");
        }
        return frontThreeNodes.get(x).getElement();
    }

    @Override
    public ArrayList<LinearNode<T>> firstThreeNodes() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("firstThreeElements(): empty " + "queue");
        }
        frontThreeNodes.clear();
        LinearNode<T> curr = front;
        for (int i = 0; i < 3 && i < size(); i++) {
            frontThreeNodes.add(i, curr);
            curr = curr.getNext();
        }
        return frontThreeNodes;
    }

    /**
     * Returns an ArrayList of the first three elements in the queue.
     *
     * @return ArrayList<T> array list of elements
     * @throws EmptyCollectionException if the queue is empty
     */
    @Override
    public ArrayList<T> firstThreeElements() throws EmptyCollectionException {
        if (isEmpty()) {
            throw new EmptyCollectionException("firstThreeElements(): empty " + "queue");
        }
        frontThreeElements.clear();
        LinearNode<T> curr = front;
        for (int i = 0; i < 3 && i < size(); i++) {
            frontThreeElements.add(i, curr.getElement());
            curr = curr.getNext();
        }
        return frontThreeElements;
    }
    
    @Override
    public void enqueue(T element) {
        LinearNode<T> temp = new LinearNode<T>(element);
        if (this.isEmpty()) {
            front = temp;
        } else {
            back.setNext(temp);
        }
        back = temp;
        numNodes++;
        try {
            firstThreeNodes();
            firstThreeElements();
        } catch (EmptyCollectionException ex) {
            Logger.getLogger(WorkAheadQueue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        T answer;
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Empty");
        } else {
            answer = front.getElement();
            front.setNext(front);
            if (front == null) {
                back = null;
            }
        }
        this.firstThreeNodes();
        this.firstThreeElements();
        numNodes--;
        return answer;
    }
    
    @Override
    public T first() throws EmptyCollectionException {
        return this.front.getElement();
    }

    /**
     * Returns true if the collection contains no elements
     *
     * @return true if the collection is empty
     */
    @Override
    public boolean isEmpty() {
        return numNodes == 0;
    }
        

    /**
     * Returns the number of elements in the collection
     *
     * @return the number of elements as an int
     */
    @Override
    public int size() {
        return numNodes;
    }

    /**
 * Returns a string representation of the collection
 *
 * @return a string representation of the collection
 */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        LinearNode curr = front;
        for (int i = 0; i < size(); i++) {
            sb.append(curr.getElement().toString());
            if (i < size() - 1) {
                sb.append(", ");
            }
            curr = curr.getNext();
        }
        return sb.toString();
    }
    
}
