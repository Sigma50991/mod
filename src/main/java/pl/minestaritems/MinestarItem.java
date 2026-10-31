package pl.minestaritems;

import java.util.ArrayList;
import java.util.List;

/** Jeden "przebrany" przedmiot. Pola publiczne, zeby Gson zapisal je do config/minestaritems.json. */
public class MinestarItem {
    public String id;
    public String category;
    public String name;
    public String material;
    public boolean glint;
    public List<String> lore = new ArrayList<>();
    /** Zapamietany wyglad z prawdziwego itemu na serwerze (pusty = zwykly model materialu). */
    public String itemModel;
    public List<Float> cmdFloats = new ArrayList<>();
    public List<String> cmdStrings = new ArrayList<>();

    public MinestarItem() {}

    public MinestarItem(String category, String id, String material, String name, boolean glint, String... lore) {
        this.category = category;
        this.id = id;
        this.material = material;
        this.name = name;
        this.glint = glint;
        for (String l : lore) this.lore.add(l);
    }
}
