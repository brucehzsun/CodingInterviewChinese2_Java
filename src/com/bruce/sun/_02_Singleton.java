package com.bruce.sun;

public class _02_Singleton {

    public static void main(String[] args) {

        SingleInstance instance = SingleInstance.getInstance();
    }

    static class SingleInstance {
        private static SingleInstance instance = new SingleInstance();

        private SingleInstance() {
        }

        public static SingleInstance getInstance() {
            return instance;
        }
    }
}
