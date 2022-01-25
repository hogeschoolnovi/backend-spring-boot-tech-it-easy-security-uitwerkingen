# Opdrachtbeschrijving

## Inleiding

Je bent net begonnen als developer bij een bedrijf genaamd Tech It Easy, dat TV's verkoopt. Tijdens de cursus Spring Boot ga jij een backend applicatie voor hen programmeren. De winkel heeft een inventaris van televisies die moet worden bijgehouden. Na iedere les gaan we deze applicatie een stukje verder uitbouwen in de vorm van huiswerk. Zo krijgen we stap-voor-stap meer ervaring in het bouwen van een backend applicatie. Aan het einde van de cursus zullen we een werkende Tech It Easy backend hebben!

## Spring Boot Applicatie Opzetten

Je gaat via de Spring Boot Initialzr een project aanmaken, waarbij je gebruikt maakt van de volgende dependency:
- Spring Web

Gedurende de cursus Spring Boot zal het langzamerhand duidelijk worden waarom je deze dependency nodig hebt. Voor nu mag je dit gewoon van ons aannemen! 

## Randvoorwaarden

- Het project bevat, op de juiste plaats in de map-structuur, een map genaamd `Controllers`;
- Het project bevat, op de juiste plaats in de map-structuur, een map genaamd `Exceptions`;
- Het project bevat een `TelevisionsController`;
- Het project bevat een `ExceptionController`;
- Het project bevat een `RecordNotFoundException`;
- De **TelevisionsController** bevat: 
  - een GET-request voor alle televisies
  - een GET-request voor 1 televisie
  - een POST-request voor 1 televisie
  - een PUT-request voor 1 televisie
  - een DELETE-request voor 1 televisie
- De **ExceptionController** bevat:
  - een exceptionhandler
- De **RecordNotFoundException** bevat:
  - een default exception 
  - een exception met message

### Belangrijk
- Bij het inleveren van deze opdracht is deze applicatie nog niet functioneel, hier hebben we meer kennis over andere technieken voor nodig.
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
1. Zet een nieuw project op via Spring Boot Initialzr genaamd TechItEasy
2. Maak een nieuwe map aan in je project genaamd Controllers
3. Maak een nieuwe map aan in je project genaamd Exceptions
4. Maak een nieuwe klasse aan in de map Controllers voor de TelevisionController
5. Voorzie de klasse van de juiste annotatie
6. Maak in de klasse de gevraagde requests met de juiste response entities
7. Maak een nieuwe klasse aan in de map Controllers voor de ExceptionController
8. Voorzie de klasse van de juiste annotatie
9. Maak in de klasse een exceptionHandler met de juiste notatie en response entitiy
10. Maak een nieuwe klasse aan in de map Exceptions
11. Extend de klasse met de RunTimeException
12. Vul de klasse aan de hand van het voorbeeld van hoofdstuk 5.11 van de cursus Spring Boot

