package random.semester.map;

import org.apache.commons.collections.MapUtils;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * Created by eljah32 on 4/8/2019.
 */
public class RandomizedSemesterWork2Distribution {
    public static void main(String[] args) {
        List<String> semesterWork = new ArrayList<String>();
        semesterWork.add("АВЛ-деревья");
        semesterWork.add("Красно-чёрное дерево");
        semesterWork.add("Биномиальная куча");
        semesterWork.add("Фибоначчиева куча");
        semesterWork.add("Расширяющееся (Splay) дерево");
        semesterWork.add("В-деревоt");
        semesterWork.add("2-3 дерево");
        semesterWork.add("Дерево Фенвика");
        semesterWork.add("Дерево отрезков");
        semesterWork.add("АА-дерево");
        semesterWork.add("B+ дерево");
        semesterWork.add("Хэш-таблица");
        System.out.println("Количество тем: " + semesterWork.size());

        List<Student> students = new ArrayList<>();
        students.add(new Student("Алиев", "Эмин"));
        students.add(new Student("Афанасьев", "Никита"));
        students.add(new Student("Блинов", "Ренат"));
        students.add(new Student("Буланова", "Камилла"));
        students.add(new Student("Гатауллин", "Эдгар"));
        students.add(new Student("Гатин", "Камиль"));
        students.add(new Student("Гильмутдинов", "Ильназ"));
        students.add(new Student("Гимазов", "Булат"));
        students.add(new Student("Гордеев", "Сергей"));
        students.add(new Student("Губайдуллин", "Рамис"));
        students.add(new Student("Дмитриев", "Михаил"));
        students.add(new Student("Егорова", "Анастасия"));
        students.add(new Student("Кадыров", "Самат"));
        students.add(new Student("Корченов", "Руслан"));
        students.add(new Student("Мамедов", "Радимир"));
        students.add(new Student("Мухутдинова", "Алия"));
        students.add(new Student("Мялицин", "Максим"));
        students.add(new Student("Низамов", "Салават"));
        students.add(new Student("Самигуллин", "Илья"));
        students.add(new Student("Хакимов", "Артем"));
        students.add(new Student("Харисов", "Эмиль"));
        students.add(new Student("Чербаева", "Дарья"));
        students.add(new Student("Шигабутдинов", "Марат"));
        students.add(new Student("Иванов", "Артем"));

        System.out.println("Всего студентов: " + students.size());
        System.out.println(students.toString());

        Map<String,List<Student>> distribution=semesterWork.stream().collect(Collectors.toMap(sw1->sw1, sw1->{List<Student> studentList= new ArrayList<Student>();populate2RandomUniqueStudents(studentList,students);return studentList;}));

        //System.out.println(distribution);
        //MapUtils.debugPrint(System.out, "Распределение тем", distribution);

        for (String s: distribution.keySet())
        {
            System.out.format("%s: %s %s, %s %s",s,distribution.get(s).get(0).getFirstName(),distribution.get(s).get(0).getSecondName(),distribution.get(s).get(1).getFirstName(),distribution.get(s).get(1).getSecondName());
            System.out.println();
        }
    }

    static void populate2RandomUniqueStudents(List<Student> setToBePopulated, List<Student> listOfInitialValues)
    {
        Student student=listOfInitialValues.get(ThreadLocalRandom.current().nextInt(listOfInitialValues.size()));
        listOfInitialValues.remove(student);
        setToBePopulated.add(student);
        Student student2=listOfInitialValues.get(ThreadLocalRandom.current().nextInt(listOfInitialValues.size()));
        listOfInitialValues.remove(student2);
        setToBePopulated.add(student2);
    }
}
