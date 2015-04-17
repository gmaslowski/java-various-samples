package com.gmaslowski.trove;

import org.junit.Test;
import gnu.trove.TIntArrayList;

public class TroveArrayListIterating {

    @Test
    public void forEach() {
        // given
        TIntArrayList list = new TIntArrayList();
        initializeIntList(list, 100);

        // execute
        list.forEach(i -> {
            System.out.println(i);
            return true;
        });
    }

    @Test
    public void forEachDescending() {
        // given
        TIntArrayList list = new TIntArrayList();
        initializeIntList(list, 100);

        // execute
        list.forEachDescending(i -> {
            System.out.println(i);
            return true;
        });
    }

    @Test
    public void grep() {
        // given
        TIntArrayList list = new TIntArrayList();
        initializeIntList(list, 100);

        // execute
        list
            .grep(i -> i % 2 == 0)
            .forEach(i1 -> {
                System.out.println(i1);
                return true;
            });
    }

    @Test
    public void inverseGrep() {
        // given
        TIntArrayList list = new TIntArrayList();
        initializeIntList(list, 100);

        // execute
        list
                .inverseGrep(i -> i % 2 == 0)
                .forEach(i1 -> {
                    System.out.println(i1);
                    return true;
                });
    }

    private void initializeIntList(TIntArrayList list, Integer capacity) {
        for (int i = 0; i < capacity; i++) {
            list.add(i);
        }
    }
}
