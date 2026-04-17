public class DebugExample {

    public static void swap(MyObject o1, MyObject o2) {
        System.out.println("Inside swap (before): 01=" + o1.value + ", o2=" + o2.value);
        MyObject temp = o1;
        o1 = o2;
        o2 = temp;
        System.out.println("Inside swap (after): o1=" + o1.value + ", o2=" + o2.value);
    }

    public static void main(String [] args){
        MyObject a = new MyObject(10);
        MyObject b = new MyObject(20);
        System.out.println("Before swap: a=" + a.value +", b=" + b.value);
        swap(a,b);
        System.out.println("Before swap: a=" + a.value +", b=" + b.value);

    }
}

class MyObject {
    int value;

    MyObject(int value){
        this.value = value;
    }
}
