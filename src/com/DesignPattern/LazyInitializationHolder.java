package com.DesignPattern;

public class LazyInitializationHolder {
    private LazyInitializationHolder() {
    }

    private static class ClaasHolder {
        private static LazyInitializationHolder instance = new LazyInitializationHolder();
    }

    public LazyInitializationHolder getInstance() {
        return ClaasHolder.instance;
    }
}
