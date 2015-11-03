/*
Represents equations of the form:
a + b = c
 */
class Equation {
    private int a;
    private int b;
    private int c;

    public Equation(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    public int getC() {
        return c;
    }

    public String toString() {
        return String.format("%d + %d = %d", a, b, c);
    }

    public static int howManyElements() {
        return 3;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Equation) {
            Equation otherEquation = (Equation) obj;
            if (otherEquation.a == this.a &&
                otherEquation.b == this.b &&
                otherEquation.c == this.c) {
                return true;
            }
        }
        return false;
    }
}
