const app = require('express')();
const moment = require('moment');
const events = require('events');
const fs = require('fs');
const path = require('path')
require('dotenv').config();



var eventEmitter = new events.EventEmitter();




/* 
	Listeningn for createFolders
	We will create folder based on mode
*/

eventEmitter.on('createFolders', () => {

	fs.mkdir(path.join(__dirname, `${process.env.NODE_ENV}/src` ), { recursive: true }, (err) => { 
	    if (err) return console.error(err); 
	});

	fs.mkdir(path.join(__dirname, `${process.env.NODE_ENV}/des` ), { recursive: true }, (err) => { 
	    if (err) return console.error(err); 
	});

})



/*
	Listening for createSourceFile
	We will use moment for current date and time, which will be our filename.

*/
eventEmitter.on('createSourceFile', () => {
    fs.writeFile(`${__dirname + `/${process.env.NODE_ENV}/src`}/${moment().format('YYYY_MM_DD_HH_MM_SS')}.txt`, 'Hello Source world', function (err) {
        if (err) console.log('Error!! file not fined')
        else console.log('File created successfully')
    })
})



/*	
	Listeningn for createDestinationFile
	First check we are asked to use stream or not by checking the argv
	if stream -> 
		then simply create a write stream and write some data.
		Listen for some other events
	else
		create a new file and some data

*/

eventEmitter.on('createDestinationFile', () => {

	if(process.argv[3] == "true"){

		var writerStream = fs.createWriteStream(`${__dirname + `/${process.env.NODE_ENV}/des`}/${moment().format('YYYY_MM_DD_HH_MM_SS')}.txt`);

		writerStream.write("Hello Moto!!",'UTF8'); //Write the data to stream with encoding to be utf8

		writerStream.end();				 //Mark the end of file

		writerStream.on('finish', () => console.log("Write completed."));

		writerStream.on('error', () => console.log(err.stack));
	}
	else{
		//Async
		fs.writeFile(`${__dirname + `/${process.env.NODE_ENV}/des`}/${moment().format('YYYY_MM_DD_HH_MM_SS')}.txt`, 'Hello Destination  world', function (err) {
		    if (err) console.log('Error!! file not fined')
		    else console.log('Des File created successfully')
		})
		//Sync
		// fs.writeFileSync(`${__dirname + `/${process.env.NODE_ENV}/des`}/${moment().format('YYYY_MM_DD_HH_MM_SS')}.txt`, 'Hello world')
	}
})


/*
	Emit for different events
*/

eventEmitter.emit('createDestinationFile')

eventEmitter.emit('createFolders');

eventEmitter.emit('createSourceFile')



process.on('SIGINT', () => {
    console.log('Received Interrupt Signal');
    process.exit()
});
