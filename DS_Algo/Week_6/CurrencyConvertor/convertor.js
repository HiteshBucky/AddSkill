var data = {
	"Bitcoin" : 1360908.20,
	"United States Dollar" : 74.15,
	"United Arab Emirates Dhiram" : 20.18,
	"Saudi Riyal" : 19.17,
	"Pakistan Rupee" : 0.46,
	"Indian Rupee" : 1,
	"Chiness Yuan" : 11.30,
}


function myFunction(){
    var amount = +document.getElementById('amount').value
    var curr_from = document.getElementById('from_currency').value
    var curr_to = document.getElementById('to_currency').value
    var output = document.getElementById('answer')

    var answer = (data[curr_from] * amount)/data[curr_to] ;

    console.log((data[curr_from] * amount))

    console.log( " data[curr_from]" + data[curr_from] + " data[curr_to] : " + data[curr_to])

    output.innerHTML = answer;

    return false;
}