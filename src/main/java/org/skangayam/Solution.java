package org.skangayam;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by skangayam on 2/21/17.
 *
 * Algorithm:
 * Create a visited matrix of the same size as input
 * Initialize the visited matrix as follows
 *      Initialize the border elements of visited with the same elements as input
 *      Rest of the elements as 'B' (unvisited placeholder)
 *
 * Create a unexplored Queue
 * Initialize the queue as follows:
        Add the border indices of input to this unexplored queue whose value is 'Z'
 * For each element in the queue
 *      Get neighbors of the index
 *      Add a neighbor to the unexplored queue if the visited matrix has a value of X  and input has Z
 *      Update visited to input's value
 *  Once the explored queue is empty, we have exhausted all indices reachable from the border elements
 *  traverse the visited matrix and update the input matrix's value to 'A' if value of visited is 'B'
 */
public class Solution {

    public void surround(char[][] input){
        char[][] visited = new char[input.length][input[0].length];
        initializeVisited(input, visited);
        LinkedList<Index> unexplored = getExplorableIndices(input);

        while (!unexplored.isEmpty()){
            Index tempIndex = unexplored.getFirst();
            explore(tempIndex, input, visited, unexplored);
            unexplored.removeFirst();
        }

        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length; j++) {
                if (visited[i][j] == 'X'){
                    input[i][j] = 'A';
                }
            }
        }
    }

    private void initializeVisited(char[][] input, char[][] visited) {
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[0].length ; j++) {
                visited[i][j] = 'X';
            }
        }

        for (int i = 0; i < input[0].length; i++) {
            visited[0][i] = input[0][i];
            visited[input.length - 1][i] = input[input.length - 1][i];
        }

        for(int i = 0; i < input.length; i++){
            visited[i][0] = input[i][0];
            visited[i][input[0].length -1] = input[i][input[0].length - 1];
        }
    }

    private void explore(Index index, char[][] input, char[][] visited, LinkedList<Index> unexplored) {
        List<Index> neighbors = getNeighbors(index, input);
        for (Index i : neighbors) {
            if (visited[i.row][i.col] == 'X'){
                if (input[i.row][i.col] == 'Z'){
                    unexplored.add(i);
                }
                visited[i.row][i.col] = input[i.row][i.col];
            }
        }
    }

    private List<Index> getNeighbors(Index index, char[][] input) {
        List<Index> result = new ArrayList<Index>();
        int firstRow = 0;
        int lastRow = input.length - 1;
        int firstCol = 0;
        int lastCol = input[0].length - 1;

        if (index.col - 1 >= firstCol){
            result.add(new Index(index.row, index.col - 1));
        }

        if (index.col + 1 <= lastCol){
            result.add(new Index(index.row, index.col + 1));
        }

        if (index.row - 1 >= firstRow){
            result.add(new Index(index.row - 1, index.col));
        }

        if (index.row + 1 <= lastRow){
            result.add(new Index(index.row + 1, index.col));
        }

        return result;
    }

    private LinkedList<Index> getExplorableIndices(char[][] input) {
        LinkedList<Index> result = new LinkedList<Index>();
        for (int i = 0; i < input[0].length; i++) {
            if (input[0][i] == 'Z'){
                result.add(new Index(0,i));
            }
            if (input[input.length - 1][i] == 'Z'){
                result.add(new Index(input.length - 1, i));
            }
        }

        for(int i = 0; i < input.length; i++){
            if (input[i][0] == 'Z'){
                result.add(new Index(i, 0));
            }
            if (input[i][input[0].length - 1] == 'Z'){
                result.add(new Index(i, input[0].length - 1));
            }
        }

        return result;
    }

    private class Index{
        int row;
        int col;

        Index(int i, int j){
            this.row = i;
            this.col = j;
        }
    }
}
