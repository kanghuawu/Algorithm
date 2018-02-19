# Algorithms Course

This repository records the assignments I completed following [Algorithms, Part 1](https://www.coursera.org/learn/algorithms-part1) and [Algorithms, Part 2](https://www.coursera.org/learn/algorithms-part2) from Coursera. These two courses are identical to [Algorithm course](http://www.cs.princeton.edu/courses/archive/fall17/cos226/) at Pricenton. 

# Dependencies

* Java 8
* Maven
* algs4

```shell
mvn deploy:deploy-file -Durl=file:./lib/ \
-Dfile=../../algs4/target/algs4-1.0.0.0.jar \
-DgroupId=edu.princeton.cs \
-DartifactId=algs4 \
-Dpackaging=jar \
-Dversion=1.0.0.0
```

# Resources

* Companion [repository](https://github.com/kevin-wayne/algs4)
* Advanced algorithm course, [cos426](https://www.cs.princeton.edu/~wayne/kleinberg-tardos/) from Princeton

# Assignments

* Percolation - Union find
* Deques and Randomized Queues - Java Generic Deque and Queues
* Pattern Recognition
* 8 Puzzle
* Kd-Tree
* Seam Carving
* Baseball Elimination
* Boggle
* Burrow
