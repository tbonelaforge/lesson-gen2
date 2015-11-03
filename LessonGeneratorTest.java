class LessonGeneratorTest {
    public static void main(String[] args) throws Exception {
        int n = 7;
        int k = 2;
        System.out.println(String.format("About to generate a random lesson of %d equations using %d cards", k, n));
        LessonGenerator lessonGenerator = new LessonGenerator(n, k);
        Lesson randomLesson = lessonGenerator.generateRandomLesson();
        System.out.println("The resulting lesson is:\n");
        System.out.println(randomLesson);
    }
}
