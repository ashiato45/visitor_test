public abstract class Entry{
    public abstract void accept(Visitor v);
    public abstract String getName();
}