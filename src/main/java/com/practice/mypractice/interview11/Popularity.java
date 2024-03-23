package com.practice.mypractice.interview11;

/*

EPAM 4th Round (DSA):

Func:
1. inc the popularity -> increase by 1 - O(log n)
2. dec the popularity -> decrease by 1 - O(log n)
3. get Most popular content - O(1)


constraints:
popularity can be equal -> if its equal, choose the latest one.
popularity cant go negative


                      1000
                 ''900      800
              '900  600   500 400

 */

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Page {

    int pageId;
    String content;
    int popularity;

    Page(int pageId, String content, int popularity) {
        this.pageId = pageId;
        this.content = content;
        this.popularity = popularity;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageId=" + pageId +
                ", content='" + content + '\'' +
                ", popularity=" + popularity +
                '}';
    }
}


public class Popularity {

    PriorityQueue<Page> pq;
    Map<Integer, Page> mapOfPages;

    public static void main(String[] args) {
        Popularity popObj = new Popularity();
        popObj.initialize();

        popObj.incrementPopularity(1);
        popObj.incrementPopularity(8);
        popObj.incrementPopularity(8);
        popObj.incrementPopularity(8);
        popObj.incrementPopularity(2);
        popObj.incrementPopularity(2);
        popObj.incrementPopularity(2);
        popObj.incrementPopularity(4);
        popObj.incrementPopularity(5);
        popObj.incrementPopularity(6);
        popObj.incrementPopularity(7);
        popObj.incrementPopularity(8);
        System.out.println(popObj.getMostPopularPage());// => 8
        popObj.decrementPopularity(2);
        popObj.decrementPopularity(8);
        System.out.println(popObj.getMostPopularPage()); // => 8
        popObj.decrementPopularity(8);
        popObj.decrementPopularity(8);
        popObj.decrementPopularity(8);
        System.out.println(popObj.getMostPopularPage()); // =>  2
        popObj.incrementPopularity(4);
        System.out.println(popObj.getMostPopularPage()); // =>  4


        System.out.println(popObj.pq);

    }

    private void initialize() {
        pq = new PriorityQueue<>((o1, o2) -> (o2.popularity - o1.popularity - 1));
        mapOfPages = new HashMap<>();

        Page p1 = new Page(1, "Hello", 0);
        Page p2 = new Page(2, "Hello", 0);
        Page p3 = new Page(3, "Hello", 0);
        Page p4 = new Page(4, "Hello", 0);
        Page p5 = new Page(5, "Hello", 0);
        Page p6 = new Page(6, "Hello", 0);
        Page p7 = new Page(7, "Hello", 0);
        Page p8 = new Page(8, "Hello", 0);
        mapOfPages.put(1, p1);
        mapOfPages.put(2, p2);
        mapOfPages.put(3, p3);
        mapOfPages.put(4, p4);
        mapOfPages.put(5, p5);
        mapOfPages.put(6, p6);
        mapOfPages.put(7, p7);
        mapOfPages.put(8, p8);
        pq.add(p1);
        pq.add(p2);
        pq.add(p3);
        pq.add(p4);
        pq.add(p5);
        pq.add(p6);
        pq.add(p7);
        pq.add(p8);

    }

    void addPage(Page p) {

    }

    public void incrementPopularity(int pageId) {
        Page page = mapOfPages.get(pageId);
        page.popularity++;

        pq.remove(page);
        pq.add(page);
    }

    public void decrementPopularity(int pageId) {
        Page page = mapOfPages.get(pageId);
        page.popularity = Math.max(--page.popularity, 0);

        pq.remove(page);
        pq.add(page);
    }

    public Page getMostPopularPage() {
        return pq.peek();
    }

}
