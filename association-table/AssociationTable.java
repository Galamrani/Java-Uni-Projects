import java.util.Iterator;
import java.util.TreeMap;

// This class represents an association table that maps keys of type E to values of type T.
public class AssociationTable <E extends Comparable<E>, T> {
    
    // The association table is implemented as a TreeMap.
    public TreeMap<E, T> associationTable;

    // This constructor initializes the association table with the given keys and values.
    public AssociationTable(E[] keys, T[] values) throws IllegalArgumentException { 
        // If the keys and values arrays have different lengths, throw an IllegalArgumentException.
        if (keys.length != values.length) {
            throw new IllegalArgumentException();
        }
        // Initialize the TreeMap and add the keys and values to it.
        this.associationTable = new TreeMap<>();
        for (int i = 0; i < keys.length; i++) {
            this.associationTable.put(keys[i], values[i]);
        }
    }

    // This constructor initializes an empty association table.
    public AssociationTable() {
        this.associationTable = new TreeMap<>();
    }

    // This method adds a key-value pair to the association table.
    public void add(E key, T value) {
        associationTable.put(key, value);
    }

    // This method retrieves the value associated with a given key.
    public T get(E key) {
        return associationTable.get(key);
    }

    // This method checks if a given key is in the association table.
    public Boolean contains(E key) {
        return associationTable.containsKey(key); 
    }

    // This method removes a key-value pair from the association table.
    public Boolean remove(E key) {
        if (associationTable.containsKey(key)) {
            associationTable.remove(key);
            return true;
        }
        return false;
    }

    // This method returns the size of the association table.
    public int size() {
        return associationTable.size();
    }

    // This method returns an iterator over the keys in the association table.
    public Iterator<E> keyIterator() {
        return associationTable.keySet().iterator();
    }
}
