package pl.minestaritems;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.fabricmc.loader.api.FabricLoader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Config: .minecraft/config/minestaritems.json (lista itemow do edycji + zapamietane przebrania). */
public final class Store {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    public static class Data {
        public List<MinestarItem> items = new ArrayList<>();
        /** odcisk przedmiotu w rece -> id itemu Minestara */
        public Map<String, String> disguises = new LinkedHashMap<>();
    }

    public static Data data = new Data();

    private static Path file() {
        return FabricLoader.getInstance().getConfigDir().resolve("minestaritems.json");
    }

    public static void load() {
        Path f = file();
        try {
            if (Files.exists(f)) {
                Data d = GSON.fromJson(Files.readString(f, StandardCharsets.UTF_8), Data.class);
                if (d != null && d.items != null && !d.items.isEmpty()) {
                    if (d.disguises == null) d.disguises = new LinkedHashMap<>();
                    data = d;
                    return;
                }
            }
        } catch (Exception e) {
            System.err.println("[minestaritems] Nie udalo sie wczytac configu, uzywam domyslnych: " + e);
        }
        data = new Data();
        data.items = Defaults.items();
        save();
    }

    public static void save() {
        try {
            Files.writeString(file(), GSON.toJson(data), StandardCharsets.UTF_8);
        } catch (IOException e) {
            System.err.println("[minestaritems] Nie udalo sie zapisac configu: " + e);
        }
    }

    public static MinestarItem byId(String id) {
        for (MinestarItem i : data.items) if (i.id.equals(id)) return i;
        return null;
    }
}
