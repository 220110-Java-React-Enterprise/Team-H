package utils;

import java.util.ArrayList;
import java.util.List;

public class GlobalStore {
    private List<Object> objList;

    public GlobalStore() {
        this.objList = new ArrayList<>();
    }

    public List<Object> getObjList() {
        return this.objList;
    }

    public void setObjList(List<Object> objList) {
        this.objList = objList;
    }

    public Object getFromObjList(int index) {
        return objList.get(index);
    }

    public void addToObjList(Object obj) {
        objList.add(obj);
    }

    public void removeFromObjList(int index) {
        objList.remove(index);
    }

    public void removeFromObjList(Object obj) {
        objList.remove(obj);
    }

}
