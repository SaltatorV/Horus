package structure;

import block.Block;
import block.MockBlock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class WallTest {

    @Test
    public void testWallCountIs0() {
        //given
        List<Block> blocks = List.of();
        var wall = Wall.create(blocks);

        //when
        var count = wall.count();

        //then
        assertEquals(0, count);
    }

    @Test
    public void testWallCountIs2() {
        //given
        List<Block> blocks = List.of(MockBlock.createDefault(), MockBlock.createDefault());
        var wall = Wall.create(blocks);

        //when
        var count = wall.count();

        //then
        assertEquals(2, count);
    }

    @Test
    public void testCreateEmptyWall() {
        //given
        List<Block> blocks = List.of();

        //when
        var wall = Wall.create(blocks);

        //then
        assertEquals(0, wall.count());
    }

    @Test
    public void testCreateWallWith2Elements() {
        //given
        List<Block> blocks = List.of(MockBlock.createDefault(), MockBlock.createDefault());

        //when
        var wall = Wall.create(blocks);

        //then
        assertEquals(2, wall.count());
    }

    @Test
    public void testFindBlockByColorReturnEmpty() {
        //given
        List<Block> blocks = List.of();
        var wall = Wall.create(blocks);

        //when
        var block = wall.findBlockByColor("red");

        //then
        assertTrue(block.isEmpty());
    }

    @Test
    public void testFindBlockByColor() {
        //given
        List<Block> blocks = List.of(MockBlock.create("grey", "stone"),
                MockBlock.create("black", "wood"));

        var wall = Wall.create(blocks);

        //when
        var block = wall.findBlockByColor("grey");

        //then
        assertTrue(block.isPresent());
        assertEquals("grey", block.get().getColor());
        assertEquals("stone", block.get().getMaterial());
    }

    @Test
    public void testFindBlocksByMaterialReturnEmpty() {
        //given
        List<Block> blocks = List.of();
        var wall = Wall.create(blocks);

        //when
        var blockList = wall.findBlocksByMaterial("wood");

        //then
        assertEquals(0, blockList.size());
    }

    @Test
    public void testFindBlocksByMaterialReturn2() {
        //given
        String materialToFind = "stone";

        List<Block> blocks = List.of( MockBlock.create("grey", "stone"),
                MockBlock.create("black", "stone"),
                MockBlock.create("black", "wood"));

        var wall = Wall.create(blocks);

        //when
        var blockList = wall.findBlocksByMaterial(materialToFind);

        //then
        assertEquals(2, blockList.size());
        assertListContainOnlySpecificMaterial(blockList, materialToFind);
    }



    private void assertListContainOnlySpecificMaterial(List<Block> blocks, String materialToFind) {
        blocks
                .stream()
                .forEach(block -> assertEquals(materialToFind, block.getMaterial()));
    }
    
}
