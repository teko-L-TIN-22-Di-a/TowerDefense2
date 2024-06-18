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

## Kartenlayout

Der Kartenlayout soll folgende Elemente beinhalten:

- Spawn Tile: Auf diesem Kachel werde die Gegner erscheinen
- Finish Tile: Erreicht ein oder mehrere Gegner diesen Kachel, werden die Trefferpunkte des Spielers abgezogen
- Building Tile: Auf diesem Kachel kann ein Turm errichtet und nachgerüstet werden
- Road Tile: Ein Kachel, auf welchem sich die Gegner bewegen dürfen
- Environment Tile: Rein dekoratives Kachel (Wasser, Wald, Sand usw.), keine Interaktionen auf diesem Kachel möglich

Der Kartenlayout wird so einfach wie möglichgehaltet, also erscheinen die Gegner nur an einem Ort und versuchen die Finish-Kachel zu erreichen.
