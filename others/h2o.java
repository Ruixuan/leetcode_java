class H2O{
    Integer h_count,o_count, flag;
    public H2O(){
        h = new Integer(0);
        o = new Integer(0);
    }

    public void h(){
        h_semaphore.wait();
        mutex.aquire();
        h_count ++;
        if (h_count == 2 && o_count == 1){
            // produce a water
            h_count = 0;
            o_count = 0;
            cvar.notifyall();
        }else
            cvar.wait();
        mutex.release();    

    }
    public void o(){
        o_semaphore.wait();
        mutex.aquire();
        o_count ++;
        //similar to h operation
    }

   }
