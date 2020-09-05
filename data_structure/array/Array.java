package array;

/**
 * 1、数组的插入、删除、按照下标随机访问操作 2、数组中的数据是int类型的
 */
public class Array {
    // 定义整型数据data保存数据
    public int[] data;

    // 定义数组容量
    private final int n;

    // 定义中实际个数
    private int count;

    // 构造方法，初始化数组容量
    public Array(final int capacity) {
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    // 查找
    public int find(final int index) {
        if (index < 0 || index >= count) {
            return -1;
        }
        return data[index];
    }

    // 插入元素:头部插入，尾部插入
    public boolean insert(final int index, final int value) {
        // 数组空间已满
        if (count == n) {
            System.out.println("没有可插入的位置");
            return false;
        }

        // 插入位置不合法
        if (index < 0 || index > count) {
            System.out.println("位置不合法");
            return false;
        }

        // 插入位置合法
        // 插入位置之后的元素整体后移
        for (int i = count; i > index; --i) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        ++count;
        return true;
    }

    // 删除
    public boolean delete(final int index) {
        if (index < 0 || index >= count) {
            return false;
        }
        // 删除位置后面的元素整体向前移动一位
        for (int i = index + 1; i < count; ++i) {
            data[i - 1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(final String[] args) {
        final Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        // array.insert(3, 11);
        array.printAll();
    }
}
