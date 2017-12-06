package Linklist;

/**
 * 链表的节点类
 */
class Lnode<T> implements Comparable<Lnode<T>> {
    public T data;          //结点保存的数据
    public Lnode<T> next;   //指向下一个结点的指针
    public Lnode(T key){    //构造函数,传入data，但是不指向下一个结点node
        data=key;
        next=null;
    }
    //构造函数，传入data,并且指向下一个结点
    public Lnode(T key,Lnode<T> next){
        data=key;
        this.next=next;
    }
    //重写equals方法
    @Override
    public boolean equals(Object obj) {
        Lnode<T> node=(Lnode<T>)obj;
        return data.equals(node.data);
    }
    //实现comparable接口的是comparableTo方法，用于链表结点表示大小
    //这里比较的是链表的结点，并且类型T必须是Comparable的子类，换句话说，类型T必须实现Comparable接口
    @Override
    public int compareTo(Lnode<T> lnode) {
        Comparable<T> x;
        if(data instanceof Comparable){
            x=(Comparable<T>)data;
            return (int)x.compareTo(lnode.data);
        }else{
          throw new ClassCastException("无法比较");
        }
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
