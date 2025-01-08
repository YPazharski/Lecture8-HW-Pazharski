package lesson_8;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.StringJoiner;

public class Employee {
    public static final int MAX_AGE = 130;
    public static final int MIN_AGE = 0;
    private String fullName;
    private String position;
    private String email;
    private String phoneNumber;
    private double salary;
    private int age;

    public Employee(@NotNull String fullName, @NotNull String position, @NotNull String email, @NotNull String phoneNumber, double salary, int age) {
        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        setAge(age);
    }

    @NotNull
    public String getFullName() {
        return fullName;
    }

    public void setFullName(@NotNull String fullName) {
        this.fullName = fullName;
    }

    @NotNull
    public String getPosition() {
        return position;
    }

    public void setPosition(@NotNull String position) {
        this.position = position;
    }

    @NotNull
    public String getEmail() {
        return email;
    }

    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    @NotNull
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(@NotNull String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public double getSalary() {
        return salary;
    }

    //no negative number check because an employee may have a debt to the company
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < MIN_AGE) {
            throw new IllegalArgumentException("Age can't be less than " + MIN_AGE);
        }

        if (age > MAX_AGE) {
            throw new IllegalArgumentException("Age can't be more than " + MAX_AGE);
        }

        this.age = age;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Employee.class.getSimpleName() + "[", "]")
                .add("fullName='" + fullName + "'")
                .add("position='" + position + "'")
                .add("email='" + email + "'")
                .add("phoneNumber='" + phoneNumber + "'")
                .add("salary=" + salary)
                .add("age=" + age)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Employee employee)) return false;
        return Double.compare(salary, employee.getSalary()) == 0 && age == employee.getAge()
                && Objects.equals(fullName, employee.getFullName()) && Objects.equals(position, employee.getPosition())
                && Objects.equals(email, employee.getEmail()) && Objects.equals(phoneNumber, employee.getPhoneNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFullName(), getPosition(), getEmail(), getPhoneNumber(), getSalary(), getAge());
    }

    public void printInfoToConsole() {
        System.out.println("================================");
        System.out.println("EMPLOYEE INFO");
        System.out.println("--------------------------------");
        System.out.println("Full name    | " + fullName);
        System.out.println("Position     | " + position);
        System.out.println("Email        | " + email);
        System.out.println("Phone number | " + phoneNumber);
        System.out.println("Salary       | " + salary);
        System.out.println("Age          | " + age);
        System.out.println("================================");
    }

}
