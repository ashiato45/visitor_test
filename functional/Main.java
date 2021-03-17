import java.util.Iterator;

public class Main {
    public static void walk(Entry entry, int depth){
        System.out.println("-".repeat(depth) + entry.getName());
        if(entry instanceof File){
            // do nothing
        }else if(entry instanceof Directory){
            Directory dir = (Directory)entry;
            Iterator<Entry> it = dir.getIterator();
            while(it.hasNext()){
                Entry child = it.next();
                walk(child, depth + 1);
            }
        }else{
            assert(false);
        }
    }

    public static void main(String[] args){
        // Make files and directories
        Directory rootDir = new Directory("root");
        Directory binDir = new Directory("bin");
        Directory tmpDir = new Directory("tmp");
        Directory usrDir = new Directory("usr");
        rootDir.add(binDir);
        rootDir.add(tmpDir);
        rootDir.add(usrDir);
        binDir.add(new File("vi"));
        binDir.add(new File("latex"));

        // print
        walk(rootDir, 0);
    }
}
