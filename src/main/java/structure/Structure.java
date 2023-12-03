package structure;

import block.Block;
import block.CompositeBlock;

import java.util.List;
import java.util.Optional;

public interface Structure {
    Optional<Block> findBlockByColor(String color);
    List<Block> findBlocksByMaterial(String material);
    int count();
    int countBlock(Block block);
    int countBlock(CompositeBlock compositeBlock);
}
