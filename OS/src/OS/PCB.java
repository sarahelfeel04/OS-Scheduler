package OS;

public class PCB {
    int ID;
    int pc;
    int base;
    int limit;
    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public int getPc() {
        return pc;
    }
    public void setPc(int pc) {
        this.pc = pc;
    }
    public int getBase() {
        return base;
    }
    public void setBase(int base) {
        this.base = base;
    }
    public int getLimit() {
        return limit;
    }
    public void setLimit(int limit) {
        this.limit = limit;
    }
    public PCB() {
        this.pc = 0;
    }
    public PCB(int ID, int base, int limit) {
        this.ID = ID;
        this.pc = 0;
        this.base = base;
        this.limit = limit;
    }
}
