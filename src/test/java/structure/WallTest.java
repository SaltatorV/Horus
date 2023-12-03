package structure;

import block.Block;
import block.MockBlock;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
