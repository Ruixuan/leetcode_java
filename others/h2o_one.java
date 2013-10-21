class H2O{
    int h,o,flag;
    void h(){
        synchronized(this){
            while(h >= 2) wait();
            h ++;
            while(flag != 1) wait();
            hh ++;

        }
        
    }

    void controller(){
        synchronized(this){
            while (h < 2 or o < 1) wait();
            flag = 1;           
            notifyall();
            while(hh != 2 || oo != 1) wait();
            flag = 0;
            h = 0;
            o = 0;
            hh = 0;
            oo = 0;
            notifyall();
        }
    }
}
