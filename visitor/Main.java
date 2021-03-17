public class Main {
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
        ConcreteVisitor cv = new ConcreteVisitor();
        rootDir.accept(cv);
    }
}
