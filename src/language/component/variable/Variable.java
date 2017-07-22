package language.component.variable;

/**
 * Created by Ana on 21.07.2017.
 */
public class Variable<T> implements Container {
    private T value;
    private String name;

    public Variable (String name) {
        this.name = name;
    }

    public T getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public void setValue(T value) {
            this.value = value;
    }
}
