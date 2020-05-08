package com.haogre.dp.visitor;

//演示java的静态分派和动态分派
//结果会输出：Collection
//所以重载的分派是根据静态类型进行的
public class Dispatch {
    public static void main(String[] args) {
        FatherClass child = new ChildClass();
        new Dispatch().print(child);
        child.print();
    }

    void print(FatherClass c) {
        System.out.print("父类");
    }

    void print(ChildClass c) {
        System.out.print("子类");
    }
}

class FatherClass {
    void print() {
        System.out.println("父类");
    }
}

class ChildClass extends FatherClass {
    void print() {
        System.out.print("子类");
    }
}