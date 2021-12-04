package first.models;

public enum TypeOfCategory {
    Income,
    Expense,
    Both;

    static TypeOfCategory getType(String value) {
        return switch (value.toUpperCase().charAt(0)) {
            case 'I' -> Income;
            case 'E' -> Expense;
            case 'B' -> Both;
            default -> null;
        };
    }
}
