import java.util.ArrayList;

class Student {
    protected static final int QUIZ_AMOUNT = 15;

    protected String name;
    protected ArrayList<Integer> quizScores;

    public Student(String name) {
        this.name = name;
        this.quizScores = new ArrayList<Integer>(QUIZ_AMOUNT);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getQuizScores() {
        return quizScores;
    }

    public void addQuizScore(int score) {
        if (quizScores.size() < QUIZ_AMOUNT) {
            quizScores.add(score);
        } else {
            System.out.println("Error: Student " + name + " already has " + QUIZ_AMOUNT + " quiz scores.");
        }
    }
}

class FullTimeStudent extends Student {
    protected static final int EXAM_AMOUNT = 2;

    protected ArrayList<Integer> examScores;

    public FullTimeStudent(String name) {
        super(name);
        this.examScores = new ArrayList<Integer>(EXAM_AMOUNT);
    }

    public ArrayList<Integer> getExamScores() {
        return examScores;
    }

    public void addExamScore(int score) {
        if (examScores.size() < EXAM_AMOUNT) {
            examScores.add(score);
        } else {
            System.out.println("Error: Student " + name + " already has " + EXAM_AMOUNT + " exam scores.");
        }
    }
}

class PartTimeStudent extends Student {
    public PartTimeStudent(String name) {
        super(name);
    }
}

class Session {
    protected final int STUDENT_AMOUNT = 20;

    protected ArrayList<Student> students;

    Session() {
        this.students = new ArrayList<Student>(STUDENT_AMOUNT);
    }

    public void addStudent(Student s) {
        if (students.size() < STUDENT_AMOUNT) {
            students.add(s);
        } else {
            System.out.println("Error: Session already has " + STUDENT_AMOUNT + " students.");
        }
    }

    public float getAverageQuizScores() {
        int count = 0;

        double sum = 0;
        for (Student student : students) {
            ArrayList<Integer> scores = student.getQuizScores();
            for (int score: scores) {
                sum += score;
            }
            count += scores.size();
        }

        if (count == 0) {
            return 0;
        }
        return (float)sum / count;
    }

    public void printAscendingScores() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (Student student : students) {
            ArrayList<Integer> scores = student.getQuizScores();
            list.addAll(scores);
        }
        list.sort((a, b) -> { return a - b; });
        System.out.println("Ascending Quiz Scores:");
        System.out.println(list);
    }

    public void printPartTimeNames() {
        System.out.println("Names of Part-time Students:");
        for (Student student : students) {
            if (student instanceof PartTimeStudent) {
                System.out.println(student.getName());
            }
        }
    }

    public void printFullTimeExamScores() {
        System.out.println("Exam Scores of Full-time Students:");
        for (Student student : students) {
            if (student instanceof FullTimeStudent) {
                ArrayList<Integer> scores = ((FullTimeStudent) student).getExamScores();
                System.out.println("scores of student " + student.getName() + ": " + scores);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        final int FULLTIME_STUDENT_AMOUNT = 10;
        final int PARTTIME_STUDENT_AMOUNT = 10;

        Session session = new Session();

        for (int i = 0; i < FULLTIME_STUDENT_AMOUNT; i++) {
            FullTimeStudent fullTimeStudent = new FullTimeStudent("full-time" + i);
            for (int j = 0; j < Student.QUIZ_AMOUNT; j++) {
                fullTimeStudent.addQuizScore((int) (Math.random() * 100));
            }
            for (int j = 0; j < FullTimeStudent.EXAM_AMOUNT; j++) {
                fullTimeStudent.addExamScore((int) (Math.random() * 100));
            }
            session.addStudent(fullTimeStudent);
        }

        for (int i = 0; i < PARTTIME_STUDENT_AMOUNT; i++) {
            PartTimeStudent partTimeStudent = new PartTimeStudent("part-time" + i);
            for (int j = 0; j < Student.QUIZ_AMOUNT; j++) {
                partTimeStudent.addQuizScore((int) (Math.random() * 100));
            }
            session.addStudent(partTimeStudent);
        }

        // method1
        System.out.println("Average Quiz Score:");
        System.out.printf("%.2f\n\n", session.getAverageQuizScores());
        // method2
        session.printAscendingScores();
        System.out.println();
        // method3
        session.printPartTimeNames();
        System.out.println();
        // method4
        session.printFullTimeExamScores();
    }
}
