package main.practice;

public class BtreeDemo<K, V> {
    private class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    private class SearchResult<V> {
        private V value;
        private boolean isExist;
        private int index;

        public SearchResult(V value, boolean isExist, int index) {
            this.value = value;
            this.isExist = isExist;
            this.index = index;
        }

        public V getValue() {
            return value;
        }

        public boolean isExist() {
            return isExist;
        }

        public int getIndex() {
            return index;
        }
    }

    private class Node<K, V> {

    }
}
