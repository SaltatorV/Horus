package structure;

import block.Block;

import java.util.List;

public class Wall {
    private List<Block> blocks;

    private Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    public static Wall create(List<Block> blocks) {
        return new Wall(blocks);
    }

    public int count() {
        return blocks.size();
    }
}
