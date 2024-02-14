package models;

import java.util.List;

public class NpcFactory {

    private String name;
    private List<String> dialogue;
    private String graphic;
    private String death;
    private String alignment;
    private int health;

    // constructor
    public NpcFactory(String name, List<String> dialogue, String graphic, String death, String alignment, int health) {
        this.setName(name);
        this.setDialogue(dialogue);
        this.setGraphic(graphic);
        this.setDeath(death);
        this.setAlignment(alignment);
        this.setHealth(health);
    }

    // getters and setters
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDialogue() {
        return dialogue;
    }

    public void setDialogue(List<String> dialogue) {
        this.dialogue = dialogue;
    }

    public String getGraphic() {
        return graphic;
    }

    public void setGraphic(String graphic) {
        this.graphic = graphic;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getAlignment() {
        return alignment;
    }

    public void setAlignment(String alignment) {
        this.alignment = alignment;
    }
}