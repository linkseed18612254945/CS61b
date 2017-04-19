package lab.lab08;

import javax.swing.plaf.PanelUI;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by 51694 on 2017/4/15.
 */
public class BSTMap<K extends Comparable<K>, V> implements Map61B<K, V>
{
    private class Node
    {
        K key;
        V value;
        int size;
        Node left, right;

        Node(K key, V value, int size)
        {
            this.key = key;
            this.value = value;
            this.size = size;
        }

    }

    private Node root;

    public BSTMap(){}

    @Override
    public int size()
    {
        return size(root);
    }

    private int size(Node node)
    {
        if (node == null)
        {
            return 0;
        }
        return node.size;
    }

    private Node put(Node node, K key, V value)
    {
        if(node == null)
        {
            return new Node(key, value, 1);
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
        {
            node.left = put(node.left, key, value);
        }
        else if (cmp > 0)
        {
            node.right = put(node.right, key, value);
        }
        else
        {
            node.value = value;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public void put(K key, V value)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        if (value == null)
        {
            remove(key);
        }
        root = put(root, key, value);
    }

    private V get(Node node, K key)
    {
        if (node == null)
        {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
        {
            return get(node.left, key);
        }
        else if (cmp > 0)
        {
            return get(node.right, key);
        }
        else
        {
            return node.value;
        }
    }

    @Override
    public V get(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        return get(root, key);
    }

    @Override
    public boolean containsKey(K key)
    {
        return get(key) != null;
    }

    @Override
    public void clear()
    {
        root = null;
    }

    private K select(int i)
    {
        if (i < 0 || i > size())
        {
            throw new IllegalArgumentException();
        }
        return select(root, i).key;
    }

    private Node select(Node node, int i)
    {
        if (node == null)
        {
            return null;
        }
        if (i < size(node.left))
        {
            return select(node.left, i);
        }
        else if (i > size(node.left))
        {
            return select(node.right, i - size(node.left) - 1);
        }
        else
        {
            return node;
        }
    }


    @Override
    public Set<K> keySet()
    {
        Set<K> keys = new HashSet<>();
        for (int i = 0; i < size(); i += 1)
        {
            keys.add(select(i));
        }
        return keys;
    }

    private Node min(Node node)
    {
        if(node == null)
        {
            return null;
        }
        if (node.left == null)
        {
            return node;
        }
        return min(node.left);
    }

    private Node deleteMin(Node node)
    {
        if (node == null)
        {
            return null;
        }
        if (node.left == null)
        {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node remove(Node node, K key)
    {
        if (node == null)
        {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
        {
            node.left = remove(node.left, key);
        }
        else if (cmp > 0)
        {
            node.right = remove(node.right, key);
        }
        else
        {
            if (node.left == null)
            {
                return node.right;
            }
            if (node.right == null)
            {
                return node.left;
            }
            Node temp = node;
            node = min(temp.right);
            node.right = deleteMin(temp.right);
            node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    @Override
    public V remove(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        V removeValue = get(key);
        root = remove(root, key);
        return removeValue;
    }

    @Override
    public V remove(K key, V value)
    {
       throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<K> iterator()
    {
        return new KeyIterator();
    }

    private class KeyIterator implements Iterator<K>
    {
        int nextPosition;

        KeyIterator()
        {
            nextPosition = 0;
        }

        @Override
        public boolean hasNext()
        {
            return nextPosition < size();
        }

        @Override
        public K next()
        {
            return select(nextPosition);
        }
    }

    public void printInOrder()
    {
        for (int i = 0; i < size(); i += 1)
        {
            System.out.print("(" + select(root, i).key + ", " + select(root, i).value  + " )  ");
        }
    }
}
