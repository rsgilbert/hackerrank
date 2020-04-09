package hackerrank.learning;

public class Generics {
    public static void main(String[] args) {
        Box<Integer> integerBox = new Box<Integer>();
    }
}

/**
 * Generic version of the Box class
 * @param <T> the type of the value being boxed
 */
class Box<T> {
    private T t;

    public void set(T t) { this.t = t; }
    public T get() { return t; }
}