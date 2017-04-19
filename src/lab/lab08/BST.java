package lab.lab08;

import java.util.NoSuchElementException;

/**
 * Created by 51694 on 2017/4/15.
 */
public class BST<K extends Comparable<K>, V>
{
    private class Node
    {
        private K key;
        private V value;
        private Node left, right;
        private int size;

        public Node(K key, V value, int size)
        {
            this.key = key;
            this.value = value;
            this.size = size;
        }
    }

    private Node root;

    public BST(){}

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
        if (node == null)
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

    private Node delete(Node node, K key)
    {
        if (node == null)
        {
            return null;
        }
        int cmp = key.compareTo(node.key);
        if (cmp < 0)
        {
            delete(node.left, key);
        }
        else if (cmp > 0)
        {
            delete(node.right, key);
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
            node = max(temp.left);
            node.left = deleteMax(node.left);
            node.right = temp.right;
            // node = min(temp.right);
            // node.right = deleteMin(temp.right);
            // node.left = temp.left;
        }
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private Node min(Node node)
    {
        if (node.left == null)
        {
            return node;
        }
        else
        {
            return min(node.left);
        }
    }

    private Node deleteMin(Node node)
    {
        if (node.left == null)
        {
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private void deleteMin()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        root = deleteMin(root);
    }

    private Node max(Node node)
    {
        if (node.right == null)
        {
            return node;
        }
        else
        {
            return max(node.right);
        }
    }

    private Node deleteMax(Node node)
    {
        if (node.right == null)
        {
            return node.left;
        }
        node.right = deleteMax(node.right);
        node.size = size(node.left) + size(node.right) + 1;
        return node;
    }

    private void deleteMax()
    {
        if (isEmpty())
        {
            throw new NoSuchElementException();
        }
        root = deleteMax(root);
    }


    public boolean isEmpty()
    {
        return size() == 0;
    }

    public int size()
    {
        return size(root);
    }

    public void put(K key, V value)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        if (value == null)
        {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    public V get(K key)
    {
        return get(root, key);
    }

    public boolean contains(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        return get(key) != null;
    }

    public void delete(K key)
    {
        if (key == null)
        {
            throw new IllegalArgumentException();
        }
        root = delete(root, key);
    }
}
