package com.practice.mypractice.programs;

import com.practice.mypractice.programs.dto.LinkedListNodeGame;

public class WinnerOfArrayGame {

    LinkedListNodeGame last;

    public static void main(String[] args) {
        int arr[] = {3, 2, 1}, k = 10;
        WinnerOfArrayGame ob = new WinnerOfArrayGame();
        System.out.println(ob.getWinner(arr, k));
        System.out.println(ob.getWinnerQuickestSolution(arr, k));
    }

    public int getWinnerQuickestSolution(int[] arr, int k) {
        int win=0;
        int ele=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]>ele){
                win=0;
                ele=arr[i];
            }
            if(++win==k){
                break;
            }
        }
        return ele;
    }

    public int getWinner(int[] arr, int k) {
        LinkedListNodeGame head = createLinkedList(arr);
        LinkedListNodeGame winner = getWinner(head, k);
        return winner.val;
    }

    private LinkedListNodeGame getWinner(LinkedListNodeGame head, int k) {
        LinkedListNodeGame aux1, aux2;
        while (true) {
            aux1 = head;
            aux2 = head.next;
            if (aux2.goneAtLast) {
                break;
            }
            if (aux1.val > aux2.val) {
                aux1.win_count++;
                aux2.win_count = 0;
                aux1.next = aux1.next.next;
                last.next = aux2;
                aux2.next = null;
                last = aux2;
                aux2.goneAtLast = true;
            } else {
                aux2.win_count++;
                aux1.win_count = 0;
                last.next = aux1;
                aux1.next = null;
                head = aux2;
                last = aux1;
                aux1.goneAtLast = true;
            }

            if (head.win_count == k) {
                return head;
            }
        }
        return head;
    }


    private LinkedListNodeGame createLinkedList(int[] arr) {
        LinkedListNodeGame head = null, aux = head;
        for (int num : arr) {
            LinkedListNodeGame temp = new LinkedListNodeGame(num);
            if (head == null) {
                head = temp;
                aux = head;
            } else {
                aux.next = temp;
                aux = aux.next;
            }
        }
        last = aux;
        return head;
    }
}
