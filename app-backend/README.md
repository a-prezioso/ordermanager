# Guida all'utilizzo

## Composition applicativo
Questo applicativo è composto da vari layer e tool:

In tutto sono presenti tre microservizi: uno spring boot admin server (che monitora se stesso e il 
microservizio "client", chiamato app-backend), l'app-backend che sostanzialmente contiene tutta la 
logica di business del sistema e l'app-frontend che contiene una ui in angular per vedere gli ordini
(con possibilità di filtro sullo stato dell'ordine stesso).

Sarà possibile lanciare i microservizi (ed un database postgres) utilizzando docker-compose. Non sarà
necessario generare jar o pacchetti di build perchè all'interno dei dockerfile presenti all'interno dei 
microservizi sono già presenti degli step di build.

Il database viene popolato a runtime da uno script presente all'interno dell'applicativo app-backend.
Sempre all'interno dell'applicativo app-backend troverete una cartella "postman" dove sarà possibile
importare un json per generare una collection su postman per testare le chiamate http.

## Requisiti
Gli unici requisiti sono possedere maven sul proprio pc, docker e node per la build di angular. Per
la build ho utilizzato un wsl2 su pc windows, ma non dovrebbero esserci problemi su mac, linux o windows.

## Build
Vi basterà aprire un cmd sulla cartella root del progetto, lanciare il commando `ubuntu` (se avete wsl2
installato su windows) e poi lanciare il comando `docker-compose up` per lanciare tutti i servizi, compreso il db.

## Run
Una volta lanciati i servizi potrete accedere:
1. Frontend: http://localhost
2. Backend: http://localhost:8080
3. Spring boot admin: http://localhost:9090 (login: admin, password: admin)
4. Swagger: http://localhost:8080/swagger-ui/index.html
5. Postgres: http://localhost:5432 (login: myuser, password: mypassword, db: mydb)

