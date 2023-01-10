import java.io.BufferedReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Calculator {

    private static final String TERMINATE_COMMAND = "завершить";
    private static final char PRICE_DELIMITER = '.';
    private static final char MIN_DIGIT = '0';
    private static final char MAX_DIGIT = '9';

    private final BufferedReader reader;
    private final int peopleCount;
    private final PricePlurals formatter;

    public Calculator(BufferedReader reader, int peopleCount, PricePlurals formatter) {
        this.reader = reader;
        this.peopleCount = peopleCount;
        this.formatter = formatter;
    }

    public CalculationResult calculate() throws IOException {
        final List<String> goodList = new LinkedList<>();
        float totalPrice = 0F;
        while (true) {
            System.out.println("Введите наименование товара");
            final String good = reader.readLine();
            float price = 0F;
            while (price <= 0) {
                System.out.println("Введите цену товара. Число должно быть положительным.");
                final String potentialPrice = reader.readLine();
                if (isNotValidPrice(potentialPrice)) {
                    System.out.println("Цена введена неправильно. Разрешены только цифры и формате 0,00 или 0 ");
                    continue;
                }
                price += Float.parseFloat(potentialPrice);
            }
            goodList.add(good);
            totalPrice += price;
            System.out.println("Товар успешно добален");
            System.out.println("Напишите любой символ для добавления товара\n"  + "или слово \"Завершить\" если хотите перейти к расчетам  ");
            final String command = reader.readLine();
            if (TERMINATE_COMMAND.equalsIgnoreCase(command)) {
                break;
            }
        }
        System.out.println("Общая сумма составила "+ totalPrice +" руб.");
        final float pricePerPerson = totalPrice / peopleCount;
        final String currencySuffix = formatter.getSuffix(pricePerPerson);
        return new CalculationResult(goodList, pricePerPerson, currencySuffix);
    }

    private boolean isNotValidPrice(String price) {
        boolean dotIncluded = false;
        final int length = price.length();
        for (int i = 0; i < length; ++i) {
            final char symbol = price.charAt(i);
            if (symbol == PRICE_DELIMITER) {
                if (dotIncluded) return true;
                dotIncluded = true;
                continue;
            }
            if (symbol < MIN_DIGIT || symbol > MAX_DIGIT) {
                return true;
            }
        }
        return false;
    }
}
