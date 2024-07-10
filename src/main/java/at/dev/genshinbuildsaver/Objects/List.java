package at.dev.genshinbuildsaver.Objects;

import java.util.ArrayList;

public class List {
    int id;
    private String name;
    private ArrayList<Character> charactersInList;
    public List(){}

    public ArrayList<Character> getCharactersInList() {
        return charactersInList;
    }

    public void setCharactersInList(ArrayList<Character> charactersInList) {
        this.charactersInList = charactersInList;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
