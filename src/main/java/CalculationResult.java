import java.util.List;

public class CalculationResult {

    private final List<String> goodList;
    private final float pricePerPerson;
    private final String currencySuffix;

    public CalculationResult(List<String> goodList, float pricePerPerson, String currencySuffix) {
        this.goodList = goodList;
        this.pricePerPerson = pricePerPerson;
        this.currencySuffix = currencySuffix;
    }

    public float getPricePerPerson() {
        return pricePerPerson;
    }

    public List<String> getGoodList() {
        return goodList;
    }

    public String getCurrencySuffix() {
        return currencySuffix;
    }
}

