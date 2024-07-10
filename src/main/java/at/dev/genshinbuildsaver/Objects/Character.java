package at.dev.genshinbuildsaver.Objects;

public class Character {
    private int id;
    private Stats stats;
    private Weapon weapon;
    private Flower flower;
    private Feather feather;
    private Sands sands;
    private Goblet goblet;
    private Crown crown;
    private String name;
    public Character(){}

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Flower getFlower() {
        return flower;
    }

    public void setFlower(Flower flower) {
        this.flower = flower;
    }

    public Feather getFeather() {
        return feather;
    }

    public void setFeather(Feather feather) {
        this.feather = feather;
    }

    public Sands getSands() {
        return sands;
    }

    public void setSands(Sands sands) {
        this.sands = sands;
    }

    public Crown getCrown() {
        return crown;
    }

    public void setCrown(Crown crown) {
        this.crown = crown;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Goblet getGoblet() {
        return goblet;
    }

    public void setGoblet(Goblet goblet) {
        this.goblet = goblet;
    }
}
