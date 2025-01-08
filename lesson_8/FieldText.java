package lesson_8;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FieldText {
    public final String text;
    public final String verifyingRegEx;
    public final boolean isCorrect;

    public FieldText(@NotNull String text, String verifyingRegEx) {
        this.text = text;
        this.verifyingRegEx = verifyingRegEx;
        if (verifyingRegEx == null) {
            isCorrect = true;
        }
        else {
            Pattern regExPattern = Pattern.compile(verifyingRegEx);
            Matcher matcher = regExPattern.matcher(text);
            isCorrect = matcher.matches();
        }
    }

    public FieldText(@NotNull String text) {
        this.text = text;
        verifyingRegEx = null;
        isCorrect = true;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof FieldText fieldText)) return false;
        return Objects.equals(text, fieldText.text) && Objects.equals(verifyingRegEx, fieldText.verifyingRegEx);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, verifyingRegEx);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", FieldText.class.getSimpleName() + "[", "]")
                .add("text='" + text + "'")
                .add("verifyingRegEx='" + verifyingRegEx + "'")
                .add("isCorrect=" + isCorrect)
                .toString();
    }

}
