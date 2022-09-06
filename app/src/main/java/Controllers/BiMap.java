package Controllers;

import java.util.HashMap;
import java.util.Map;

public class BiMap<K extends Object, V extends Object> {

    private Map<K,V> forward = new HashMap<K, V>();
    private Map<V,K> backward = new HashMap<V, K>();
  
    public void put(K key, V value) {
      forward.put(key, value);
      backward.put(value, key);
    }
  
    public V getForward(K key) {
      return forward.get(key);
    }
  
    public K getBackward(V key) {
      return backward.get(key);
    }
}
