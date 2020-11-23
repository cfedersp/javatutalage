#############################
##
##	Intro
## ReplaceStdIn
##
## Demonstrates:
## Reading Standard Input using a BufferedReader, while loop, HashMap, String array, String replace, custom Exception, Regular Expression
##
## Suggests the immportance of using a build tool, like maven
##############################

Prep:
> mkdir target

Compile:
> javac -d target/ src/org/cjf/demo/ReplaceStdIn.java src/org/cjf/demo/exception/InvalidInputException.java

Run Examples: (Ctl-D is the same as End-of-File and will stop processing)
> java -cp target/ org.cjf.demo.ReplaceStdIn
hello

> java -cp target/ org.cjf.demo.ReplaceStdIn
type whatever input you want
Ctl-D to exit

> cat loremipsum.txt | java -cp target/ org.cjf.demo.ReplaceStdIn

