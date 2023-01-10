// dev branch for Y.Practicum
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        try (final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int peopleCount = 0;
            int MIN_USER_COUNT=2;
            while (peopleCount < MIN_USER_COUNT) {
                System.out.println("Введите количество людей");
                peopleCount = Integer.parseInt(reader.readLine());
                if (peopleCount < MIN_USER_COUNT) {
                    System.out.println("Количество людей не может быть меньше " + MIN_USER_COUNT);
                }
            }
            final PricePlurals formatter = new PricePlurals();
            final Calculator calculator = new Calculator(reader, peopleCount, formatter);
            final CalculationResult result = calculator.calculate();
            System.out.println("Список товаров:");
            for (final String good : result.getGoodList()) {
                System.out.println(good);
            }
            final String formattedPrice = String.format("%.2f %s", result.getPricePerPerson(), result.getCurrencySuffix());
            System.out.printf("Каждый участник должен заплатить %s%n", formattedPrice);
        }
    }
}
