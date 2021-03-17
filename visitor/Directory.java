import java.util.ArrayList;
import java.util.Iterator;

public class Directory extends Entry{
    private String name;
    private ArrayList dir = new ArrayList();

    public Directory(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public void add(Entry entry){
        this.dir.add(entry);
    }

    public Iterator getIterator(){
        return dir.iterator();
    }

    public void accept(Visitor v){
        v.visit(this);
    }
}