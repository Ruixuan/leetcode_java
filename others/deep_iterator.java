class DeepIterator implenments iterator{
    Stack<Iterator> s;
    public void DeepIterator(Iterator it){
        s = new Stack<Iterator>();
        if (s.hasNext())
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
        ret = null;
        while(!s.isEmpty()){
            top = s.top();
            if (!top.hasNext()){
                s.pop();
                continue;
            }
            val = top.next();
            if (val.isIter())
                s.push(val);
            else{
                ret = val;
                break;
            }

        }
        return ret;
    }

    public boolean hasNext(){
        return !s.isEmpty();
    }
    
}
