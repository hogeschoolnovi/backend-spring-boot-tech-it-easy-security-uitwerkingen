# Opdrachtbeschrijving opdracht 2 

## Inleiding

Je bent net begonnen als developer bij een bedrijf genaamd Tech It Easy, dat TV's verkoopt. Tijdens de cursus Spring Boot ga jij een backend applicatie voor hen programmeren. De winkel heeft een inventaris van televisies die moet worden bijgehouden. Na iedere les gaan we deze applicatie een stukje verder uitbouwen in de vorm van huiswerk. Zo krijgen we stap-voor-stap meer ervaring in het bouwen van een backend applicatie. Aan het einde van de cursus zullen we een werkende Tech It Easy backend hebben!

## Recap van vorige opdracht

Je hebt de vorige les een begin gemaakt voor de applicatie voor je werkgever TechItEasy. Je hebt een controller aangemaakt met verschillende endpoints. Deze kunnen aangeroepen worden via een frontend. Jij maakt hiervoor gebruik van Postman. Omdat we niet weten of alles bestaat wat de gebruiker opvraagt heb je ook een exception controller gemaakt en een RecordNotFound exception. Na een nieuwe les Spring boot ben je klaar voor de volgende stap van het bouwen van je applicatie. 

## Randvoorwaarden

- Het project bevat, op de juiste plaats in de map-structuur, een map genaamd `Models`;
- Het project bevat, op de juiste plaats in de map-structuur, een map genaamd `Repositories`;
- Het project bevat een `Television` in de map `Models`;
- Het project bevat een `TelevisionRepository`;
- Het project bevat de volgende dependencies: 
  - `Spring Web`
  - `Spring Data Jpa`
  - `PostgreSQL Driver`
- De **Application.properties** bevat de properties uit hoofdstuk 9.2 van de cursus Spring Boot(met aangepaste namen)
- De **TelevisionRepository** extends JpaRepository met de juiste parameters
- De **Television** bevat:
  -de attributen:
    - Long id (incl. annotaties id en generatedValue)
    - String type
    - String brand
    - String name
    - Double price
    - Double availableSize
    - Double refreshRate
    - String screenType
    - String screenQuality
    - Boolean smartTv
    - Boolean wifi
    - Boolean voiceControl
    - Boolean hdr
    - Boolean bluetooth
    - Boolean ambiLight
    - Integer originalStock
    - Integer sold
  - default constructor
  - constructor
  - alle getters en setters
  
### Belangrijk
- Bij het inleveren van deze opdracht is deze applicatie nog niet functioneel, hier hebben we meer kennis over andere technieken voor nodig.
- Laat de _application.properties_ overeenkomen met de gegevens van `PgAdmin`
- Je mag de volgende return fragmenten gebruiken:
  - `ResponseEntiteit.ok()`
  - `ResponseEntiteit.created()`
  - `ResponseEntiteit.noContent()`

Door het gebruik van deze return fragmenten zul je de volgende foutmeldingen tegenkomen:
- `incompatible types found`
- `created .... cannot be applied to ()`
Deze mag je negeren tijdens het maken van deze opdracht.

## Stappenplan
_Let op_: het is uitdagender om jouw eigen stappenplan te maken. Mocht je niet zo goed weten waar je moet beginnen, kun je onderstaand stappenplan volgen:
1. Voeg de benodigde dependencies toe aan je _POM.xml_ en laat `Maven` deze instaleren
2. Voeg aan de _application.properties_ de benodigde properties toe
3. Maak een nieuwe database aan in `PgAdmin` (zorg dat de naam overeenkomt met de properties in je _application.properties)
4. Maak een nieuwe map aan in je project voor `Models`
5. Maak een nieuwe klasse genaamd `Television`
6. Voeg de annotatie **@Entity** toe aan de klasse
7. Voeg de juiste _attributen_ toe aan de klasse
8. Voeg de beide _constructors_ toe aan de klasse
9. Voeg alle _getters & setters_ toe aan de klasse
10. Maak een nieuwe map aan in je project voor `Repositories`
11. Voeg aan deze map een nieuwe klasse toe genaamd `TelevisionRepository`
12. Extend de _repository_ met de `JpaRepository` en geef de juiste attributen mee 
