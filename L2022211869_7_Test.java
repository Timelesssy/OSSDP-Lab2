import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;


/**
 * 测试类编写时主要关注的原则是等价类划分和边界值分析
 */
public class L2022211869_7_Test {
    private final Solution7 solution = new Solution7();

    // 测试空字符串
    /**
     * 测试目的：
     * 确保方法能正确处理空字符串的情况。在这种情况下，没有字符可以交换，所以输出应该是空字符串。
     * 测试用例：
     * 输入："" （空字符串）
     * 索引对列表：List.of() （空列表）
     * 期望输出："" （空字符串）
     */
    @Test
    public void testEmptyString() {
        assertEquals("", solution.smallestStringWithSwaps("", List.of()));
    }

    // 测试单个字符的字符串
    /**
     * 测试目的：
     * 验证方法能正确处理只有一个字符的字符串。这种情况下同样没有任何交换发生，因此输出应该与输入相同。
     * 测试用例：
     * 输入："a" （单个字符）
     * 索引对列表：List.of() （空列表）
     * 期望输出："a" （单个字符）
     */
    @Test
    public void testSingleCharacter() {
        assertEquals("a", solution.smallestStringWithSwaps("a", List.of()));
    }

    // 测试多个字符的字符串，无交换
    /**
     * 测试目的：
     * 验证方法能正确处理包含多个字符但没有指定任何索引对的字符串。在这种情况下，由于没有指定交换，输出应该与输入字符串相同。
     * 测试用例：
     * 输入："abcd" （多个字符）
     * 索引对列表：List.of() （空列表）
     * 期望输出："abcd" （多个字符）
     */
    @Test
    public void testMultipleCharactersNoSwap() {
        assertEquals("abcd", solution.smallestStringWithSwaps("abcd", List.of()));
    }

    // 测试多个字符的字符串，有交换
    /**
     * 测试目的：
     * 验证方法能正确处理包含多个字符并指定有效的索引对进行交换的情况。在这种情况下，输入字符串应该按照索引对进行交换，并返回按字典序最小的字符串。
     * 测试用例：
     * 输入："dcab" （多个字符）
     * 索引对列表：List.of(List.of(0, 3), List.of(1, 2)) （有效的索引对）
     * 期望输出："bacd" （交换后的字符串）
     */
    @Test
    public void testMultipleCharactersWithSwap() {
        List<List<Integer>> pairs = List.of(List.of(0, 3), List.of(1, 2));
        assertEquals("bacd", solution.smallestStringWithSwaps("dcab", pairs));
    }

    // 测试多个字符的字符串，复杂交换
    /**
     * 测试目的：
     * 验证方法能正确处理包含多个字符并且索引对列表导致多个连通分量的情况。在这种情况下，输出应该是所有连通分量内部字符按字典序排序后的结果。
     * 测试用例：
     * 输入："dcab" （多个字符）
     * 索引对列表：List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2)) （复杂的索引对）
     * 期望输出："abcd" （所有连通分量内的字符按字典序排序后的结果）
     */
    @Test
    public void testComplexSwap() {
        List<List<Integer>> pairs = List.of(List.of(0, 3), List.of(1, 2), List.of(0, 2));
        assertEquals("abcd", solution.smallestStringWithSwaps("dcab", pairs));
    }
}
