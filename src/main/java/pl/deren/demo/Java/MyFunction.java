package pl.deren.demo.Java;

@FunctionalInterface
public interface MyFunction<X, Y, Z, A> {
    A apply(X x, Y y, Z z);
}
