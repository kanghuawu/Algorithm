package:
	mvn clean package

move-encode:
	java -cp target/algorithms-coursera-1.0-SNAPSHOT.jar p25_burrows.MoveToFront - < $(DIR) | java -cp ~/Projects/algs4/target/algs4-1.0.0.0.jar: edu.princeton.cs.algs4.HexDump 16

move-encode-decode:
	java -cp target/algorithms-coursera-1.0-SNAPSHOT.jar p25_burrows.MoveToFront - < $(DIR) | java -cp target/algorithms-coursera-1.0-SNAPSHOT.jar p25_burrows.MoveToFront +

burrow-encode:
	target/algorithms-coursera-1.0-SNAPSHOT.jar: p25_burrows.BurrowsWheeler - < $(DIR) | java -cp ~/Projects/algs4/target/algs4-1.0.0.0.jar: edu.princeton.cs.algs4.HexDump 16

burrow-encode-decode:
	java -cp target/algorithms-coursera-1.0-SNAPSHOT.jar: p25_burrows.BurrowsWheeler - < $(DIR) | java -cp target/algorithms-coursera-1.0-SNAPSHOT.jar: p25_burrows.BurrowsWheeler +