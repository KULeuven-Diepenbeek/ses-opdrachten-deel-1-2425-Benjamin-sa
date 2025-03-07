MAINCLASS = App
JAR = app.jar

.PHONY: compile clean run jar

compile:
	@echo "compiling ..."
	javac -d ./build *.java model/*.java
	@echo "Done compiling."

clean:
	@echo "cleaning ..."
	-rm -R ./build/*
	@echo "Done cleaning."

run: compile jar
	@echo "running program $(JAR) ...\n---------------"
	@cd ./build && java -cp "$(JAR)" $(MAINCLASS)
	@echo "---------------\nProgram exited."

jar: compile
	@echo "Packaging to jar ..."
	cd ./build && jar cvfe $(JAR) $(MAINCLASS) *
	@echo "Done packaging."