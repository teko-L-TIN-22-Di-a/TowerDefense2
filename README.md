# TowerDefense2

## Links

Backlog: https://trello.com/b/9ByzK5IA/towerdefense2
Dokumentation: https://app.diagrams.net/#G1jpd3TReqNAoOjw4dpybRgbRFE9AkgiyE#%7B%22pageId%22%3A%22lHopx5P_3tPeyPCEZyvq%22%7D

## Kurzbeschreibung

Ein Java Projekt, um Swing und AWT kennenzulernen und einen tieferen Einblick in die OOP zu verschaffen.
Dabei handelt es sich um ein Tower Defense Spiel (https://de.wikipedia.org/wiki/Tower_Defense)

## Spielmechanik

Aufgabe in diesem Spiel ist es, auf einer Karte verschiedene Arten von Verteidigungsanlagen (Geschütztürme) zu errichten, die anschliessend mehrere Anstürme unterschiedlicher Gegner daran hindern sollen, die Karte zu durchqueren.

Für jeden eliminierten Gegner erhält der Spieler eine Belohnung, mit welcher er weitere Türme errichten kann, um die steigende Schwierigkeit der Gegner bekämpfen zu können.

Bei diesem Spiel handelt es sich um ein Spielmodus - Einzelspieler.

## Gegner

- Standardgegner - die grundlegendste Gegnerart 
- Schnelle Gegner - Gegner die zwar schneller als die Standardgegner sind, jedoch weniger Trefferpunkte haben
- Boss Gegner - starke einzelne Gegner, die mehr Trefferpunkte und evtl. einen höheren Rüstungswert haben, als die Standardgegner

## Turmtypen

Die Turmtypen werden während der Projektierungsphase erarbeitet. Sie werden sich durch Reichweite, Schaden und Angriffsgeschwindigkeit unterscheiden.
Mit den Startguthaben, die der Spieler am Anfang des Spiels erhält sowie mit den Belohnungen für die eliminierte Gegner soll der Spieler eine Möglichkeit haben, neue Türme zu bauen sowie die bestehenden Türme mit gewissen Upgrades wie Schaden-, Angriffsgeschwindikgeits- oder Reichweiteupgrades nachzurüsten.

|Turmtyp| Beschreibung                                                   |
|-|----------------------------------------------------------------|
|BasicTower| Basisturm, der den Gegner Schaden anfügt                       |
|TeleportingTower| Ein Turm, der Gegner zu einem zufälligen Waypoint teleportiert |
|FreezingTower| Ein Turm, der die Gegner einfrieren lässt                      |

## Kartenlayout

Kartenlayout ist statisch implementiert und beinhaltet soganennte Waypoints.
Die Gegner bewegen sich von einem Waypoint zum Anderen.

## Patterns

Beim implementieren des Spieles werden folgende Patterns verwendet

### MVC

#### Model

Enthält die Daten und die Logik deines Spiels. Hier werden die Spielzustände wie Türme, Gegner und Wellen verwaltet.

#### View

Zeigt den aktuellen Zustand des Modells dem Benutzer an. Es ist das, was der Benutzer sieht (z. B. das Spielfeld, die Türme und die Gegner).

#### Controller

Der Controller verarbeitet die Benutzerinteraktionen (wie Mausklicks oder Tastatureingaben) und steuert das Modell entsprechend. Er fungiert als Vermittler zwischen View und Model.

### Singleton

Das "Singleton"-Pattern wird bei der Spielkonfiguration verwendet, um sicherzustellen dass diese einmalig vorhanden ist.