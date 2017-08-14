clean:
	find . -name "*.class" -exec rm -rf {} \;
	
clean-zip:
	rm *.zip

zip:
	zip kdtree.zip PointSET.java KdTree.java

compile-pt:
	javac-algs4 PointSET.java

run-pt:
	java-algs4 PointSET

compile-kd:
	javac-algs4 KdTree.java

run-kd:
	java-algs4 KdTree

run-nearest:
	java-algs4 NearestNeighborVisualizer $(FILE)

compile-all:
	javac-algs4 *.java
