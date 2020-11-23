#############################
##
##	Sample 1: HelloWorld
##
## Demonstrates:
## Manually compiling, command-line arguments, StringBuilder, System.out.println
##
##############################

Prep:
mkdir target

Compile:
> javac -d target/ src/org/cjf/demo/HelloWorld.java 

Run Examples:
> java -cp target/ org.cjf.demo.HelloWorld

> java -cp target/ org.cjf.demo.HelloWorld Buddy

Fun with Shell Interpolation:
> java -cp target/ org.cjf.demo.HelloWorld "shell-interpolated var: $HOME"

> java -cp target/ org.cjf.demo.HelloWorld 'as-is: $HOME'
