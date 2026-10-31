package pl.minestaritems;

import java.util.ArrayList;
import java.util.List;

/**
 * Domyslna lista itemow Minestar (nazwy i opisy wg pluginu Dream-CustomMinestarItems).
 * Materialy (bazowy przedmiot, ktory trzymasz w rece) przy czesci itemow sa odgadniete -
 * zmienisz je w config/minestaritems.json (pole "material").
 */
final class Defaults {
    private Defaults() {}

    static List<MinestarItem> items() {
        List<MinestarItem> l = new ArrayList<>();
        String B = "Bronie", N = "Narzędzia", R = "Rzucane i pola", I = "Inne";

        // ---------- BRONIE ----------
        l.add(new MinestarItem(B, "excalibur", "netherite_sword", "&#47FFE9&lEXCALIBUR", true,
            "&8× &fZabijając graczy &aulepszasz &fmiecz",
            "&8× &fz każdym ulepszeniem rośnie &cOstrość i obrażenia",
            "&4⚠ &8Ξ &#F5473BZwiększone obrażenia"));
        l.add(new MinestarItem(B, "miecz-smoka-kresu", "netherite_sword", "&#8E44FF&lMiecz Smoka Kresu", false,
            "&8× &fPo kliknięciu prawym", "&8× &frzucasz perłę i &dteleportujesz się&f!"));
        l.add(new MinestarItem(B, "katana-cienia", "netherite_sword", "&#B9A6FF&lKatana Cienia", false,
            "&8× &fPo użyciu &#8E7CC3dashujesz &fw kierunku", "&8× &fw którym patrzysz!"));
        l.add(new MinestarItem(B, "miecz-zamrozenia", "diamond_sword", "&#5AB4FF&lMiecz Zamrożenia", false,
            "&8× &fZamroź przeciwnika na &b3 sekundy"));
        l.add(new MinestarItem(B, "szabla-zwinnosci", "golden_sword", "&#5BE36B&lSzabla Zwinności", false,
            "&8× &fPosiadasz stały efekt &ePośpiechu I"));
        l.add(new MinestarItem(B, "miecz-nietoperza", "iron_sword", "&#FF4D4D&lMiecz Nietoperza", false,
            "&8× &fBijąc &cprzeciwnika &fzwiększasz", "&8× &dbonus obrażeń &f(do &e45%&f)",
            "&8× &fPo walce bonus &cresetuje się"));
        l.add(new MinestarItem(B, "krysztalowy-kij", "stick", "&#FBF9FC&lKRYSZTAŁOWY KIJ", true,
            "&#C6153C• &fPrzedmiot ten posiada zaklęcie &cOdrzut IV"));
        l.add(new MinestarItem(B, "luk-burzy", "bow", "&#7C5CFF&lŁuk Burzy", false,
            "&8× &fPo trafieniu przeciwnika", "&8× &frazimy go &epotężnym piorunem&f!"));
        l.add(new MinestarItem(B, "pogromca-burzy", "golden_axe", "&#4F6BFF&lPogromca Burzy", false,
            "&8× &fPo uderzeniu przeciwnika przywołujemy &epotężną serię piorunów&f."));
        l.add(new MinestarItem(B, "toporek-ogluszenia", "diamond_axe", "&#FFB347&lToporek Ogłuszenia", false,
            "&8× &fPo trafieniu uderza &epiorun &fi", "&8× &fzadaje ogromne obrażenia"));
        l.add(new MinestarItem(B, "mace", "mace", "&#3FB8FF&lMace", false,
            "&8× &fKliknij &eprawy&f, aby się podbić!"));
        l.add(new MinestarItem(B, "kosa-zamiany", "netherite_hoe", "&#5BE36B&lKosa Zamiany", false,
            "&8× &fRzuć śnieżką i po trafieniu &bzamień się miejscami &fz celem"));

        // ---------- NARZEDZIA ----------
        l.add(new MinestarItem(N, "lodowy-kostur", "diamond_shovel", "&#6FD3FF&lLodowy Kostur", false,
            "&8× &fPo kliknięciu prawym rzucamy &3bryłą lodu&f, która",
            "&8× &bzamraża wszystko dookoła &fłącznie z &3trafionym przeciwnikiem&f!"));
        l.add(new MinestarItem(N, "chwytak-przyciagania", "fishing_rod", "&#5FD3E8&lChwytak Przyciągania", false,
            "&8× &fUżyj, aby haczyk &bprzyciągnął cię &fdo miejsca celowania"));
        l.add(new MinestarItem(N, "hak", "fishing_rod", "&e&lHak", false,
            "&8× &7Przyciąga cię w miejsce &crzucenia &7haka"));
        l.add(new MinestarItem(N, "strzykawka-zmniejszenia", "netherite_shovel", "&#5AC8FF&lStrzykawka Zmniejszenia", false,
            "&8× &fZmniejsza rozmiar na &b10s", "&8× &fi daje &bSzybkość II"));
        l.add(new MinestarItem(N, "rozdzka-dezorientacji", "golden_hoe", "&#C6F43C&lRóżdżka Dezorientacji", false,
            "&8× &fPo użyciu na &cprzeciwniku", "&8× &fodwracasz mu kamerę o &e180°"));
        l.add(new MinestarItem(N, "kajdany-grawitacji", "golden_shovel", "&#B8B8B8&lKajdany Grawitacji", false,
            "&8× &fblokujesz skakanie na &e5 sekund"));
        l.add(new MinestarItem(N, "klatka-zywiolowa", "heart_of_the_sea", "&#3FE0A0&lKlatka Żywiołowa", false,
            "&8× &fKliknij &ePPM &fna &cprzeciwnika", "&8× &faby zamknąć go w &bKlatce Żywiołów"));
        l.add(new MinestarItem(N, "wypalacz", "blaze_powder", "&#C9C4B3&lWYPALACZ", false,
            "&fPo kliknięciu na przeciwnika &boznaczamy &fgo", "&fefektem &6wypalacza&f, przez który",
            "&fprzeciwnik &czużywa &fwięcej swoich przedmiotów", "&4&lUwaga! &cPrzedmiot jest jednorazowy"));
        l.add(new MinestarItem(N, "karuzela", "daylight_detector", "&#FF6B6B&lKaruzela", false,
            "&8× &fPo uderzeniu &cprzeciwnika", "&8× &fnadajesz mu efekt &6karuzeli &fna 12 sekund!",
            "&8× &fPrzeciwnik będzie &aobracany &fprzy każdym uderzeniu."));
        l.add(new MinestarItem(N, "lod-na-patyku", "stick", "&b&lLód na Patyku", false,
            "&8× &7Po uderzeniu gracza nadajemy mu oraz", "&8× &7sobie &befekt lewitacji &7na określony czas"));
        l.add(new MinestarItem(N, "gumka", "pink_dye", "&d&lGUMKA", false,
            "&8× &fUsuwa &dblok&f, na który klikniesz", "&aKliknij prawym na blok!"));

        // ---------- RZUCANE I POLA ----------
        l.add(new MinestarItem(R, "granat-uwiezienia", "turtle_scute", "&a&lGranat Uwięzienia", false,
            "&8× &7Po rzuceniu wszyscy gracze w obrębie", "&8× &7kilku kratek zostają złapani w &cpajęczą pułapkę",
            "&8× &4&lUwaga! &cPrzedmiot jest jednorazowy"));
        l.add(new MinestarItem(R, "granat-odepchniecia", "splash_potion", "&b&lGranat Odepchnięcia", false,
            "&8× &7Po wyrzuceniu &bodpycha &7wszystkich graczy wokół"));
        l.add(new MinestarItem(R, "pilka-plazowa", "snowball", "&e&lPiłka Plażowa", false,
            "&8× &7Po trafieniu w gracza &dzamieniamy się &7z nim miejscami", "&aKliknij prawym, aby rzucić"));
        l.add(new MinestarItem(R, "dynamit", "light_gray_dye", "&f&lDYNAMIT", false,
            "&#F99A00• &fDynamitu możesz użyć,", "   &faby &czniszczyć &fwybrany bedrock",
            "&#F99A00• &4&lUwaga! &cPrzedmiot jest jednorazowy", "&aKliknij prawym na bedrock!"));
        l.add(new MinestarItem(R, "bomba", "fire_charge", "&c&lBOMBA", false,
            "&8× &fPo użyciu &cwybuchamy&f, niszcząc", "&8× &fbloki dookoła siebie &e(3x3)"));
        l.add(new MinestarItem(R, "magiczna-perla", "ender_pearl", "&#46CEC1&lMAGICZNA PERŁA", true,
            "&#7D21B5• &fPo rzuceniu &aaktywujemy &fperłę,", "&#7D21B5• &fktóra posiada &d1 z 4 specjalnych &fefektów",
            "&#7D21B5• &4&lUwaga! &cPrzedmiot jest jednorazowy", "&eKliknij lewym, aby zmienić efekt"));
        l.add(new MinestarItem(R, "skorka-od-banana", "yellow_dye", "&#FFE048&lSKÓRKA OD BANANA", false,
            "&8× &fPo uderzeniu przeciwnika, jego przedmioty", "&8× &fw ekwipunku zostają &ewymieszane"));
        l.add(new MinestarItem(R, "zamek-z-piasku", "honeycomb", "&6&lZamek z Piasku", false,
            "&8× &7Po użyciu &6tworzymy &7dookoła", "&8× &7nas &ezamek z piasku &7i zamykamy w nim",
            "&8× &7wszystkich graczy w obrębie na określony czas"));
        l.add(new MinestarItem(R, "pole-smierci", "end_crystal", "&5&lPole Śmierci", false,
            "&8× &7Tworzymy dookoła &6strefę&7, w której", "&8× &7nikt nie może używać ani założyć &9elytry"));
        l.add(new MinestarItem(R, "dzwonek-szkolny", "gold_ingot", "&#75AB82&lDZWONEK SZKOLNY", false,
            "&8× &fPo użyciu w powietrzu tworzymy &bfale hałasu &ftam",
            "&8× &fgdzie się patrzymy a gracze w obrębie nie mogą",
            "&8× &fużywać elytry i zostają &cprzyciągnięci &fw dół",
            "&8× &4&lUwaga! &cPrzedmiot działa tylko wysoko w powietrzu"));
        l.add(new MinestarItem(R, "usuwacz-pajeczyn", "blaze_rod", "&c&lUsuwacz Pajęczyn", false,
            "&8× &7Oczyszcza wszystkie pajęczyny w pobliżu", " ", "&aKliknij prawym, aby użyć"));

        // ---------- INNE ----------
        l.add(new MinestarItem(I, "lampion", "brick", "&6&lLampion", false,
            "&8× &7Po użyciu otrzymujemy &cregenerację &7na kilka sekund"));
        l.add(new MinestarItem(I, "kiel-wampira", "ghast_tear", "&4&lKieł Wampira", false,
            "&8× &7Po użyciu, przez kilka sekund &cleczysz &7się", "&8× &7o &c25% obrażeń &7zadanych przeciwnikowi"));
        l.add(new MinestarItem(I, "serce-wardena", "fermented_spider_eye", "&3&lSerce Wardena", false,
            "&8× &7Po użyciu, osoby wokół dostają &cefekt oślepienia"));
        l.add(new MinestarItem(I, "kokos", "enchanted_golden_apple", "&e&lKokos", false,
            "&8≡ &7Po zjedzeniu otrzymujemy:", "&8↪ &dEfekt regeneracja II (5s)",
            "&8↪ &eEfekt absorpcja II (120s)", "&8↪ &bEfekt szybkość I (10s)", "&aPrzytrzymaj prawy, aby zjeść"));
        l.add(new MinestarItem(I, "kostka-wyroku", "iron_ingot", "&7&lKostka Wyroku", false,
            "&8× &7Po użyciu mamy szansę na otrzymanie", "&8× &7efektu &csiły II &7lub &3spowolnienia I &7na kilka sekund"));
        l.add(new MinestarItem(I, "smoczy-totem", "totem_of_undying", "&#C26BCB&lSMOCZY TOTEM", false,
            "&#C6153C• &fPo zniszczeniu &6totemu &fnasze zdrowie", "&#C6153C• &fzostaje od razu &dzregenerowane &fdo pełna",
            "&#C6153C• &4&lUwaga! &cPrzedmiot jest jednorazowy"));
        l.add(new MinestarItem(I, "plomienna-torba", "paper", "&#E4BB34&lPŁOMIENNA TORBA", false,
            "&8× &fTrzymając torbę w ekwipunku trafiają do niej", "&8× &fwszystkie &ecenne &fprzedmioty z &czabitych graczy",
            "&aKliknij prawym, aby otworzyć!"));
        return l;
    }
}
