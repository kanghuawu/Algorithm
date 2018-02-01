# Java 9 cheatsheet

## Default Method Resolution

1. Classes always win. A method declaration in the class or a superclass takes prior- ity over any default method declaration.
2. Otherwise, sub-interfaces win: the method with the same signature in the most specific default-providing interface is selected. (If B extends A, B is more specific than A).
3. Finally, if the choice is still ambiguous, the class inheriting from multiple inter- faces has to explicitly select which default method implementation to use by overriding it and calling the desired method explicitly.

> from Java 8 In Action
