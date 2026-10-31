# Minestar SkyPvP Items (Fabric 1.21.4, tylko klient)

Menu z przedmiotami eventowymi Minestar. Bierzesz przedmiot do ręki, otwierasz menu (domyślnie **J**),
klikasz item — nazwa, opis, połysk i model zmieniają się **tylko u Ciebie** (serwer nic o tym nie wie).

## Klawisz
Domyślnie J. Zmiana: Opcje -> Sterowanie -> kategoria "Minestar SkyPvP Items" -> "Otwórz menu".

## Wymagania
Minecraft 1.21.4, Fabric Loader 0.16+, Fabric API 0.119.2+1.21.4, Java 21.

## Jak zbudować jar
1. Zainstaluj JDK 21 (np. Temurin) i Gradle 8.12+ (albo skopiuj `gradlew` z szablonu Fabric:
   https://github.com/FabricMC/fabric-example-mod).
2. W tym folderze:  `gradle build`  (albo `./gradlew build`)
3. Jar będzie w `build/libs/minestaritems-1.0.0.jar` (NIE bierz pliku `-sources`).
4. Wrzuć go do `.minecraft/mods` razem z Fabric API.

## Edycja itemów
Po pierwszym uruchomieniu powstaje `.minecraft/config/minestaritems.json`.
Pole `material` = bazowy przedmiot (np. "netherite_sword"), `name`/`lore` = kody `&a`, `&l`, `&#RRGGBB`.

## Dokladne tekstury z serwera
Tekstury itemow siedza w paczce zasobow serwera, wiec mod kopiuje je z prawdziwego itemu:
1. Wejdz na serwer (paczka sie zaladuje) i wez do reki PRAWDZIWY item.
2. J -> na dole kliknij "Tryb: zakladanie..." (zmieni sie na ZAPAMIETYWANIE WYGLADU).
3. Kliknij ten sam item w menu (np. Excalibur). Mod zapisze jego teksture.
4. Kliknij tryb jeszcze raz (powrot), wez zwykly przedmiot do reki i kliknij item w menu.
