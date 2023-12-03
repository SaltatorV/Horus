package structure;

import block.Block;

import java.util.List;
import java.util.Optional;

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
        return null;
    }

    @Override
    public int count() {
        return blocks.size();
    }
}
