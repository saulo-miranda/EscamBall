all:
	java -jar out/artifacts/Server_jar/Escamball.jar &
	java -jar out/artifacts/Client_jar/Escamball.jar

server:
	java -jar out/artifacts/Server_jar/Escamball.jar
	
client:
	java -jar out/artifacts/Client_jar/Escamball.jar
