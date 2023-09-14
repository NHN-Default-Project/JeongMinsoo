package Excercise3_5;

public class CitySales {

    private final String name;
    private double sales;

    public CitySales(String str) {
        int index = str.indexOf(":");
        if (index == -1) {
            throw new IllegalArgumentException("");
        }
        this.name = str.substring(0, index);
        String sales = str.substring(str.indexOf(":") + 1).replaceAll("[^A-Za-z0-9가-힣.]", "");

        try {
            Double.parseDouble(sales);
            this.sales = Double.parseDouble(sales);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public double getSales() {
        return this.sales;
    }

    public String getName() {
        return this.name;
    }

}
