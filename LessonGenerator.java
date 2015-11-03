import java.util.Set;
import java.util.List;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;

class LessonGenerator {
    private int n;
    private int k;
    private Set<Equation> validEquations;
    private Random randomizer = new Random();

    public LessonGenerator(int n, int k) throws Exception {
        if (k * Equation.howManyElements() > n) {
            throw new Exception(String.format("Cannot pick %d %d - element equations using only %d numbers", k, Equation.howManyElements()));                                       
        }
        this.n = n;
        this.k = k;
        setValidEquations();
    }

    public Lesson generateRandomLesson() {
        return generateRandomLesson(new Lesson());
    }

    public Lesson generateRandomLesson(Lesson lesson) {
        Lesson result = null;
        if (lesson.getEquations().size() == k) {
            return lesson;
        }
        List<Equation> availableEquations = getAvailableEquations(lesson);
        while (availableEquations.size() > 0) {
            int i = randomizer.nextInt(availableEquations.size());
            Equation equation = availableEquations.get(i);
            if (lesson.canAdd(equation)) {
                Lesson newLesson = new Lesson(lesson);
                newLesson.addEquation(equation);
                result = generateRandomLesson(newLesson);
                if (result != null) {
                    break;
                }
            }
            availableEquations.remove(i);
        }
        return result;
    }

    private void setValidEquations() {
        validEquations = new HashSet<Equation>();
        for (int i = 3; i <= n; i++) {
            int j = 1;
            int k;
            while ((k = i - j) > j) {
                validEquations.add(new Equation(j, k, i));
                j += 1;
            }
        }
    }

    private List<Equation> getAvailableEquations(Lesson lesson) {
        Set<Equation> availableEquationSet = new HashSet<Equation>(validEquations);
        availableEquationSet.removeAll(lesson.getEquations());
        return new ArrayList<Equation>(availableEquationSet);
    }
}
