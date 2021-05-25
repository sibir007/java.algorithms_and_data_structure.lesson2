package ru.geekbrains.algorithms_and_data_structure.lesson2;

public class MyIntArr implements Cloneable{
    private int[] arr;
    private int size;


    public MyIntArr(int length){
        this.arr = new int[length];
        this.size = 0;

    }
    public int getItem(int index){
        return arr[index];
    }
    public int getSize(){
        return size;
    }

    /**
     * добавляет элемент в массив
     * @param item элемент добавляемый в массив
     * @return false - если массив заполнен и не возможно добавить элемент
     * true - если добавление прошло успешно
     */
    public boolean add(int item){
        if (arr.length == size) {
            return false;
        }
        arr[size] = item;
        size++;
        return true;
    }

    /**
     * удаляет элемент из массива
     * @param item элемент который надо удалить из массива
     * @return false - в случае если массив пустой или данного элемента нет в массиве
     * true - если удаление прошло успешно
     */
    public boolean delete(int item){
        int i;
        if (size == 0) {
            return false;
        }
        for (i = 0; i < size; i++) {
            if (arr[i] == item) break;
            if(i == size - 1) {
                return false;
            }
        }
        for (int j = i; j < size - 1; j++) {
            arr[j] = arr[j+1];
        }
        size--;
        return true;
    }

    /**
     * ищет элемент в массиве
     * @param item элемент который нужно найти
     * @return индекс искомого элемента, -1 если искомого элемента в массиве нет или массив пустой
     */
    public int find (int item) {
        int i;
        if (size == 0) {
            return -1;
        }
        for (i = 0; i < size; i++) {
            if (arr[i] == item) break;
            if(i == size - 1) {
                return -1;
            }
        }
        return i;
    }

    /**
     * заполняет массив случайными числами от 0 до arr.length
     */
    public void arrRandomFill(){
        for (int i = size; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * arr.length);
            size++;
        }
    }

    /**
     * пузырьковая сортировка
     */
    public void sortBubble(){
        int out, in;
        for (out = size - 1; out >= 1; out--) {
            for(in = 0; in < out; in++) {
                if (arr[in] > arr[in + 1]) {
                    change(in, in + 1);
                }
            }
        }
    }
    private void change(int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    /**
     * сортировка методом выбора
     */
    public void sortSelect(){
        int out, in, mark;
        for(out = 0; out < size; out++){
            mark = out;
            for(in = out + 1; in <  size; in++){
                if ( arr[in] <  arr[mark]){
                    mark = in;
                }
            } change(out, mark);
        }
    }

    /**
     * сортировка методом вставки
     */
    public void sortInsert(){
        int in, out;
        for(out = 1; out <  size; out++){
            int temp =  arr[out];
            in = out;
            while(in > 0 &&  arr[in-1] >= temp){
                 arr[in] =  arr[in-1];
                in--;
            }  arr[in] = temp;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
