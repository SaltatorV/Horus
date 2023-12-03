package block;

import structure.Structure;

public class MockBlock implements Block{

    private final String color;
    private final String material;

    private MockBlock(String color, String material) {
        this.color = color;
        this.material = material;
    }

    public static Block createDefault() {
        return new MockBlock("black", "wood");
    }

    public static Block create(String color, String material) {
        return new MockBlock(color, material);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    @Override
    public int accept(Structure structure) {
        return structure.countBlock(this);
    }
}
