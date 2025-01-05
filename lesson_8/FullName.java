package lesson_8;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class FullName {

    private static final String PATTERN_REGEX = "^[A-ZА-Я][a-zа-я'\\-]+\\s[A-ZА-Я][a-zа-я'\\-]+(\\s[A-ZА-Я][a-zа-я'\\-]+)?$";
    private static final Pattern COMPILED_PATTERN;
    private String name;

    static {
        COMPILED_PATTERN = Pattern.compile(PATTERN_REGEX);
    }

    public FullName(@NotNull String name) {
        setName(name);
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(@NotNull String name) {
        Matcher matcher = COMPILED_PATTERN.matcher(name);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("Input name \"" + name + "\" has wrong format.");
        }

        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FullName fullName)) return false;
        return Objects.equals(name, fullName.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(name);
    }

    @Override
    public String toString() {
        return "FullName{" +
                "name='" + name + '\'' +
                '}';
    }
}
