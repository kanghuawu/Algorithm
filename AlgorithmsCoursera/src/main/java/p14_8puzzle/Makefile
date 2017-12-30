clean:
	find . -name "*.class" -exec rm -rf {} \;
	rm *.zip

zip:
	zip 8puzzle.zip Board.java Solver.java

board:
	java-algs4 Board

solver:
	java-algs4 Solver $(FILE)

compile-all:
	javac-algs4 *.java

run-all:
	java-algs4 PuzzleChecker ../test/puzzle*.txt