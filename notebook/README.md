# Cheatsheet

## Memory
|type|bytes|
|:-:|:-:|
|boolean|1|
|byte|1|
|char|2|
|int|4|
|float|4|
|long|8|
|double|8|
|char[]|2N + 24|
|int[]|4N + 24|
|double[]|8N + 24|
|char[][]|~2MN|
|int[][]|~4MN|
|double[][]|~8MN|

* Object overhead. 16 bytes.
* Reference. 8 bytes.
* Padding. Each object uses a multiple of 8 bytes.

## Graph
* Inbound and outbound


## String
### Radix sort
* LSD sort
* MSD sort
* 3-way radix sort
  * Combine of MSD and 3-way quicksort
* Suffix sort (enable fast substring search)
  * Substring + MSD sort
  * Manber-Myers algorithm
### Tries
* R-way tries
* Ternary search tries
  * R-way tries + Red-Black search trees
* TST with R2
### Substring search
* KMP (Knuth-Morris-Pratt) substring search
  * Deterministic finite state automaton (DFA)
