package util;

import org.hamcrest.core.Is;
import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    @Test
    public void canAdd() {
        BinarySearchTree<Integer> aBinarySearchTree = new BinarySearchTree<Integer>();
        Assert.assertTrue(aBinarySearchTree.add(2, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(1, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(3, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(4, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(5, Comparator.naturalOrder()));
        aBinarySearchTree.toArr();
        Assert.assertThat(aBinarySearchTree.size(), Is.is(5));
    }
    @Test
    public void cantAddDupe() {
        BinarySearchTree<Integer> aBinarySearchTree = new BinarySearchTree<Integer>();
        Assert.assertTrue(aBinarySearchTree.add(2, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(1, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(3, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(4, Comparator.naturalOrder()));
        Assert.assertFalse(aBinarySearchTree.add(4, Comparator.naturalOrder()));
        aBinarySearchTree.toArr();
        Assert.assertThat(aBinarySearchTree.size(), Is.is(4));
    }

    @Test
    public void canFind(){
        BinarySearchTree<Integer> aBinarySearchTree = new BinarySearchTree<Integer>();
        Assert.assertTrue(aBinarySearchTree.add(2, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(1, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(3, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(4, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.contains(4, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.contains(1, Comparator.naturalOrder()));
    }
    @Test
    public void cantFind(){
        BinarySearchTree<Integer> aBinarySearchTree = new BinarySearchTree<Integer>();
        Assert.assertTrue(aBinarySearchTree.add(2, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(1, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(3, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(4, Comparator.naturalOrder()));
        Assert.assertFalse(aBinarySearchTree.contains(1738, Comparator.naturalOrder()));

    }

    @Test
    public void canRemove(){
        BinarySearchTree<Integer> aBinarySearchTree = new BinarySearchTree<Integer>();
        Assert.assertTrue(aBinarySearchTree.add(2, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(1, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(3, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(4, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.remove(4, Comparator.naturalOrder()));
        Assert.assertThat(aBinarySearchTree.size, Is.is(3));
        aBinarySearchTree.toArr();
    }
    @Test
    public void cantRemoveNonExist(){
        BinarySearchTree<Integer> aBinarySearchTree = new BinarySearchTree<Integer>();
        Assert.assertTrue(aBinarySearchTree.add(2, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(1, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(3, Comparator.naturalOrder()));
        Assert.assertTrue(aBinarySearchTree.add(4, Comparator.naturalOrder()));
        Assert.assertFalse(aBinarySearchTree.remove(1985, Comparator.naturalOrder()));
        Assert.assertThat(aBinarySearchTree.size, Is.is(4));
        aBinarySearchTree.toArr();
    }

}