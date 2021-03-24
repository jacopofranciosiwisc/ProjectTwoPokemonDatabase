run: compile
	java Frontend
	@echo "FIXME: *make run* or just *make* should be the default target which compiles (when needed) and executes your code."

compile: Backend.class BackendInterface.class DataReader.class DataReaderInterface.class ExtendedRedBlackTree.class RedBlackTree.class Pokemon.class PokemonInterface.class SortedCollectionInterface.class Frontend.class
	@echo "FIXME: *make compile* should compile the code for your project"

Backend.class: Backend.java
	javac Backend.java

BackendInterface.class: BackendInterface.java
	javac BackendInterface.java

DataReader.class: DataReader.java
	javac DataReader.java

DataReaderInterface.class: DataReaderInterface.java
        javac DataReaderInterface.java

ExtendedRedBlackTree.class: ExtendedRedBlackTree.java
	javac ExtendedRedBlackTree.java

RedBlackTree.class: RedBlackTree.java
        javac RedBlackTree.java

Pokemon.class: Pokemon.java
	javac Pokemon.java

PokemonInterface.class: PokemonInterface.java
        javac PokemonInterface.java

SorterCollectionInterface.class: SortedCollectionInterface.java
	javac SortedCollectionInterface.java

Frontend.class: Frontend.java
	javac Frontend.java

test: testData testBackend testFrontend

testFrontend: FrontEndDeveloperTests.java
	javac FrontEndDeveloperTests.java
	@echo "FIXME: *make testFrontend* should compile (when needed) and run all your team's tests for this application"

testBackend: BackEndDeveloperTests.java
	javac BackEndDeveloperTests.java
	@echo "FIXME: *make testFrontend* should compile (when needed) and run all your team's tests for this application"

testData: DataWranglerDeveloperTests.java
	javac DataWrangelerDeveloperTests.java
	@echo "FIXME: *make testFrontend* should compile (when needed) and run all your team's tests for this application"

clean:
	$(RM) *.class
