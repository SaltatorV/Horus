package structure;

import block.Block;
import block.MockBlock;
import block.MockCompositeBlock;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
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
    public void testWallCountWithCompositeBlockIs3() {
        //given
        List<Block> blocks = Arrays.asList(MockBlock.createDefault(), MockBlock.createDefault());
        Block box = MockCompositeBlock.create("black", "wood", blocks);
        var wall = Wall.create(List.of(box));

        //when
        var count = wall.count();

        //then
        assertEquals(3, count);
    }

    @Test
    public void testWallCountWithNestedCompositeBlock() {
        //given
        List<Block> blocks = Arrays.asList(MockBlock.createDefault(), MockBlock.createDefault());
        Block box = MockCompositeBlock.create("black", "wood", blocks);
        Block multiBox = MockCompositeBlock.create("black", "wood",
                Arrays.asList(MockBlock.createDefault(), box));

        var wall = Wall.create(List.of(multiBox));

        //when
        var count = wall.count();

        //then
        assertEquals(5, count);
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
                .forEach(block -> assertEquals(materialToFind, block.getMaterial()));
    }
}