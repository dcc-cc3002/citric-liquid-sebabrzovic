<!-- 1.0.3-b1 -->
# 99.7% Citric Liquid

Base code for CC3002's *99.7% Citric Juice* Project.

The project consists in creating a (simplified) clone of the game **100% Orange Juice**
developed by [Orange_Juice](http://daidai.moo.jp) and distributed by 
[Fruitbat Factory](https://fruitbatfactory.com).


Project 99.7% citric liquid

This project consist in duplicating a simplified version of the game "100% Orange Juice"

To achieve this result we will be separating the project in three steps:
The first one, which is the one reciently devoleped, will consist in the creation of the Units and Panels.

Units:

In this game there are 3 types of units, Player, Wild and Boss. They all share atributes such as Hp, Stars,
atk, edv, def, and Name. Atk, edv and def are integers, they can be positive or negative however Hp, Stars
can only be positive. For the Players, they have other atributes, such as Norma Level, vicories (both positive
integers), the also have an own homepanel id that is used to compare when it lands in a homepanel. It also has
a Norma goal where it says whether it can pass a norma by wins or stars. Finally it has the information of the
current panel it is on.

Every unit has its own method of setting its atributes, getting them and changing them with its respective rules.


Panels:

There are various diferent panels, every one has its own rules onces a player lands in there, all of the panels are
subclass of the abstract class Panel, there it contains the methods of setting players (those who land in the panel)
setting neighboor panels, setting an ID. And last but not least it contains the method activatedBy, which is defined
in each panel with its own rules. That will be what diferenciates each panel.

For the second part of the project, it will be devided in 2 big parts, one that will be the controller, and the second
would be the phases.

Phases:
In this section the state pattern design was implemented by creating 8 phases where the player can be stationed:
-Start Phase: Where the player iniciates its turn. He can then move to the recovery phase or Moving phase:
-Recovery Phase: Phase where the player recovers itself
-Moving Phase: Phase where the player moves the amount of steps the dice rolled.
- Decision, WaittoBattle, WaittoHome phases: Each one is where the player has to face a decision weather it is choosing
where to move, or fight or just stay at home.
- Stop Phase: Phase created to keep the player still during the turn in case it is needed.
- EndTurn Phase: Final phase

Controller:
This section is the most important for it includes the creation of all units, panels necessary. It also includes the 
methods necessary for the movement of each player and also how to set the owner of the turn when needed. It also 
includes methods that make the base for the game, such as the conditions to finish a turn, to set the norma goal, get 
and set the chapters. And finally it has the methods to make an attack possible, and a possible counterattack, that way
the game can work properly. It also uses the observer Pattern creating listeners for each case, so it can be notified in
three cases, when it lands in its homePanel, when it has the possibility to battle a unit or a player and finally when 
it has more than one possible step. All this is at the same time connected to phases.


Created by Sebastian Brzovic