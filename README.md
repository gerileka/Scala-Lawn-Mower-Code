# Projet-Scala-Lawn Mower
_Introduction to Scala Academic Project. Work done with my team mate [Louis Grunenwald](https://github.com/LouisGrunenwald)._

___Explanation in the code will be in French.___

---

## Features #
This Scala program implements an automatic lawn mowing for rectangular surfaces.
* Each mower can be programmed to cover the entire surface.
* The position of the mower is represented by a combination of coordinates (x, y) and a letter indicating the orientation according to the English cardinal notation (N, E, W, S). The lawn is divided into a grid to simplify navigation.
* To control the mower, we send him a simple sequence of letters. The possible letters are "D", "G" and "A". "D" and "G" rotate the mower 90 ° right or left respectively, without moving it. "A" means that the mower is moved one step in the direction it faces, and without changing its orientation.
* If the position after movement is outside the lawn, the mower will not move, keep its orientation and process the next command.
* Each mower moves sequentially, which means that the second mower moves only when the first mower has performed its entire series of instructions.
* When a mower completes a series of instructions, it communicates its position and orientation.

## Input file #
To program the mower, it is provided with an input txt.file built as follows: 
* The first line corresponds to the coordinates of the maximum if the loans, for example (5,5), so we will have a matrix with the following coordinates (0,0) - (5,5)
* Each mower has two lines: the first line gives the starting position of the mower, as well as its orientation. 
* The position and orientation are provided in the form of 2 digits and a letter,  separated by a space the second line is a series of instructions ordering the mower to explore the lawn. 
* The instructions are a sequence of characters without spaces.


### Our input file ##
* Content of the input file

```raw
5 5
1 2 N
GAGAGAGAA
3 3 E
AADAADADDA
```

  * Results:

```
New lawnmowers positions:
1 3 N
5 1 E
```
