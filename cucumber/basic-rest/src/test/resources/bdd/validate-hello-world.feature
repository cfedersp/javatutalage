@HelloWorld
# Label your Features and Scenarios with tags that reflect the functionality that is being tested.
Feature: Validate Hello World

Background:

Scenario:
	Given Request greeting
	Then Response field "message" contains "greeting"