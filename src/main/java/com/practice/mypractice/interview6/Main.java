package com.practice.mypractice.interview6;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.test(new Object());
        //main.test(null);
    }

    public void test(Object student) throws RuntimeException {
        //Refactor the below code following the Java 8 coding standards
        /*if (student == null) {
            throw new RuntimeException();
        } else {
            callStudentDetails(student);
        }*/

        // My Solution:
        Optional<Object> studentOptional = Optional.ofNullable(student);
        callStudentDetails(studentOptional.orElseThrow(() -> new RuntimeException()));


    }

    //no modification required
    private void callStudentDetails (Object student) {
        //business logic
        System.out.println("call student method is called");
    }
}
