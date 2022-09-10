# Gilded-Rose-Kata refactoring

[Gilded Rose Requirements Specification](https://github.com/emilybache/GildedRose-Refactoring-Kata/blob/master/GildedRoseRequirements.txt)

## Solution
Refactoring has been done in multiple steps:
- Added unit tests to make sure nothing will break while refactoring
- Cleaned up the code a bit to make it a bit more readable
- Extracted hardcoded strings
- Extracted and simplified some common operations
- Added `Conjured` item
- Implemented `Updaters` to separate the strategy for each item type
- Implemented `UpdateFactory` to retrieve the proper updater based on the item type
- Separated unit tests by item type
