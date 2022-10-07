package util;

import java.util.Comparator;

class BinarySearchTree<DesiredType> {
    Entry<DesiredType> root;
    int size;

    public BinarySearchTree() {
        root = null;
    }

    public boolean add(DesiredType element, Comparator<? super DesiredType> comparator) {
        int initSize = size;
        root = add(element, root, comparator);
        size++;
        if (initSize < size){return true;}
        else {return false;}
    }

    public Entry<DesiredType> add(DesiredType element, Entry root, Comparator<? super DesiredType> comparator) {
        DesiredType rootElement = null;
        if (root != null) {
            rootElement = (DesiredType) root.element;
        }
        if (root == null) {
            root = new Entry<>(element);
        } else if (comparator.compare(rootElement, element) > 0) {
            root.left = add(element, root.left, comparator);
        } else if (comparator.compare(rootElement, element) < 0) {
            root.right = add(element, root.right, comparator);
        } else {
            size--;
            return root;
        }
        return root;
    }

    public int size() {
        return size;
    }

    public boolean contains(DesiredType obj, Comparator<? super DesiredType> comparator){
        int helper = contains(obj, root, comparator);
        if (helper == 1){
            containsChecker = 0;
            return true;}
        else {
            containsChecker = 0;
            return false;}
    }

    int containsChecker = 0;
    public int contains(DesiredType obj, Entry<DesiredType> root, Comparator<? super DesiredType> comparator) {
        if (root == null){
            return 0;
        }
       if (comparator.compare(obj, root.element) == 0){
           containsChecker++;
       }
       if (comparator.compare(obj, root.element) < 0){
           contains(obj, root.left, comparator);
       }
       if (comparator.compare(obj, root.element) > 0){
           contains(obj, root.right, comparator);
       }
       return containsChecker;
    }

    public boolean remove(DesiredType obj, Comparator<? super  DesiredType> comparator){
        remove(obj, root, comparator);
        if (removeCheck == 1){
            size--;
            removeCheck = 0;
            return true;
        }
        removeCheck = 0;
        return false;
    }

    int removeCheck = 0;
    public Entry<DesiredType> remove(DesiredType obj, Entry<DesiredType> root, Comparator<? super DesiredType> comparator){
        if (root == null){
            return null;
        }
        if (comparator.compare(obj, root.element) < 0){
            root.left = remove(obj, root.left, comparator);
        }
        else if (comparator.compare(obj, root.element) > 0){
            root.right = remove(obj, root.right, comparator);
        }
        else{
            removeCheck++;
            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }
            root.element = minValue(root.right);
            root.right = remove(root.element, root.right, comparator);
            }
        return root;
        }

    DesiredType minValue(Entry<DesiredType> root){
        DesiredType minV = root.element;
        while(root.left != null){
            minV = root.left.element;
            root = root.left;
        }
        return minV;
    }

    public void toArr() {
        toArray(root);
    }

    public void toArray(Entry root) {
        if (root != null) {
            toArray(root.left);
            System.out.println(root.element);
            toArray(root.right);
        }
    }
}
