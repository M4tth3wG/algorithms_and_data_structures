package modification;

import java.util.Comparator;
import java.util.Iterator;

public class StudentComparator implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        int compLastname, compFirstname;

        if ((compLastname = o1.getLastname().compareTo(o2.getLastname())) != 0) {
            return compLastname;

        } else if ((compFirstname = o1.getFirstname().compareTo(o2.getFirstname())) != 0) {
            return compFirstname;

        } else if (o1.getAge() != o2.getAge()) {
            return (o1.getAge() - o2.getAge());

        } else if (!o1.getGrades().equals(o2.getGrades())) {
            int size1, size2;

            if ((size1 = o1.getGrades().size()) == (size2 = o2.getGrades().size())) {
                float grade1 = 0, grade2 = 0;

                for (Iterator<Float> itr1 = o1.getGrades().iterator(), itr2 = o2.getGrades().iterator(); itr1.hasNext(); grade1 = itr1.next(), grade2 = itr2.next()) {
                    if (grade1 != grade2){
                        return (int) (grade1 - grade2);
                    }
                }
            }
            return (size1 - size2);
        }
        return 0;
    }
}