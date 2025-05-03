# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

---

## Feature test 1

This will be a test of the player movement system.

### Test Data To Use

The data used in this test will be the current location the player is at, combined with the connections of that location.

### Expected Test Result

If the entered text is a valid connection to the current location, it should change that to the new current location. If the entered text not a valid connection to the current location, it should just reset the text entry area instead

---

## Feature test 2

This will be a test of the fight button.

### Test Data To Use

The data used in this test will be the current location the player is at, and the current state of an item (Whether it is acquired or not)

### Expected Test Result

If the player is in an area where there is an umbilical cord, they should be able to "fight" its guardian to obtain it, this should not work if the player already has that specific cord, or if they do not have the specific cord required.

---

## Feature test 3

This will be a test of the check button

### Test Data To Use

The data used in this test will be the current location the player is at, and the current state of an item (Whether it is acquired or not)

### Expected Test Results

If the player is in an are where there is an umbilical cord, they should be able to find out this information by using the check button. They should get a different response if there is no cord in the area, or if they have already claimed that cord via the fight button

---

## Feature test 4

This will be a test of the item button

### Test Data To Use

The data used in this test will be the names of the items, along with the current state they're in (acquired or not acquired). 

### Expected Test Results

This should update when the player obtains cords.

---

## Feature test 5

This will be a test of the lamp button

### Test Data To Use

The data used in this test will be the number of cords acquired, which are kept track of via the item menu, and in the "count" variable

### Expected Test Results

This should allow the lamp button to be pressed if the player has all four umbilical cords, showing a win message followed by the program ending once they close it

---
