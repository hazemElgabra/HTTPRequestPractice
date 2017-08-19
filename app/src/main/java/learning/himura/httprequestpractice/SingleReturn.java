package learning.himura.httprequestpractice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hazem on 8/2/2017.
 */

public class SingleReturn {
    private List<String> listOfReturns;

    public List<String> getListOfReturns() {
        return listOfReturns;
    }

    public void setListOfReturns(List<String> list){
        this.listOfReturns = list;
    }

    public int size(){
        return this.listOfReturns.size();
    }

    public SingleReturn(){
        this.listOfReturns = new ArrayList<>();
    }
}
