package block;

import structure.Structure;

import java.util.List;

public class MockCompositeBlock implements CompositeBlock{
    private List<Block> blocks;
    private final String color;
    private final String material;

    private MockCompositeBlock(String color, String material, List<Block> blocks) {
        this.blocks = blocks;
        this.color = color;
        this.material = material;
    }

    public static Block create(String color, String material, List<Block> blocks) {
        return new MockCompositeBlock(color, material, blocks);
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
    public int accept(Structure visitor) {
        return visitor.countBlock(this);
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}