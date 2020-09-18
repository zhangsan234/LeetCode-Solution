import java.util.List;

/**
 * @author Zhangsan
 * @date 2020/9/18 16:57
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> lists = solution.permuteUnique(new int[]{1, 1, 1, 1, 3});
        System.out.println(lists);
    }
}
