package src.algorithm.sorting;
/* @author - Maftun Hashimli (maftunhashimli@gmail.com)) */

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student implements Comparable<Student> {
    public String name;
    public double gradePointAverage;

    Student(String name, double gradePointAverage) {
        this.name=name;
        this.gradePointAverage=gradePointAverage;
    }

    public static void sortByGPA(List<Student> students) {
        Collections.sort(
                students, Collections.reverseOrder(new Comparator<Student>() {
                    @Override
                    public int compare(Student a, Student b) {
                        return Double.compare(a.gradePointAverage, b.gradePointAverage);
                    }
                }));
    }

    public static void sortByName(List<Student> students) {
        Collections.sort(students);
    }

    public int compareTo(Student that) {
        return name.compareTo(that.name);
    }
}
