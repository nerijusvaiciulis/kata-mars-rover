Mars Rover Kata
===============

# Overview
Please write code delivering the requirements that follow. Write code that you would be happy
delivering to a paying client, keeping in mind the simplicity comments below.

You should not find this test to be particularly difficult. It is designed to be a straightforward coding
exercise and it should take you around 1-2 hours. One thing we’re interested in is to see which
compromises you make to stay in this sort of timeframe. It’s more important that we can see how the
development would continue than for every feature to be present.

# What we are looking for:

## Test Coverage: 
The solution should be developed “test-first”, and should have excellent unit tests
and test coverage.

## Simplicity: 
We value simplicity as an architectural virtue and a development practice. Solutions
should reflect the difficulty of the assigned task, and should not be overly complex. Layers of
abstraction, patterns, or architectural features that aren’t called for should not be included.

## Self-explanatory code: 
The solution you produce must speak for itself. Multiple paragraphs
explaining the solution are a sign that it isn’t straightforward enough to understand purely by reading
code, and are not appropriate.

# Deliverable

## Include a readme: 
Please include a readme file in the root of the project which states any
requirements and commands needed to run and test the code. Assume the reviewer is unfamiliar
with your choice of framework and/or build tools and maybe using a different IDE.

Please include the version from the footer of this document in the README as well

# Problem Description
You are part of the team that explores Mars by sending remotely controlled vehicles to the surface of
the planet. Write an idiomatic piece of software that translates the commands sent from earth to
actions executed by the rover yielding a final state..
- When the rover touches down on Mars, it is initialised with its current coordinates and the direction it is facing. 
- These could be any coordinates, supplied as arguments (x, y, direction) e.g. (4, 2, EAST).

## Part I
The rover is given a command string which contains multiple commands. This string must then be
broken into each individual command and that command then executed. Implement the following
commands:
- F -> Move forward on current heading
- B -> Move backwards on current heading
- L -> Rotate left by 90 degrees
- R -> Rotate right by 90 degrees
An example command might be FLFFFRFLB
- Once the full command string has been followed, 
  the rover reports it's current coordinates and heading in the format (6, 4) NORTH

## Approach
You should tackle this problem as you would any real world requirement that would be shipped as
part of a real product. You should showcase how you work and the way you decompose a problem
into smaller pieces.