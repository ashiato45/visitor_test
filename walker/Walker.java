import java.util.Iterator;

public class Walker {
    private int depth = 0;

    public void walk(File file){
        System.out.println("-".repeat(depth) + file.getName());
    }

    public void walk(Directory dir){
        System.out.println("-".repeat(depth) + dir.getName());
        depth++;
        Iterator<Entry> it = dir.getIterator();
        while(it.hasNext()){
            Entry child = it.next();
            walk(child);
        }
        depth--;
    }

}
