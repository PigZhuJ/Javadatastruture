package Linklist;

import java.util.Iterator;
import java.util.function.Consumer;

public class myLink<T> implements Iterator<T> {
    public  int length;//定义链表的长度
    Lnode<T> first, last;//定义头指针，尾指针

    //空参构造
    public myLink() {
        first = last = null;
        length = 0;
    }

    //比较器，内部使用
    private int compare(Lnode<T> a, Lnode<T> b) {
        return a.compareTo(b);
    }

    //删除整个链表
    public void clear() {
        first = last = null;
        length = 0;
    }

    //删除整个链表
    public void removeAll() {
        clear();
    }

    //获得内部结点,获取索引位置为i的结点的值，索引从0开始
    public Lnode<T> getNode(int i) {
        if (i < 0 || i > length - 1) {
            throw new IndexOutOfBoundsException("索引越界异常");//索引越界异常
        } else if (i == 0) {//i=0位置是头指针
            return first;
        } else {
            Lnode<T> p = first;
            int j = 0;
            while (p != null && j < i) {//当p不是空结点并且没有遍历到i的时候一直向后遍历
                p = p.next;
                j++;
            }
            return p;
        }
    }

    /**
     * 取得某个结点的值
     *
     * @param int i 为某个位置的索引
     */
    public T getData(int i) {
        Lnode<T> p = getNode(i);
        if (p == null) {
            return null;//如果p是值为空那么久返回空
        } else {
            return p.data;
        }
    }

    /**
     * 修改某个结点的值
     *
     * @param i 修改位置的索引
     * @param x 修改指定位置的值
     * @return 返回布尔类型的值，如果修改成功则为true；如果修改不成功则为false
     */
    public boolean setData(int i, T x) {
        Lnode<T> p = getNode(i);
        if (p == null) {
            return false;//如果修改失败那么返回false;
        } else {
            p.data = x;
            return true;//如果修改成功则返回true;
        }
    }

    /**
     * 在不带头结点的链表中增加结点可以分为以下四种情况：
     * 1.向空链表中插入一个结点
     * 2.向链表的头结点之前插入结点
     * 3.向链表的尾部插入结点
     * 4.向链表中插入结点
     * 只有这四种插入新的结点的情况出现；
     *
     * @param i 参数i表示插入的位置；
     * @param x 参数x表示插入的值；
     */
    public void add(int i, T x) {
        Lnode<T> p,s;//创建两个结点，一个市插入的结点，一个是插入的前驱结点；
        int j=i-1;
        s=new Lnode<T>(x,null);//Lnode的构造函数，指向下一个结点
        //1.向空链表中插入一个结点
        if(first==null||length==0){//如果头指针为空或者链表的长度为空那么就代表着这个链表就是一个空链表。
            //s既指向头指针又指向尾指针；
            first=s;//first指向下一个几点
            last=s;//last也指向s s
//            return true;
        }else if(j<0){
            //2.向链表的头结点之前插入结点
            //first中记录的是原先第一个结点的值，现在要把first的值转移给s记住下一个结点的值
            s.next=first;//把first的值
            first=s;//然后再把s的值赋给first，让它记住插入结点s的值；
//            return true;
        }else if(j>=length-1){
            //3.向链表的尾部插入结点
            //last中原来记住的是原来链表的尾结点的
            //现在添加了新的结点之后就让last指向新的结点，并且前一个结点的值要指向s
            last.next=s;//last代表了前一个结点，指向了s
            last=s;//并且last要指向s；
//            return true;
        }else{
            //4.向链表中插入结点
            p=getNode(j);
            s.next=p.next;//让s记住原来p的下一个结点值；
            p.next=s;//让p记住s的值；
//            return true;
        }
        //任何一种情况增加完结点值那么就要让链表的长度+1
        length++;
    }
//我们一直使用的都是后插法；
//如果我们使用前插法的话，也就是将结点s插入到结点p之前
// 分为以下两种情况来分析：
//    1.结点p已经是第一个结点了
    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public void remove() {

    }

    @Override
    public void forEachRemaining(Consumer<? super T> action) {

    }
}
