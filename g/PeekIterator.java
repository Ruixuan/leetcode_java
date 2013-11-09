class PeekIterator implements Iterator<E>{
    private E curr;
    private Iterator<E> it;
    private void update(){
        // let curr point to the next val in iterator or null if hasNext == false
        curr = null;
        if (it.hasNext())
            curr = it.next();
    }

    public E peek(){
        return curr;
    }

    public E next(){
        if (curr == null)
            throws("No next! \n");
        E tmp = curr;
        update();
        return tmp;
    }

    public boolean hasNext(){
        return curr != null;
    }

    public PeekIterator(Iterator<E> it){
        this.it = it;
        update();
    }
}

