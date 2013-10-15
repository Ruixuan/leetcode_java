class DeepIterator implenments iterator{
    Stack<Iterator> s;
    public void DeepIterator(Iterator it){
        s = new Stack<Iterator>();
        s.push(it);
    }

    public Element next(){
        Iterator  top;
        top = s.get_top();
        val = top.next();
        Element ret;
        if (isInstance(val, iterator)){
            s.push(val);
            ret = next();
        }else{
           ret = val;            
        }

        if (!top.hasNext())
            s.pop();
    }

    public boolean hasNext(){
        return !s.isEmpty();
    }
    
}
