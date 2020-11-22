/*				Question 1
	Multiply Two Decimals with JavaScriptPassed
*/
var product = 2.0 * 0.0;






/*				Question 2
	Use Bracket Notation to Find the Nth-to-Last Character in a String
*/

var lastName = "Lovelace";

var secondToLastLetterOfLastName = lastName[lastName.length - 2];






/*				Question 3
	Chaining If Else Statements

	Write chained if/else if statements to fulfill the following conditions:
	num < 5 - return "Tiny"
	num < 10 - return "Small"
	num < 15 - return "Medium"
	num < 20 - return "Large"
	num >= 20 - return "Huge"

*/

function testSize(num) {
  if(num < 5) return "Tiny";
  else if(num < 10) return "Small";
  else if(num < 15) return "Medium";
  else if(num < 20) return "Large";
  else if(num >= 20) return "Huge";
}

testSize(7);













/*
	Question 4 : Golf Code

	In the game of golf each hole has a par meaning the average number of strokes a golfer is expected to make in order to sink the ball in a hole to complete the play. Depending on how far above or below par your strokes are, there is a different nickname.

	Your function will be passed par and strokes arguments. Return the correct string according to this table which lists the strokes in order of priority; top (highest) to bottom (lowest):
*/

var names = ["Hole-in-one!", "Eagle", "Birdie", "Par", "Bogey", "Double Bogey", "Go Home!"];
function golfScore(par, strokes) {
  if (strokes == 1) return names[0];
  else if (strokes <= par - 2) return names[1];
  else if (strokes == par - 1) return names[2];
  else if (strokes == par) 	   return names[3];
  else if (strokes == par + 1) return names[4];
  else if (strokes == par + 2) return names[5];
  else if (strokes >= par + 3) return names[6];
}

console.log(golfScore(5, 4));











/*
	Question 5 : Counting Cards
	You will write a card counting function. It will receive a card parameter, which can be a number or a string, and increment or decrement the global count variable according to the card's value (see table). The function will then return a string with the current count and the string Bet if the count is positive, or Hold if the count is zero or negative. The current count and the player's decision (Bet or Hold) should be separated by a single space.
*/

var count = 0;
function cc(card) {
	if(card == 2 || card == 3 || card == 4 || card == 5 || card == 6)
		count++;
	else if(card == 10 || card == 'J' || card == 'Q' || card == 'K' || card == 'A')
		count--;

	return count > 0 ? count + " Bet" : count + " Hold";
}

cc(1);
cc("A");
cc('A');









/*
	Question 6 : Using Objects for LookupsPassed

	Convert the switch statement into an object called lookup. Use it to look up val and assign the associated string to the result variable.

*/

function phoneticLookup(val) {
  var result = "";

  var data = {
    alpha : "Adams",
    bravo : "Boston",
    charlie : "Chicago",
    delta : "Denver",
    echo : "Easy",
    foxtrot : "Frank",
  }
  return data[val];
}

phoneticLookup("charlie");








/*
	Question 7 : Replace Loops using Recursion
	Write a recursive function, sum(arr, n), that returns the sum of the first n elements of an array arr.
*/

function sum(arr, n) {

  if(n <= 0)
    return 0;

  return arr[n-1] + sum(arr, n-1);
}
