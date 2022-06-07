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

Created by Sebastian Brzovic