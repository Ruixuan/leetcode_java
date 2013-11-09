class EvenIterator<Integer> implements Iterator{
    Iterator it;
    Integer curr;
    private void update(){
        curr = null;
        while(curr == null && it.hasNext()){
            Integer tmp = it.next();
            if(tmp % 2 == 0)
                curr = tmp;
        }
    }

    public boolean hasNext(){
        return curr != null;
    }

    public Integer next(){
        Integer tmp = curr;
        if (tmp == null)
            throws("Iterator End!\n");
        update();
        return tmp;
    }

    public EvenIterator(Iteraor<E> it){
        this.it = it;
        update();
    }
}
