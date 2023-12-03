package structure;

import block.Block;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {



    @Test
    public void testWallCount() {
        //given
        List<Block> blocks = List.of();
        var wall = Wall.create(blocks);

        //when
        var count = wall.count();

        //then
        assertEquals(0, count);

    }

    @Test
    public void testCreateWall() {
        //given
        List<Block> blocks = List.of();

        //when
        var wall = Wall.create(blocks);

        //then
        assertEquals(0, wall.count());
    }
}
