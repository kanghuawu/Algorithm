# Java Must Know

```java
System.out.println(Integer.MIN_VALUE);    // -2147483648
System.out.println(Integer.MAX_VALUE);    //  2147483647
System.out.println(Integer.MIN_VALUE-1);  //  2147483647
System.out.println(Integer.MAX_VALUE+1);  // -2147483648
```

## Memory

### Primitive

|type|bytes|
|:-:|:-:|
|boolean|1|
|byte|1|
|char|2|
|int|4|
|float|4|
|long|8|
|double|8|

### Primitive Array

|type|bytes|
|:-:|:-:|
|char[]|2N + 24|
|int[]|4N + 24|
|double[]|8N + 24|
|char[][]|~2MN|
|int[][]|~4MN|
|double[][]|~8MN|

### Object
* Object overhead: 16 bytes.
* Reference: 8 bytes.
* Padding: Each object uses a multiple of 8 bytes.
