##学习笔记

二叉搜索树(Binary Search Tree)：
二叉搜索树，也称二叉排序树、有序二叉树（Ordered Binary Tree），
排序二叉树(Sorted Binary Tree), 是指一棵空树或者具有下列性质的
二叉树：
1. 左子树上所有结点的值均小于它的根结点的值；
2. 右子树上所有结点的值均小于它的根结点的值；
3. 以此类推：左右子树也分别为二叉查找树（这就是重复性）

---

### 二叉树遍历
栈的方式遍历，或者递归遍历


### HashMap 小结
- MAX_CAPACITY: 1 << 30
- DEFAULT_LOAD_FACTOR = 0.75f
- TREEIFY_THRESHOLD = 8;
- MIN_TREEIFY_CAPACITY = 64;

#### HashMap初始化有三种方式：
- HashMap(int initialCapacity, float loadFactor)
- HashMap(int initialCapacity)
- HashMap()

初始化时，并不会初始化数组，只会设置 threshold和load factor
HashMap中的数组，当首次调用put方法时，才会根据已经存在的threshold和load factor初始化

#### putVal
- 如果数组对应（hash & (n - 1)）位置没有元素，则直接添加进去
- 如果数组对应位置存在node, 
    a. 那么如果hash相等，key也相等，则替换原有的node
    b. 如果是tree node，插入
    c. 遍历bin内的所有元素，如果没有hash和key相等的，执行插入（链表或者达到TREEIFY_THRESHOLD进行treeify）。如果有则替换。

#### resize
- 如果存在数组，则double size 和 threshold

#### Treeify
HashMap 数组大小超过MIN_TREEIFY_CAPACITY才符合treeify的条件