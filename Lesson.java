import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;

class Lesson {
    private Set<Integer> used = new HashSet<Integer>();
    private List<Equation> equations = new ArrayList<Equation>();

    public Lesson() {
    
    }

    public Lesson(Lesson lesson) {
        this.equations.addAll(lesson.getEquations());
        this.used.addAll(lesson.getUsed());
    }

    public List<Equation> getEquations() {
        return equations;
    }

    public boolean canAdd(Equation equation) {
        if (!used.contains(equation.getA()) &&
            !used.contains(equation.getB()) &&
            !used.contains(equation.getC())) {
            return true;
        }
        return false;
    }

    public void addEquation(Equation equation) {
        equations.add(equation);
        used.add(equation.getA());
        used.add(equation.getB());
        used.add(equation.getC());
    }

    private Set<Integer> getUsed() {
        return used;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < equations.size(); i++) {
            output += equations.get(i).toString();
            if (i < equations.size() - 1) {
                output += ",\n";
            }
        }
        return output;
    }
}
