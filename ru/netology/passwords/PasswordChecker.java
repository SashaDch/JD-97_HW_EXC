package ru.netology.passwords;

public class PasswordChecker {
    private Integer minLength;

    private Integer maxRepeats;


    public void setMinLength(int minLength) throws IllegalArgumentException {
        if (minLength < 0) {
            throw new IllegalArgumentException("Parameter minLength must be non-negative!");
        }
        this.minLength = minLength;
    }

    public void setMaxRepeats(int maxRepeats) throws IllegalArgumentException {
        if (maxRepeats <= 0) {
            throw new IllegalArgumentException("Parameter maxRepeats must be positive!");
        }
        this.maxRepeats = maxRepeats;
    }

    public boolean verify(String password) throws IllegalStateException {
        if (minLength == null || maxRepeats == null) {
            throw new IllegalStateException("Some parameters is not set: " +
                    (minLength == null ? "minLength" : "") +
                    (minLength == null && maxRepeats == null ? ", " : "") +
                    (maxRepeats == null ? "maxRepeats" : "") +
                    "!");
        }
        return password.length() >= this.minLength && repeatsNotExceeded(password, this.maxRepeats);
    }

    private static boolean repeatsNotExceeded(String string, int repeats) {
        int n = 1;

        for (int i = 1; i < string.length(); i++) {
            if (string.charAt(i) == string.charAt(i - 1)) {
                n++;
            } else {
                n = 1;
            }
            if (n > repeats) {
                return false;
            }
        }
        return true;
    }
}
