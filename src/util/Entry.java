package util;

public class Entry<DesiredType> {

    public DesiredType element;

    public Entry<DesiredType> left;

    public Entry<DesiredType> right;

    public Entry<DesiredType> parent;

    Entry(DesiredType element){
        this.element = element;
        right = null;
        left = null;
        parent = null;
    }
}
