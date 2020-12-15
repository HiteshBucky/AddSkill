const axios = require('axios');
const chalk = require('chalk');

const readline = require('readline').createInterface({
	input : process.stdin,
	output : process.stdout
})

readline.question(`What is your name ?`, name => {
	console.log(`Hi ${name}!`)

	axios.get('https://random-math-quote-api.herokuapp.com/')
  		.then(res => {
  			console.clear();
  			console.log(chalk.red(res.data.message))
  		})

  	readline.close()
})