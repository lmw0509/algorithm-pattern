package heap;

/**
 * 堆的常用方法：
 * (1)构建优先队列
 * (2)支持堆排序
 * (3)快速找出一个集合中的最小值（或者最大值）
 *
 * @since 2021-02-27
 */
public class Heap {

    // 存储元素的数组
    private final int[] queue;

    // 当前queue中的元素个数
    private int size = 0;

    public Heap(final int cap) {
        if (cap < 1) {
            throw new IllegalArgumentException();
        }
        this.queue = new int[cap + 1];
    }

    // 用完全二叉树来构建堆
    // 前置条件 起点为 1
    // 子节点为 i*2 和 i*2 + 1
    // 核心方法为sink 交换下沉, swim 交换上浮
    public Heap(final int[] arr) {
        // 索引 0 不用，所以多分配一个空间
        size = arr.length;
        queue = new int[arr.length + 1];
        int i = 1;
        for (final int val : arr) {
            queue[i++] = val;
        }
    }

    // 父节点的索引
    int parent(final int root) {
        return root / 2;
    }

    // 左孩子的索引
    int left(final int root) {
        return root * 2;
    }

    // 右孩子的索引
    int right(final int root) {
        return root * 2 + 1;
    }

    // 交换数组的两个元素
    private void exch(final int i, final int j) {
        final int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    // pq[i]是否比pq[j]小
    private boolean less(final int i, final int j) {
        return queue[i] < queue[j];
    }

    // 上浮第 k 个元素，以维护最大堆性质
    private void swim(int k) {
        // 如果浮到堆顶，就不能再上浮了
        while (k > 1 && less(parent(k), k)) {
            // 如果第 k 个元素比上层大
            // 将 k 换上去
            exch(parent(k), k);
            k = parent(k);
        }
    }

    // 下沉第 k 个元素，以维护最大堆性质
    private void sink(int k) {
        // 如果沉到堆底，就沉不下去了
        while (left(k) <= size) {
            // 先假设左边节点较大
            int older = left(k);
            // 如果右边节点存在，比一下大小
            if (right(k) <= size && less(older, right(k))) {
                older = right(k);
            }
            // 结点 k 比俩孩子都大，就不必下沉了
            if (less(older, k)) {
                break;
            }
            // 否则，不符合最大堆的结构，下沉 k 结点
            exch(k, older);
            k = older;
        }
    }

    // 返回当前队列中最大元素
    public int max() {
        return queue[1];
    }

    // 插入元素
    public void insert(final int e) {
        size++;
        // 先把新元素加到最后
        queue[size] = e;
        // 然后让它上浮到正确的位置
        swim(size);
    }

    // 删除并返回当前队列中最大元素
    public int delMax() {
        // 最大堆的堆顶就是最大元素
        final int max = queue[1];
        // 把这个最大元素换到最后，删除之
        exch(1, size);
        size--;
        // 让queue[1]下沉到正确位置
        sink(1);
        return max;
    }
}
