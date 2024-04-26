package modification;

import core.HashFunction;

public class StudentHashFunction implements HashFunction<Student> {

    @Override
    public int hashCode(Student object) {
        int hashCode = 0;

        hashCode ^= object.getFirstname().hashCode();
        hashCode ^= object.getLastname().hashCode();
        hashCode ^= object.getAge();

        return hashCode;
    }
}
