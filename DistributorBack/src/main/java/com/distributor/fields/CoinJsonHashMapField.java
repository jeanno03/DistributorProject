package com.distributor.fields;

import java.util.TreeSet;


public class CoinJsonHashMapField {

    private TreeSet<String> strings;

    public CoinJsonHashMapField() {
    }

    public CoinJsonHashMapField(TreeSet<String> strings) {
        this.strings = strings;
    }

    public TreeSet<String> getStrings() {
        return strings;
    }

    public void setStrings(TreeSet<String> strings) {
        this.strings = strings;
    }
}
