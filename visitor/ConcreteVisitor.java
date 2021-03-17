import java.util.Iterator;

public class ConcreteVisitor extends Visitor{
    private int depth = 0;


    public void visit(File file){
        System.out.println("-".repeat(depth) + file.getName());
    }

    public void visit(Directory dir){
        System.out.println("-".repeat(depth) + dir.getName());
        depth++;
        Iterator it = dir.getIterator();
        while(it.hasNext()){
            Entry entry = (Entry)it.next();
            entry.accept(this);
        }
        depth--;
    }
}