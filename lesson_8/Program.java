package lesson_8;

import com.github.javafaker.Faker;

public class Program {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("One Aaa", "Thinker", "one.two@company.com", "+1111111", 100500, 12),
                new Employee("Two Bee", "Worker", "two.bee@company.com", "+1111112", 1.12, 78),
                new Employee("Three Csharp", "Cleaner", "three.spy@company.com", "+1111113", 7.13, 40),
                new Employee("Four Do", "Programmer", "fus.roh.dah@company.com", "+1111114", 1010010, 51),
                new Employee("Five Eee", "AQA", "one..two@company.com", "+1111115", Double.POSITIVE_INFINITY, 42),
        };

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfoToConsole();
            }
        }

        //doSomethingRedundant();
    }

    public static void doSomethingRedundant() {
        Employee[] employees = new Employee[30];
        String emailRegEx = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        String phoneNumberRegEx = "^\\+?[0-9]{1,3}?[-. ]?(\\(?\\d{1,4}?\\)?[-. ]?)?[\\d-. ]{7,10}$";
        Faker faker = new Faker();
        for (int i = 0; i < employees.length; i++) {
            String fullName = faker.name().fullName();
            String position = faker.job().position();
            double salary = faker.number().randomDouble(2, -100500, 500100);
            int age = faker.number().numberBetween(Employee.MIN_AGE, Employee.MAX_AGE);
            FieldText email;
            do {
                String emailText = faker.internet().emailAddress();
                email = new FieldText(emailText, emailRegEx);
            }
            while (!email.isCorrect);

            FieldText phoneNumber;
            do {
                String phoneNumberText = faker.phoneNumber().phoneNumber();
                phoneNumber = new FieldText(phoneNumberText, phoneNumberRegEx);
            }
            while (!phoneNumber.isCorrect);

            employees[i] = new Employee(fullName, position, email.text, phoneNumber.text, salary, age);
        }

        for (Employee employee : employees) {
            if (employee.getAge() > 40) {
                employee.printInfoToConsole();
            }
        }
    }

}
