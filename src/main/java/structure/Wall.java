package structure;

import block.Block;
import block.CompositeBlock;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure{
    private List<Block> blocks;

    private Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    public static Wall create(List<Block> blocks) {
        return new Wall(blocks);
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks
                .stream()
                .filter(block -> block.getColor().equals(color))
                .findFirst();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks
                .stream()
                .filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return blocks
                .stream()
                .mapToInt(block -> block.accept(this))
                .sum();
    }

    @Override
    public int countBlock(Block block) {
        return 1;
    }

    @Override
    public int countBlock(CompositeBlock compositeBlock) {
        return 0;
    }
}
