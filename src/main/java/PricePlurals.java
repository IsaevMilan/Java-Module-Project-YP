public class PricePlurals {

    private static final int RADIX = 10;
    private static final int REMAINDER_ONE = 1;
    private static final int REMAINDER_TWO = 2;
    private static final int REMAINDER_THREE = 3;
    private static final int REMAINDER_FOUR = 4;
    private static final int ELEVEN = 11;
    private static final int TWELVE = 12;
    private static final int THIRTEEN = 13;
    private static final int FOURTEEN = 14;

    public String getSuffix(float price) {
        final int roundedPrice = (int) price;
        final int lastDigit = roundedPrice % RADIX;
        if (lastDigit == REMAINDER_ONE && roundedPrice != ELEVEN) return "рубль";
        if (lastDigit == REMAINDER_TWO && roundedPrice != TWELVE) return "рубля";
        if (lastDigit == REMAINDER_THREE && roundedPrice != THIRTEEN) return "рубля";
        if (lastDigit == REMAINDER_FOUR && roundedPrice != FOURTEEN) return "рубля";
        return "рублей";
    }
}

