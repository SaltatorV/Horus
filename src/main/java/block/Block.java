package block;

import structure.Structure;

public interface Block {
    String getColor();
    String getMaterial();
    int countBlock(Structure structure);
}
