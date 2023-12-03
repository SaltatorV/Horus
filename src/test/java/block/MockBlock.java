package block;

public class MockBlock implements Block{

    private final String color;
    private final String material;

    private MockBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public static MockBlock createDefault() {
        return new MockBlock("black", "wood");
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}
