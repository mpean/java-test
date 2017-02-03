package genericExample;

import static java.lang.System.*;

/**
 * Created by mpean on 03/02/17.
 */
public class TestGeneric {

    public static void main(String[] args){
        Box<Integer> bi = createBox();
        out.println("xim: "+bi);
    }

    private static Box createBox(){
        return new Box();
    }
}
