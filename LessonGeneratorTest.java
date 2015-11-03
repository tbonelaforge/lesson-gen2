class LessonGeneratorTest {
    public static void main(String[] args) throws Exception {
        int n = 7;
        int k = 2;
        if (args.length == 2) {
            n = Integer.parseInt(args[0]);
            k = Integer.parseInt(args[1]);
        }
        try {
            LessonGenerator lessonGenerator = new LessonGenerator(n, k);
            System.out.println(String.format("About to generate a random lesson of %d equations using %d cards", k, n));
            Lesson randomLesson = lessonGenerator.generateRandomLesson();
            System.out.println("The resulting lesson is:\n");
            System.out.println(randomLesson);
        } catch(Exception e) {
            System.out.println("Error:");
            System.out.println(e.getMessage());
            System.exit(0);
        }

    }
}
