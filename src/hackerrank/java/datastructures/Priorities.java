package hackerrank.java.datastructures;

import java.util.*;

public class Priorities {
    private PriorityQueue<Student> priorityQueue;

    public Priorities() {
        priorityQueue = new PriorityQueue<>((Student student1, Student student2) -> {
            int comparison = -Double.compare(student1.getCGPA(), student2.getCGPA());
            if (comparison == 0) {
                comparison = student1.getName().compareTo(student2.getName());
                if (comparison == 0) {
                    comparison = -Integer.compare(student1.getID(), student2.getID());
                }
            }
            return comparison;
        });
    }

    public List<Student> getStudents(List<String> events) {
        for (String event : events) {
            if (event.startsWith("SERVED")) {
                priorityQueue.poll();
            } else if (event.startsWith("ENTER")) {
                String[] pieces = event.split(" ");
                int id = Integer.parseInt(pieces[3]);
                String name = pieces[1];
                double CGPA = Double.parseDouble(pieces[2]);
                Student student = new Student(id, name, CGPA);
                priorityQueue.add(student);
            }
        }
        List<Student> studentList = new ArrayList<>();
        while (priorityQueue.peek() != null) {
            studentList.add(priorityQueue.poll());
        }
        return studentList;
    }
}
