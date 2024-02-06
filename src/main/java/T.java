import java.util.Map;

public class T {
    public static void main(String[] args) {
        Number a = new Number(3);
        Number b= new Number(4);
        b.add(a);
        a.add(b);

        Number result = Number.addNumber(a, b);
    }
}

class Number {
    int value;
    Number(int v) {
        value =v;
    }
    void add(Number othernumber) {
        value += othernumber.value;
    }
    static Number addNumber(Number number, Number othernumber) {
        return new Number(number.value + othernumber.value);
    }
}
// Number (value)
// a *3(
// b (4