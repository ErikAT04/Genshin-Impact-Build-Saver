package at.dev.genshinbuildsaver.Objects;

public class Stats {
    int id;
    int lvlNormal;
    int lvlElemental;
    int lvlUltimate;
    int cons;
    public Stats(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLvlNormal() {
        return lvlNormal;
    }

    public void setLvlNormal(int lvlNormal) {
        this.lvlNormal = lvlNormal;
    }

    public int getLvlElemental() {
        return lvlElemental;
    }

    public void setLvlElemental(int lvlElemental) {
        this.lvlElemental = lvlElemental;
    }

    public int getLvlUltimate() {
        return lvlUltimate;
    }

    public void setLvlUltimate(int lvlUltimate) {
        this.lvlUltimate = lvlUltimate;
    }

    public int getCons() {
        return cons;
    }

    public void setCons(int cons) {
        this.cons = cons;
    }
}
