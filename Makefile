java_shortcut = 'java LessonGeneratorTest $$@'

all: clean generate

generate: LessonGeneratorTest.class
	@echo "Writing shortcut script generate..."
	@echo '#! /bin/sh' > generate
	@echo 'java LessonGeneratorTest $$@' >> generate
	@chmod +x generate

LessonGeneratorTest.class: LessonGeneratorTest.java LessonGenerator.class Equation.class Lesson.class
	javac LessonGeneratorTest.java

LessonGenerator.class: LessonGenerator.java Equation.class Lesson.class
	javac LessonGenerator.java

Equation.class: Equation.java
	javac Equation.java

Lesson.class: Lesson.java Equation.class
	javac Lesson.java

.PHONY: clean

clean:
	rm -f generate
	rm -f *.class
